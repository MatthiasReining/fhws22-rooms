package de.fhws.business.party.boundary;

import javax.enterprise.event.ObservesAsync;

import de.fhws.business.rooms.control.NewBuilding;
import de.fhws.business.rooms.entity.Building;

public class PartyMaker {

	public void letsStartTheNewBuildingParty(@ObservesAsync @NewBuilding Building building) {

		System.out.println("Champagne! 🥂🥂");
		
		
		System.out.println("Happy at " + building.getName());
		
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println("the part takes place at "+ building.getAddressLine1() + " "+ building.getAddressLine2());
	}

}
