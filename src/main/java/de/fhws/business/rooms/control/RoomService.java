package de.fhws.business.rooms.control;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import de.fhws.business.rooms.entity.BuildingEntity;
import de.fhws.business.rooms.entity.RoomChangeLogEntity;
import de.fhws.business.rooms.entity.CreateRoomDTO;
import de.fhws.business.rooms.entity.RoomDTO;
import de.fhws.business.rooms.entity.RoomEntity;
import de.fhws.business.rooms.entity.UpdateRoomDTO;

@Transactional
public class RoomService {

	@PersistenceContext
	EntityManager em;

	@Inject
	BuildingService buildingService;

	public void initDummyData() {

		buildingService.addBuilding(new BuildingEntity("SHL", "Sanderheinrichsleitenweg 20", "97074 Würzburg"));
		buildingService.addBuilding(new BuildingEntity("MS", "Münzstraße 12", "97070 Würzburg"));

		for (int i = 0; i < 10; i++) {
			CreateRoomDTO room = new CreateRoomDTO();
			room.setBuildingName(i % 2 == 0 ? "SHL" : "MS");
			room.setName("I1 " + new Date());
			room.setProjectors(2);
			room.setSeats(((i % 3) + 1) * 10);
			addRoom(room);
		}
	}

	public void addRoom(CreateRoomDTO room) {
		RoomEntity re = new RoomEntity();

		re.setName(room.getName());
		re.setProjectors(room.getProjectors());
		re.setSeats(room.getSeats());
		re.setBuilding(buildingService.getBuilingEntity(room.getBuildingName()));

		em.persist(re);
		System.out.println("room " + re.getId());
	}

	public void updateRoom(Long id, UpdateRoomDTO room) {
		RoomEntity re = em.find(RoomEntity.class, id);

		if (!re.getBuilding().getName().equals(room.getBuildingName())) {
			re.setBuilding(buildingService.getBuilingEntity(room.getBuildingName()));
		}
	
		
		re.setProjectors(room.getProjectors());
		re.setSeats(room.getSeats());
		
		
		RoomChangeLogEntity cle = new RoomChangeLogEntity();
		cle.setUpdatedAt(LocalDateTime.now());
		cle.setUpdatedBy("fhws-internal-user");
		cle.setComment("updated " + re.getName());
		
		cle.setRoom(re);
		
		re.getChangeLog().add(cle);
		
		
		re = em.merge(re);
		
		// no merge required -> re is already an managed JPA entity.
	}

	public RoomDTO getRoom(Long id) {
		RoomEntity re = em.find(RoomEntity.class, id);
		if (re == null)
			return null;
		
		System.out.println( re.getChangeLog().size() );
		return re.toDTO();
	}

	public List<RoomDTO> getRooms(Long limit, Long offset) {
		// TODO implement limit and offset
		List<RoomEntity> roomEntities = em.createQuery("SELECT r FROM RoomEntity r", RoomEntity.class).getResultList();

		// as alternative you can also use MapStruct
		return roomEntities.stream().map(r -> r.toDTO()).collect(Collectors.toList());
	}

}
