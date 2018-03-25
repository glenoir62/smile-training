package fr.smile.training.liferay.service.api.impl;

import org.osgi.service.component.annotations.Component;

import fr.smile.training.liferay.service.api.api.HelloService;

@Component(immediate = true, property = {

}, service = HelloService.class)
public class HelloServiceImpl implements HelloService {

	@Override
	public String sayHello(String firstName) {
		return "firstName " + firstName;
	}

	@Override
	public String sayHello(String firstName, String lastname) {
		return "firstName " + firstName + "lastname " + lastname;
	}

}
