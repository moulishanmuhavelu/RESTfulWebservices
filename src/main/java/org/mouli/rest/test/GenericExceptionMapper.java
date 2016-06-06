package org.mouli.rest.test;

import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

@Provider
public class GenericExceptionMapper implements ExceptionMapper<Throwable>{

	@Override
	public Response toResponse(Throwable arg0) {
		ErrorMessage err = new ErrorMessage(876, "Query returned no results");
		return Response.status(404).entity(err).build();

	}

	
}
