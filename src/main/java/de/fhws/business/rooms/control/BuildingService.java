package de.fhws.business.rooms.control;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import de.fhws.business.rooms.entity.BuildingEntity;

public class BuildingService {
	
	@PersistenceContext
	EntityManager em;

		
	@Transactional(Transactional.TxType.REQUIRED)	
	public BuildingEntity addBuilding(BuildingEntity building) {
		return em.merge(building);
	}

}
