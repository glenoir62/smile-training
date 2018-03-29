package fr.smile.training.web.portlet;

import java.io.IOException;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.Portlet;
import javax.portlet.PortletException;
import javax.portlet.PortletPreferences;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;
import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;

import org.osgi.service.component.annotations.Component;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.model.Company;
import com.liferay.portal.kernel.model.Layout;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCPortlet;
import com.liferay.portal.kernel.servlet.SessionMessages;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.WebKeys;

/**
 * @author Guillaume Lenoir
 * 
 */
@Component(
	immediate = true,
	property = {
		"com.liferay.portlet.display-category=category.sample",
		"com.liferay.portlet.instanceable=true",
		"javax.portlet.display-name=formation-web Portlet",
		"javax.portlet.portlet-mode=text/html;view,edit",
		"javax.portlet.init-param.template-path=/",
		"javax.portlet.init-param.view-template=/view.jsp",
		"javax.portlet.init-param.edit-template=/edit.jsp",
		"javax.portlet.resource-bundle=content.Language",
		"javax.portlet.security-role-ref=power-user,user"
	},
	service = Portlet.class
)
public class FormationWebPortlet extends MVCPortlet {

	/**
	 * The logger
	 */
	private static final Log LOGGER = LogFactoryUtil.getLog(FormationWebPortlet.class);
	
	/**
	 * Edit value store in portlet preferences or portlet session.
	 */
	private static final String EDIT_VALUE = "EDIT_VALUE";
	
	@Override
	public void init() throws PortletException {
		LOGGER.info("init FormationWebPortlet");
		super.init();
	}
	
	@Override
	public void destroy() {
		LOGGER.info("destroy FormationWebPortlet");
		super.destroy();
	}

	@Override
	public void doView(RenderRequest renderRequest, RenderResponse renderResponse)
			throws IOException, PortletException {
		
		LOGGER.info("doView FormationWebPortlet");
		
		// Themedisplay, very important object
		ThemeDisplay themeDisplay = (ThemeDisplay) renderRequest.getAttribute(WebKeys.THEME_DISPLAY);
		// we can retrieve groupId (site id), current userId, current layout (page)..
		long groupId = themeDisplay.getScopeGroupId();
		long userId = themeDisplay.getUserId();
		Layout layout = themeDisplay.getLayout();
		Company company = themeDisplay.getCompany();
		
		// Log it in debug mode only
		
		if (LOGGER.isDebugEnabled()) {
			LOGGER.debug("groupId " + groupId);
			LOGGER.debug("userId " + userId);
			LOGGER.debug("layout " + layout);
			LOGGER.debug("company " + company);
		}
		
		// use theme display in your code

		// Get EDIT_VALUE from portletRequest
		//String editValue = GetterUtil.getString(renderRequest.getPortletSession().getAttribute("EDIT_VALUE"));
		
		// Get EDIT_VALUE from portletPreferences (BDD);
		PortletPreferences portletPreferences = renderRequest.getPreferences();
		String editValue = GetterUtil.getString(portletPreferences.getValue(EDIT_VALUE, StringPool.BLANK));
		renderRequest.setAttribute(EDIT_VALUE, editValue);
				
		super.doView(renderRequest, renderResponse);
	}

	@Override
	public void doEdit(RenderRequest renderRequest, RenderResponse renderResponse)
			throws IOException, PortletException {
		LOGGER.info("doEdit FormationWebPortlet");
		
		// to activate do edit mode :
		// ADD 	"javax.portlet.init-param.edit-template=/edit.jsp",
		// ADD  "javax.portlet.portlet-mode=text/html;view,edit",
		
		
		// Init EDIT_VALUE form
		PortletPreferences portletPreferences = renderRequest.getPreferences();
		String editValue = GetterUtil.getString(portletPreferences.getValue(EDIT_VALUE, StringPool.BLANK));
		renderRequest.setAttribute(EDIT_VALUE, editValue);
		
		super.doEdit(renderRequest, renderResponse);
	}

	@Override
	public void processAction(ActionRequest actionRequest, ActionResponse actionResponse)
			throws IOException, PortletException {
		LOGGER.info("processAction FormationWebPortlet");
		
		// Get editValue parameter from form.
		// String editValue = GetterUtil.getString(actionRequest.getParameter("editValue"));
		String editValue = ParamUtil.getString(actionRequest, "editValue");
		
		// Store EDIT_VALUE in portlet Session
		
//		PortletSession portletSession = actionRequest.getPortletSession();
//		portletSession.setAttribute("EDIT_VALUE", editValue);
//		actionResponse.setPortletMode(PortletMode.VIEW);
		
		// Store EDIT_VALUE in portlet preferences
		PortletPreferences portletPreferences = actionRequest.getPreferences();
		portletPreferences.setValue(EDIT_VALUE, editValue);
		portletPreferences.store();
		
		// Add success message
		// use <liferay-ui:success key="" message=""/> in your jsp
		SessionMessages.add(actionRequest, "editValue-success");
		
		super.processAction(actionRequest, actionResponse);
	}

	@Override
	public void render(RenderRequest renderRequest, RenderResponse renderResponse)
			throws IOException, PortletException {
		LOGGER.info("render FormationWebPortlet");
		super.render(renderRequest, renderResponse);
	}

	@Override
	public void serveResource(ResourceRequest resourceRequest, ResourceResponse resourceResponse)
			throws IOException, PortletException {
		LOGGER.info("render FormationWebPortlet");
		super.serveResource(resourceRequest, resourceResponse);
	}
	
}