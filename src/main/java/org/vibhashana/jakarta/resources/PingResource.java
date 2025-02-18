package org.vibhashana.jakarta.resources;

import org.vibhashana.jakarta.interceptors.Logging;
import org.vibhashana.jakarta.messages.Sender;

import jakarta.ejb.EJB;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.QueryParam;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

@Path("ping")
//@Logging
public class PingResource {
    @EJB
    private Sender sender;

    @GET
    @Produces({MediaType.TEXT_PLAIN, MediaType.APPLICATION_JSON})
    public Response ping(@QueryParam("msg") String msg) throws InterruptedException {
        System.out.println("$$$$$$$$$$$$");
        sender.sendMessage(msg);
        return Response.ok("Message sent").build();
    }
}
