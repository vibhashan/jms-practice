package org.vibhashana.jakarta;

import jakarta.json.Json;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.ext.ExceptionMapper;
import jakarta.ws.rs.ext.Provider;

@Provider
public class GlobalExceptionHandler implements ExceptionMapper<Exception> {
	@Override
	public Response toResponse(Exception e) {
		final var json = Json.createObjectBuilder()
				.add("message", Response.Status.BAD_REQUEST.getReasonPhrase())
				.add("code", Response.Status.BAD_REQUEST.getStatusCode()).add("cause", e.getMessage())
				.build();

		return Response.status(Response.Status.BAD_REQUEST).entity(json).build();
	}
}
