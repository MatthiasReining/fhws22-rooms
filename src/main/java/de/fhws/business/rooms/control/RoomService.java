package de.fhws.business.rooms.control;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import de.fhws.business.rooms.entity.BuildingEntity;
import de.fhws.business.rooms.entity.RoomDTO;
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
		System.out.println("room " + room.getId());
	}
	
	public RoomDTO getRoom(Long id) {
		return em.find(RoomEntity.class, id).toDTO();
	}

	public List<RoomDTO> getRooms(Long limit, Long offset) {
		// TODO implement limit and offset
		List<RoomEntity> roomEntities = em.createQuery("SELECT r FROM RoomEntity r", RoomEntity.class).getResultList();
		
		// as alternative you can also use MapStruct
		return roomEntities.stream().map(r -> r.toDTO()).collect(Collectors.toList());
	}

}
