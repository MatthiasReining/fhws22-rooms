package de.fhws.business.rooms.control;

import javax.persistence.NoResultException;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

@Provider
public class NotFoundExceptionMapper implements ExceptionMapper<NoResultException>{

	@Override
	public Response toResponse(NoResultException exception) {
		System.out.println("NotFoundExceptionMapper#toResponse");
		return Response.status(404).build();
	}

}
