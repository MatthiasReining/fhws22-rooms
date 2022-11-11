package de.fhws.basics.cdi;

import javax.enterprise.inject.Instance;
import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("cdi-tests")
public class CdiTestResource {

	@Inject
	@MessageTech
	Instance<Message> messageInstance;
	
	@Inject
	BusinessLogic bl;

	@GET
	@Produces(MediaType.TEXT_PLAIN)
	public String cdiTest() {
		// important things before we read the message
		System.out.println("cdiTest ns: " + System.nanoTime());
		
		Message message = messageInstance.get();
		
		
		System.out.println("message 1: " + message.getText());
		bl.caluclate();
		return "test: " + message.getText();
	}
}
