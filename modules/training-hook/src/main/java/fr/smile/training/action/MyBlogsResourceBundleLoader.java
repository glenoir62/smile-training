package fr.smile.training.action;

import java.util.Locale;
import java.util.ResourceBundle;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import com.liferay.portal.kernel.util.AggregateResourceBundleLoader;
import com.liferay.portal.kernel.util.CacheResourceBundleLoader;
import com.liferay.portal.kernel.util.ClassResourceBundleLoader;
import com.liferay.portal.kernel.util.ResourceBundleLoader;

@Component(
	    immediate = true,
	    property = {
	       "bundle.symbolic.name=com.liferay.blogs.web",
	       "resource.bundle.base.name=content.Language",
	       "servlet.context.name=blogs-web"
	    }
	)
public class MyBlogsResourceBundleLoader implements ResourceBundleLoader {

	
	@Override
	public ResourceBundle loadResourceBundle(Locale locale) {
		return _resourceBundleLoader.loadResourceBundle(locale);
	}

	@Reference(target = "(&(bundle.symbolic.name=com.liferay.blogs.web)(!(component.name=com.liferay.docs.override.moduleresourcebundle.MyBlogsResourceBundleLoader)))")
	public void setResourceBundleLoader(ResourceBundleLoader resourceBundleLoader) {
		//Note: As of Liferay DXP Digital Experience Fix Pack de-33 and Liferay Portal CE GA6, ResourceBundleLoader method loadResourceBundle(String) is deprecated and replaced by new method loadResourceBundle(Locale).
		_resourceBundleLoader = new AggregateResourceBundleLoader(new CacheResourceBundleLoader(
				new ClassResourceBundleLoader("content.Language", MyBlogsResourceBundleLoader.class.getClassLoader())),
				resourceBundleLoader);
	}

	private AggregateResourceBundleLoader _resourceBundleLoader;

}