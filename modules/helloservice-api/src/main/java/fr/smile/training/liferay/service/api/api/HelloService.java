package fr.smile.training.liferay.service.api.api;

public interface HelloService {
	

	/**
	 * @param firstName
	 * @return
	 */
	public String sayHello(String firstName);

	/**
	 * @param firstName
	 * @param lastname
	 * @return
	 */
	public String sayHello(String firstName, String lastname);
}