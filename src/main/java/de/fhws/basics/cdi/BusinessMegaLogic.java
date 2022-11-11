package de.fhws.basics.cdi;

import javax.inject.Inject;

public class BusinessMegaLogic {

	@Inject
	@MessageTech
	Message message;

	public void work() {

		System.out.println("BusinessMegaLogic ...");

		System.out.println("message: " + message.getText());

	}

}
