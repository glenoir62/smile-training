
package com.gleo.groupphoto.web.portlet.action;

import com.gleo.groupphoto.web.constants.GroupPhotoPortletKeys;
import com.gleo.groupphoto.web.search.UserDisplayTerms;
import com.gleo.groupphoto.web.search.UserSearch;
import com.liferay.portal.kernel.dao.search.SearchContainer;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCRenderCommand;
import com.liferay.portal.kernel.search.Field;
import com.liferay.portal.kernel.search.Hits;
import com.liferay.portal.kernel.search.Indexer;
import com.liferay.portal.kernel.search.IndexerRegistryUtil;
import com.liferay.portal.kernel.search.QueryConfig;
import com.liferay.portal.kernel.search.SearchContext;
import com.liferay.portal.kernel.search.SearchContextFactory;
import com.liferay.portal.kernel.search.SearchException;
import com.liferay.portal.kernel.search.SearchResult;
import com.liferay.portal.kernel.search.SearchResultUtil;
import com.liferay.portal.kernel.search.Sort;
import com.liferay.portal.kernel.search.SortFactoryUtil;
import com.liferay.portal.kernel.service.UserLocalServiceUtil;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.PortalUtil;
import com.liferay.portal.kernel.util.WebKeys;
import com.liferay.portal.kernel.workflow.WorkflowConstants;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;

import javax.portlet.PortletURL;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import org.osgi.service.component.annotations.Component;

/**
 * @author guillaumelenoir
 *
 */
@Component(property = { "javax.portlet.name=" + GroupPhotoPortletKeys.GROUP_PHOTO,
	"mvc.command.name=/",
	"mvc.command.name=/groupphoto/view" })
public class ViewMVCRenderCommand implements MVCRenderCommand {

    /**
     * GroupPhotoController Logger.
     */
    protected static Log LOGGER = LogFactoryUtil.getLog(ViewMVCRenderCommand.class);

    @Override
    public String render(RenderRequest renderRequest, RenderResponse renderResponse) {

	PortletURL iteratorURL = renderResponse.createRenderURL();

	// create search container
	SearchContainer<User> searchContainer = new UserSearch(renderRequest, iteratorURL);
	ThemeDisplay themeDisplay = (ThemeDisplay) renderRequest.getAttribute(WebKeys.THEME_DISPLAY);

	List<User> users = new ArrayList<User>();
	int total = 0;
	int start = searchContainer.getStart();
	int end = searchContainer.getEnd();

	// Get indexer
	Indexer<User> indexer = IndexerRegistryUtil.nullSafeGetIndexer(User.class);

	// create search context
	SearchContext searchContext = createSearchContextFromRequest(renderRequest, searchContainer, themeDisplay,
		start, end);

	Hits hits = null;
	
	try {
	    hits = indexer.search(searchContext);
	} catch (SearchException se) {
	    if (LOGGER.isDebugEnabled()) {
		LOGGER.debug(se);
	    }
	    LOGGER.error("SearchException : impossible to search users");
	}

	total = searchUser(renderRequest, renderResponse, themeDisplay, users, total, hits);

	searchContainer.setTotal(total);
	searchContainer.setResults(users);
	
	renderRequest.setAttribute("searchUserContainer", searchContainer);
	renderRequest.setAttribute("portletURL", searchContainer.getIteratorURL());
	renderRequest.setAttribute("userDetailsPortletId", GroupPhotoPortletKeys.USER_DETAILS);

	return "/groupphoto/jsp/view.jsp";
    }

    /**
     * Create Search Context From Request
     * 
     * @param renderRequest
     * @param searchContainer
     * @param themeDisplay
     * @param start
     * @param end
     * @return
     */
    private SearchContext createSearchContextFromRequest(RenderRequest renderRequest,
	    SearchContainer<User> searchContainer, ThemeDisplay themeDisplay, int start, int end) {
	
	UserDisplayTerms displayTerms = null;
	SearchContext searchContext = SearchContextFactory.getInstance(PortalUtil.getHttpServletRequest(renderRequest));
	displayTerms = (UserDisplayTerms) searchContainer.getDisplayTerms();
	searchContext.setStart(start);
	searchContext.setEnd(end);

	if (displayTerms.isAdvancedSearch()) {
	    searchContext.setAndSearch(displayTerms.isAndOperator());
	} else {
	    searchContext.setKeywords(displayTerms.getKeywords());
	}
	long organizationId = themeDisplay.getScopeGroup().getOrganizationId();

	// Organization
	if (organizationId > 0) {
	    LinkedHashMap<String, Object> attributes = new LinkedHashMap<String, Object>();
	    attributes.put("usersOrgs", Long.valueOf(organizationId));
	    searchContext.setGroupIds(null);
	    searchContext.setAttribute("params", attributes);
	}

	// Navigation
	String navigation = ParamUtil.getString(renderRequest, "navigation", "active");

	if (!"active".equals(navigation)) {
	    searchContext.setAttribute(Field.STATUS, WorkflowConstants.STATUS_INACTIVE);
	}
	
	// Sort
	Sort sort = SortFactoryUtil.getSort(User.class, searchContainer.getOrderByCol(), searchContainer.getOrderByType());
	searchContext.setSorts(sort);

	QueryConfig queryConfig = new QueryConfig();

	queryConfig.setHighlightEnabled(true);
	searchContext.setQueryConfig(queryConfig);

	if (LOGGER.isDebugEnabled()) {
	    LOGGER.debug("displayTerms " + displayTerms);
	    LOGGER.debug("navigation " + navigation);
	    LOGGER.debug("start " + start);
	    LOGGER.debug("end " + end);
	    LOGGER.debug("sort " + sort);

	}
	return searchContext;
    }

    /**
     * SearchUser
     * 
     * @param renderRequest
     * @param renderResponse
     * @param themeDisplay
     * @param users
     * @param total
     * @param hits
     * @return
     */
    private int searchUser(RenderRequest renderRequest, RenderResponse renderResponse, ThemeDisplay themeDisplay,
	    List<User> users, int total, Hits hits) {
	if (hits != null && hits.getLength() > 0) {
	    List<SearchResult> searchResultsList = SearchResultUtil.getSearchResults(hits, themeDisplay.getLocale(), renderRequest, renderResponse);
	    total = hits.getLength();
	    if (total > 0) {
		for (SearchResult searchResult : searchResultsList) {
		    try {
			User user = UserLocalServiceUtil.getUser(searchResult.getClassPK());
			users.add(user);
		    } catch (PortalException e) {
			if (LOGGER.isDebugEnabled()) {
			    LOGGER.debug(e);
			}
			LOGGER.error("PortalException : impossible to get user " + searchResult.getClassPK());
		    } catch (SystemException e) {
			if (LOGGER.isDebugEnabled()) {
			    LOGGER.debug(e);
			}
			LOGGER.error("PortalException : impossible to get user " + searchResult.getClassPK());
		    }

		}
	    }
	}
	return total;
    }

}
