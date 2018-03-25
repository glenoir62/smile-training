package fr.smile.training.web.portlet.action;

import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import org.osgi.service.component.annotations.Component;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.module.configuration.ConfigurationException;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCRenderCommand;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.WebKeys;

import fr.smile.training.web.advanced.configuration.AdvancedPortletInstanceConfiguration;

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
			
			LOGGER.info("advancedPortletInstanceConfiguration = " + advancedPortletInstanceConfiguration);
			
			renderRequest.setAttribute("advancedPortletInstanceConfiguration", advancedPortletInstanceConfiguration);
		} catch (ConfigurationException e) {
			LOGGER.error(e);
		}
	return "/view.jsp";
    }
}
