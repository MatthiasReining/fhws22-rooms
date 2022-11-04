package de.fhws.business.rooms.boundary;

import java.util.Date;
import java.util.List;

import javax.inject.Inject;
import javax.ws.rs.DefaultValue;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import de.fhws.business.rooms.control.RoomService;
import de.fhws.business.rooms.entity.RoomEntity;

@Produces(MediaType.APPLICATION_JSON)
@Path("rooms")
public class RoomResource {

	@Inject
	RoomService roomService;

	@GET
	@Path("ping")
	public String ping() {
		return "I'm here at FHWS 👍💪😊🛫🍻🙈 and hello from Wildfly at " + new Date();
	}

	@POST
	public void addRoom(RoomEntity room) {
		roomService.addRoom(room);
	}

	@GET
	public List<RoomEntity> getRooms(@QueryParam("limit") @DefaultValue("100") Long limit,
			@QueryParam("offset") @DefaultValue("0") Long offset) {
		return roomService.getRooms(limit, offset);
	}

	@GET
	@Path("{id}")
	public RoomEntity getRoom(@PathParam("id") String id) {
		return roomService.getRooms(1L, 0L).get(0);
	}
}
