package de.fhws.basics.cdi;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("cdi-tests")
public class CdiTestResource {

	@Inject
	@MessageSmart
	Message message;
	
	@Inject
	BusinessLogic bl;

	@GET
	@Produces(MediaType.TEXT_PLAIN)
	public String cdiTest() {
		System.out.println("message 1: " + message.getText());
		bl.caluclate();
		return "test: " + message.getText();
	}
}
