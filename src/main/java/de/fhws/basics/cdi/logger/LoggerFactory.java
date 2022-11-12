package de.fhws.basics.cdi.logger;

import javax.enterprise.context.spi.CreationalContext;
import javax.enterprise.inject.Produces;
import javax.enterprise.inject.spi.Bean;
import javax.enterprise.inject.spi.BeanManager;
import javax.inject.Inject;

import de.fhws.basics.cdi.logger.LoggerType.Type;

public class LoggerFactory {

	@Inject
	BeanManager beanManager;

	@Produces
	@LoggerType(Type.CONSOLE)
	public Logger produceConsoleLogger() {
		// produces a new instance but NOT CDI managed
		return new LoggerConsole();

	}

	@Produces
	@LoggerType(Type.DB)
	public Logger produceMessageSmart() {
		// produces a CDI managed bean
		Bean<LoggerDB> bean = (Bean<LoggerDB>) beanManager.getBeans(LoggerDB.class).iterator().next();
		CreationalContext<LoggerDB> ctx = beanManager.createCreationalContext(bean);

		LoggerDB obj = (LoggerDB) beanManager.getReference(bean, LoggerDB.class, ctx);
		return obj;

	}
}
