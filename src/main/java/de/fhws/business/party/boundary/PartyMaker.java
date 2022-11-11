package de.fhws.business.party.boundary;

import javax.enterprise.event.Observes;

import de.fhws.business.rooms.control.NewBuilding;
import de.fhws.business.rooms.entity.Building;

public class PartyMaker {

	public void letsStartTheNewBuildingParty(@Observes @NewBuilding Building building) {

		System.out.println("Champagne! 🥂🥂");
		
		System.out.println("Happy at " + building.getName());
		System.out.println("the part takes place at "+ building.getAddressLine1() + " "+ building.getAddressLine2());
	}

}
