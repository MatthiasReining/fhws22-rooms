package de.fhws.business.rooms.control;

import java.util.Date;
import java.util.List;

import javax.inject.Inject;
import javax.inject.Singleton;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import de.fhws.business.rooms.entity.BuildingEntity;
import de.fhws.business.rooms.entity.RoomEntity;

@Transactional
public class RoomService {

	@PersistenceContext
	EntityManager em;

	@Inject
	BuildingService buildingService;

	public void initDummyData() {

		BuildingEntity shl = buildingService
				.addBuilding(new BuildingEntity("SHL", "Sanderheinrichsleitenweg 20", "97074 Würzburg"));
		BuildingEntity ms = buildingService.addBuilding(new BuildingEntity("MS", "Münzstraße 12", "97070 Würzburg"));

		for (int i = 0; i < 10; i++) {
			RoomEntity room = new RoomEntity("I1 " + new Date(), i % 2 == 0 ? shl : ms, ((i % 3) + 1) * 10, 2);
			addRoom(room);
		}
	}

	public void addRoom(RoomEntity room) {
		em.persist(room);
	}

	public List<RoomEntity> getRooms(Long limit, Long offset) {
		// TODO implement limit and offset
		return em.createQuery("SELECT r FROM RoomEntity r", RoomEntity.class).getResultList();
	}

}
