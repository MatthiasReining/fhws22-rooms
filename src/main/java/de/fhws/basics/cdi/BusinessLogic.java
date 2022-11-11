package de.fhws.basics.cdi;

import javax.inject.Inject;

import de.fhws.basics.cdi.logger.Logger;
import de.fhws.basics.cdi.logger.LoggerType;
import de.fhws.basics.cdi.logger.LoggerType.Type;

public class BusinessLogic {

	@Inject
	BusinessMegaLogic bml;
	
	
	@Inject
	@LoggerType(Type.DB)
	Logger logger;


	public void caluclate() {

		logger.log("heavy work in calculate - deep inside the application...");

		bml.work();
	}

}
