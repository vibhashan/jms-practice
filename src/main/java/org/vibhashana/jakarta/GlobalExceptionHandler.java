package org.vibhashana.jakarta;

import org.vibhashana.jakarta.interceptors.Logging;

import jakarta.json.Json;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.ext.ExceptionMapper;
import jakarta.ws.rs.ext.Provider;

@Provider
public class GlobalExceptionHandler implements ExceptionMapper<Throwable> {
	@Override
	public Response toResponse(Throwable e) {
		final var json = Json.createObjectBuilder()
				.add("message", Response.Status.BAD_REQUEST.getReasonPhrase())
				.add("code", Response.Status.BAD_REQUEST.getStatusCode()).add("cause", e.getMessage())
				.build();

		return Response.status(Response.Status.BAD_REQUEST).entity(json).build();
	}
}
