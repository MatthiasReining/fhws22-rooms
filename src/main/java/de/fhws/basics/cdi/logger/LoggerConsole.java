package de.fhws.basics.cdi.logger;

public class LoggerConsole implements Logger {

	@Override
	public void log(String logMessage) {
		System.out.println("write into console log: " + logMessage);
	}

}
