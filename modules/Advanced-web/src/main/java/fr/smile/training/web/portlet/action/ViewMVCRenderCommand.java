package fr.smile.training.web.portlet.action;

import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import org.osgi.service.component.annotations.Component;

import com.liferay.expando.kernel.model.CustomAttributesDisplay;
import com.liferay.expando.kernel.model.ExpandoColumn;
import com.liferay.expando.kernel.model.ExpandoTable;
import com.liferay.expando.kernel.model.ExpandoTableConstants;
import com.liferay.expando.kernel.model.ExpandoValue;
import com.liferay.expando.kernel.service.ExpandoColumnLocalServiceUtil;
import com.liferay.expando.kernel.service.ExpandoTableLocalServiceUtil;
import com.liferay.expando.kernel.service.ExpandoValueLocalServiceUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.module.configuration.ConfigurationException;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCRenderCommand;
import com.liferay.portal.kernel.service.ClassNameLocalServiceUtil;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.ArrayUtil;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.PortalUtil;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.portal.kernel.util.WebKeys;
import com.liferay.taglib.util.CustomAttributesUtil;

import fr.smile.training.web.advanced.configuration.AdvancedPortletInstanceConfiguration;

/**
 * @author guillaumelenoir
 *
 */
@Component(property = {
		"javax.portlet.name=fr_smile_training_web_advanced_portlet_AdvancedPortlet",
		"mvc.command.name=/",
		})
public class ViewMVCRenderCommand implements MVCRenderCommand {

	/**
     * GroupPhotoController Logger.
     */
    protected static Log LOGGER = LogFactoryUtil.getLog(ViewMVCRenderCommand.class);

    @Override
    public String render(RenderRequest renderRequest, RenderResponse renderResponse) {

    	ThemeDisplay themeDisplay = (ThemeDisplay) renderRequest.getAttribute(WebKeys.THEME_DISPLAY);

		
		try {
			AdvancedPortletInstanceConfiguration advancedPortletInstanceConfiguration = themeDisplay.getPortletDisplay()
					.getPortletInstanceConfiguration(AdvancedPortletInstanceConfiguration.class);
			
			LOGGER.info("ViewMVCRenderCommand advancedPortletInstanceConfiguration = " + advancedPortletInstanceConfiguration);
			
			// Get user type using Liferay services
			try {
				User user = PortalUtil.getUser(renderRequest);
				
				
				long classNameId = ClassNameLocalServiceUtil.getClassNameId(User.class.getName());
				try {
					ExpandoTable table = ExpandoTableLocalServiceUtil.getTable(user.getCompanyId(),
							classNameId, ExpandoTableConstants.DEFAULT_TABLE_NAME);
					ExpandoColumn existingEc = ExpandoColumnLocalServiceUtil.getColumn(table.getTableId(), "user-type");
					ExpandoValue expandoValue = ExpandoValueLocalServiceUtil.getValue(table.getTableId(), existingEc.getColumnId(), user.getUserId());
					
					LOGGER.info("user-type from expandoValue = " + expandoValue.getData());
					//LOGGER.info("user-type" + GetterUtil.getString(user.getExpandoBridge().getAttribute("user-type") ));
				} catch (Exception e) {
					e.printStackTrace();
					LOGGER.error("Unable to createOrGetCustomTable : " + e.getMessage());
				}
				
			} catch (PortalException e) {
				LOGGER.info(e);
			} catch (Exception e) {
				LOGGER.info(e);
			}
			
			// Get user type using expandoBridge
			
			LOGGER.info("user-type from expandoBridge = " + StringUtil.merge(GetterUtil.getStringValues(themeDisplay.getUser().getExpandoBridge().getAttribute("user-type"))));
			
			
			
			renderRequest.setAttribute("advancedPortletInstanceConfiguration", advancedPortletInstanceConfiguration);
		} catch (ConfigurationException e) {
			LOGGER.error(e);
		}
	return "/view.jsp";
    }
}
