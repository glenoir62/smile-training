package fr.smile.training.web.advanced.configuration;

import com.liferay.portal.kernel.settings.definition.ConfigurationBeanDeclaration;

import org.osgi.service.component.annotations.Component;

/**
 * @author guillaumelenoir
 *
 */
@Component
public class AdvancedPortletInstanceConfigurationBeanDeclaration implements ConfigurationBeanDeclaration {
	@Override
	public Class<?> getConfigurationBeanClass() {
		return AdvancedPortletInstanceConfiguration.class;
	}

}
