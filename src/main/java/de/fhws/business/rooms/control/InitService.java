package de.fhws.business.rooms.control;

import javax.annotation.PostConstruct;
import javax.ejb.Startup;
import javax.ejb.Stateless;
import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.context.Initialized;
import javax.enterprise.event.Observes;
import javax.inject.Inject;

// @Startup
// @Stateless
@ApplicationScoped
public class InitService {

	@Inject
	RoomService roomService;
	
	/*
	@PostConstruct
	public void init() {
		System.out.println("InitService#init");
		roomService.initDummyData();
	}*/
	
	public void onStart(@Observes @Initialized(ApplicationScoped.class) Object pointless) {
		System.out.println("InitService#onStart");
		roomService.initDummyData();
	}
}
