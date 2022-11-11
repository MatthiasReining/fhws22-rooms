package de.fhws.basics.cdi;

import java.util.Date;

import javax.enterprise.inject.Produces;

public class MessageFactory {

	@Produces
	@MessageTech
	public Message produceMessageTech() {
		Message m = new Message();
		m.setText("We have " + System.nanoTime());
		return m;
	}

	@Produces
	@MessageSmart
	public Message produceMessageSmart() {
		Message m = new Message();
		m.setText("Hello hello - es ist Freitag Nachmittag " + new Date());
		return m;
	}

}
