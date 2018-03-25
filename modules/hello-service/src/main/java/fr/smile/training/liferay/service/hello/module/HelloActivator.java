package fr.smile.training.liferay.service.hello.module;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceRegistration;

import fr.smile.training.liferay.service.api.api.HelloService;
import fr.smile.training.liferay.service.api.impl.HelloServiceImpl;

public class HelloActivator implements BundleActivator {

	
	@SuppressWarnings("rawtypes")
	private ServiceRegistration _serviceRegistration;
	
	@Override
	public void start(BundleContext bundleContext) throws Exception {
//		_serviceRegistration = bundleContext.registerService(HelloService.class, new HelloServiceImpl(), null);
//		System.out.println("###########Service Registered Successfully##############");
	}

	@Override
	public void stop(BundleContext bundleContext) throws Exception {
//		_serviceRegistration.unregister();
//		_serviceRegistration =  null;
//		 System.out.println("###########Service Unregistered##############");
	}

}