package fr.smile.training.web.portlet.configurationicon;

import com.liferay.portal.kernel.portlet.configuration.icon.BasePortletConfigurationIcon;

import javax.portlet.PortletRequest;
import javax.portlet.PortletResponse;

import org.osgi.service.component.annotations.Component;

/**
 * @author guillaumelenoir
 *
 */
@Component(
		immediate = true,
		property = {"javax.portlet.name=fr_smile_training_web_advanced_portlet_AdvancedPortlet"},
		service = SamplePortletConfigurationIcon.class
	)
public class SamplePortletConfigurationIcon extends BasePortletConfigurationIcon {
	
	@Override
	public boolean isShow(PortletRequest portletRequest) {
		return true;
	}

	@Override
	public boolean isToolTip() {
		return false;
	}

	
	
	@Override
	public boolean isUseDialog() {
		return false;
	}

	@Override
	public String getMessage(PortletRequest portletRequest) {
		return "custom-icon";
	}

	@Override
	public String getMethod() {
		return "GET";
	}

	@Override
	public String getURL(PortletRequest portletRequest, PortletResponse portletResponse) {
		// TODO Auto-generated method stub
		return "wwww.google.fr";
	}

	@Override
	public double getWeight() {
		return 1l;
	}

	
	



}
