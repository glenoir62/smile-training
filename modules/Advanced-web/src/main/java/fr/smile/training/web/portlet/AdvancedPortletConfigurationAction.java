package fr.smile.training.web.portlet;

import java.io.IOException;

import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import org.osgi.service.component.annotations.Component;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.module.configuration.ConfigurationException;
import com.liferay.portal.kernel.portlet.ConfigurationAction;
import com.liferay.portal.kernel.portlet.DefaultConfigurationAction;
import com.liferay.portal.kernel.util.WebKeys;

import fr.smile.training.web.advanced.configuration.AdvancedPortletInstanceConfiguration;
import fr.smile.training.web.portlet.action.ViewMVCRenderCommand;

@Component(
immediate = true, property = {
"javax.portlet.name=fr_smile_training_web_advanced_portlet_AdvancedPortlet"
},
service = ConfigurationAction.class
)
public class AdvancedPortletConfigurationAction extends DefaultConfigurationAction {

	 protected static Log LOGGER = LogFactoryUtil.getLog(ViewMVCRenderCommand.class);
	 
	@Override
	public void render(RenderRequest request, RenderResponse response) throws PortletException, IOException {
		try {
			com.liferay.portal.kernel.theme.ThemeDisplay themeDisplay = (com.liferay.portal.kernel.theme.ThemeDisplay) request.getAttribute(WebKeys.THEME_DISPLAY);


			AdvancedPortletInstanceConfiguration advancedPortletInstanceConfiguration = themeDisplay.getPortletDisplay()
					.getPortletInstanceConfiguration(AdvancedPortletInstanceConfiguration.class);
			
			LOGGER.info("city = " + advancedPortletInstanceConfiguration.city());
			
			request.setAttribute("advancedPortletInstanceConfiguration", advancedPortletInstanceConfiguration);
		} catch (ConfigurationException e) {
			LOGGER.error(e);
		}
		super.render(request, response);
	}
	

}
