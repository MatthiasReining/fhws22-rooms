package de.fhws.business.rooms.boundary;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import de.fhws.business.rooms.control.BuildingService;
import de.fhws.business.rooms.entity.BuildingDTO;

@Produces(MediaType.APPLICATION_JSON)
@Path("bulidings")
public class BulidingResource {

	@Inject
	BuildingService buildingService;

	@GET
	@Path("{name}")
	public BuildingDTO getBulding(@PathParam("name") String name) {
		
		// here we work with a business key and not with the technical internal database id
		
		return buildingService.getBuiling(name);
	}
}
