package de.fhws.business.rooms.control;

import java.util.List;
import java.util.stream.Collectors;

import javax.enterprise.event.Event;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import de.fhws.business.rooms.entity.Building;
import de.fhws.business.rooms.entity.BuildingEntity;
import de.fhws.business.rooms.entity.ChangeLogEntity;

public class BuildingService {

	@PersistenceContext
	EntityManager em;

	@Inject
	@NewBuilding
	Event<Building> newBuidlingEvent;

	@Transactional(Transactional.TxType.REQUIRED)
	public BuildingEntity addBuilding(BuildingEntity building) {
		ChangeLogEntity cl = new ChangeLogEntity();
		cl.setComment("New Building");
		cl.setUpdatedBy("fhws");
		building.getChangeLog().add(cl);

		BuildingEntity newBuilding = em.merge(building);
		System.out.println("for fire newBuilding event");
		newBuidlingEvent.fire(building.toDTO());
		System.out.println("nach fire newBuilding event");

		return newBuilding;
	}
	
	@Transactional(Transactional.TxType.REQUIRED)
	public Building addBuilding(Building building) {
		

		BuildingEntity newBuilding = new BuildingEntity();
		newBuilding.setAddressLine1(building.getAddressLine1());
		newBuilding.setAddressLine2(building.getAddressLine2());
		newBuilding.setName(building.getName());
		
		return addBuilding(newBuilding).toDTO();
	}

	public Building getBuiling(String name) {
		return getBuilingEntity(name).toDTO();
	}
	
	public List<Building> getAllBuildings() {
		return em.createQuery("SELECT b FROM BuildingEntity b", BuildingEntity.class).getResultStream()
		.map(b -> b.toDTO()).collect(Collectors.toList());
	}

	public BuildingEntity getBuilingEntity(String name) {
		return em.createNamedQuery(BuildingEntity.QUERY_BY_NAME, BuildingEntity.class)
				.setParameter(BuildingEntity.PARAM_NAME, name).getSingleResult();
	}

	public Building getBuilingNullCheckProgrammed(String name) {
		List<BuildingEntity> buildingEntities = em
				.createQuery("SELECT b FROM BuildingEntity b WHERE b.name = :name", BuildingEntity.class)
				.setParameter("name", name).getResultList();
		if (buildingEntities.isEmpty())
			return null;
		return buildingEntities.get(0).toDTO();
	}

}
