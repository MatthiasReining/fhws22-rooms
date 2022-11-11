package de.fhws.basics.cdi;

import javax.inject.Inject;

import de.fhws.basics.cdi.logger.Logger;
import de.fhws.basics.cdi.logger.LoggerType;
import de.fhws.basics.cdi.logger.LoggerType.Type;

public class BusinessMegaLogic {

	@Inject
	@MessageTech
	Message message;
	
	@Inject
	@LoggerType(Type.CONSOLE)
	Logger logger;

	public void work() {

		System.out.println("BusinessMegaLogic ...");
		
		logger.log("jetzt wird geloggt...");

		System.out.println("message: " + message.getText());

	}

}
