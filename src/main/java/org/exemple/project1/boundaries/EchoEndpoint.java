package org.exemple.project1.boundaries;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.core.Response;

@Path("/echoes")
public class EchoEndpoint {
    @GET
    @Path("/{message}")
    public Response helloEcho(@PathParam("message")String message){
        return Response.ok().entity("echo: "+message).build();
    }
}
