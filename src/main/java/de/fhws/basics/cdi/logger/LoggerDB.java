package de.fhws.basics.cdi.logger;

import javax.annotation.PostConstruct;
import javax.inject.Inject;

import de.fhws.basics.cdi.Message;

public class LoggerDB implements Logger {

	@Inject
	Message messageObj;

	@PostConstruct
	public void init() {
		System.out.println("LoggerDB#init");
		System.out.println("LoggerDB#init-> message: " + messageObj);
	}

	@Override
	public void log(String logMessage) {
		System.out.println("LoggerDB#log-> message " + messageObj);
		System.out.println("write into console log: " + logMessage);
	}

}
