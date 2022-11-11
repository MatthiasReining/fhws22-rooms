package de.fhws.basics.cdi;

import javax.inject.Inject;

public class BusinessLogic {

	@Inject
	BusinessMegaLogic bml;

	public void caluclate() {

		System.out.println("heavy work in calculate - deep inside the application...");

		bml.work();
	}

}
