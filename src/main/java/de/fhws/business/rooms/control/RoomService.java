package de.fhws.business.rooms.control;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.inject.Singleton;

import de.fhws.business.rooms.entity.RoomEntity;

@Singleton
public class RoomService {

	public RoomService() {
		System.out.println("RoomService#constructor");
	}

	private static List<RoomEntity> rooms = new ArrayList<>();

	@PostConstruct
	public void init() {
		rooms.add(new RoomEntity("I1 " + new Date(), "SHL", 30, 2));
	}

	public void addRoom(RoomEntity room) {
		rooms.add(room);
	}

	public List<RoomEntity> getRooms() {
		return rooms;
	}

}
