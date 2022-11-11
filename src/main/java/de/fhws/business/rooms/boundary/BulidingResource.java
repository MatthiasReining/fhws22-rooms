package de.fhws.business.rooms.boundary;

import java.util.List;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import de.fhws.business.rooms.control.BuildingService;
import de.fhws.business.rooms.entity.Building;

@Produces(MediaType.APPLICATION_JSON)
@Path("buildings")
public class BulidingResource {

	@Inject
	BuildingService buildingService;

	@GET
	@Path("{name}")
	public Building getBuilding(@PathParam("name") String name) {
		
		// here we work with a business key and not with the technical internal database id
		System.out.println("getBuilding" + name);
		return buildingService.getBuiling(name);
	}
	
	@GET
	public List<Building> getBuildingTest() {		
		return buildingService.getAllBuildings();
	}
	
	@POST
	public Building newBuilding(Building newBuilding) {		
		return buildingService.addBuilding(newBuilding);
	}
}
