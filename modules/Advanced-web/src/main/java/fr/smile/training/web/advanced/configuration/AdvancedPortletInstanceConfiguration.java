package fr.smile.training.web.advanced.configuration;

import com.liferay.portal.configuration.metatype.annotations.ExtendedObjectClassDefinition;

import aQute.bnd.annotation.metatype.Meta;

/**
 * 
 * @author guillaumelenoir
 * 
 * (1) Meta.OCD: Registers this class as a configuration with a specific id. We can choose any string we want, but it should be unique.
 *  A common pattern is to use the fully qualified class name.
 *
 * (2) Meta.AD: This represent the default value of a configuration field as well as whether it’s required or not. 
 * Note that if we set a field as required and don’t specify a default value, the system administrator must specify 
 * a value in order for your application to work properly. Use the deflt property to specify a default value.
 * 
 * (3)id = "fr.smile.training.web.advanced.configuration.AdvancedPortletInstanceConfiguration" represents the configuration id which will be reffred from other classes.
 * This is a unique id. A common pattern is to use the fully qualified class name of the interface for the ID since fully
 * qualified class names are unique
 * 
 * (4) To specify that a field is optional, set required=false
 * 
 * (5) @Meta.OCD,@Meta.AD are part of biz.aQute.bndlib-3.1.0-sources.jar file. Check the pom.xml
 * 
 * (6) For more information on meta type http://bnd.bndtools.org/chapters/210-metatype.html 
 * 
 * (7)We must add  -metatype: * 
 * in our bnd.bnd file to include this metatype in the final bundle Once the bundle is created
 * it will include DemoConfiguration.xml under OSGI-INF\metatype
 * 
 * (8)The configuration will create one User Interface in the Liferay Control Panel
 * where we can set our configuration values 
 */
@ExtendedObjectClassDefinition(
		scope = ExtendedObjectClassDefinition.Scope.PORTLET_INSTANCE,
		category = "formation")
@ Meta.OCD(
	id =
	"fr.smile.training.web.advanced.configuration.AdvancedPortletInstanceConfiguration"
)
public interface AdvancedPortletInstanceConfiguration {
			@Meta.AD(
					deflt = "lyon", required = false
			)
			public String city();
}
