package de.fhws.business.rooms.control;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.inject.Singleton;

import de.fhws.business.rooms.entity.BuildingEntity;
import de.fhws.business.rooms.entity.RoomEntity;

@Singleton
public class RoomService {

	public RoomService() {
		System.out.println("RoomService#constructor");
	}

	private static List<RoomEntity> rooms = new ArrayList<>();

	@PostConstruct
	public void init() {

		BuildingEntity shl = new BuildingEntity("SHL", "Sanderheinrichsleitenweg 20", "97074 Würzburg");
		BuildingEntity ms = new BuildingEntity("MS", "Münzstraße 12", "97070 Würzburg");

		for (int i = 0; i < 100000; i++) {
			rooms.add(new RoomEntity("I1 " + new Date(), i % 2 == 0 ? shl : ms, ((i % 3) + 1) * 10, 2));

		}

	}

	public void addRoom(RoomEntity room) {
		rooms.add(room);
	}

	public List<RoomEntity> getRooms(Long limit, Long offset) {
		return rooms.stream().skip(offset).limit(limit).toList();
	}

}
