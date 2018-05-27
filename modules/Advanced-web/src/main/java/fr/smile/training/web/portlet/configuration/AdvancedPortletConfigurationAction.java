package fr.smile.training.web.portlet.configuration;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletConfig;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.osgi.service.component.annotations.Component;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.module.configuration.ConfigurationException;
import com.liferay.portal.kernel.portlet.ConfigurationAction;
import com.liferay.portal.kernel.portlet.DefaultConfigurationAction;
import com.liferay.portal.kernel.servlet.SessionErrors;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.util.WebKeys;

import fr.smile.training.web.advanced.configuration.AdvancedPortletInstanceConfiguration;
import fr.smile.training.web.portlet.action.ViewMVCRenderCommand;

/**
 * @author guillaumelenoir
 *
 */
@Component(
		immediate = true,
		property = {
				"javax.portlet.name=fr_smile_training_web_advanced_portlet_AdvancedPortlet"
		},
service = ConfigurationAction.class
)
public class AdvancedPortletConfigurationAction extends DefaultConfigurationAction {

	/**
	 * The logger
	 */
	protected static Log LOGGER = LogFactoryUtil.getLog(ViewMVCRenderCommand.class);

	@Override
	public void processAction(PortletConfig portletConfig, ActionRequest actionRequest, ActionResponse actionResponse)
			throws Exception {
		
		// Add validation
		// get preferences--city-- from form
		// Slide 100
		String city = ParamUtil.getString(actionRequest, "city");
		
		if (!Validator.isBlank(city) && Validator.isAlphanumericName(city)) {
			setPreference(actionRequest, "city", city);
			super.processAction(portletConfig, actionRequest, actionResponse);
		} else {
			SessionErrors.add(actionRequest, "city-errors");
		}
		
	}

	
	@Override
	public void include(PortletConfig portletConfig, HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		
		// Init city from AdvancedPortletInstanceConfiguration
		// Slide 100
		try {
			ThemeDisplay themeDisplay = (ThemeDisplay) request.getAttribute(WebKeys.THEME_DISPLAY);

			AdvancedPortletInstanceConfiguration advancedPortletInstanceConfiguration = themeDisplay.getPortletDisplay()
					.getPortletInstanceConfiguration(AdvancedPortletInstanceConfiguration.class);

			LOGGER.info("city = " + advancedPortletInstanceConfiguration.city());

			request.setAttribute("advancedPortletInstanceConfiguration", advancedPortletInstanceConfiguration);
		} catch (ConfigurationException e) {
			LOGGER.error(e);
		}
		super.include(portletConfig, request, response);
	}

}
