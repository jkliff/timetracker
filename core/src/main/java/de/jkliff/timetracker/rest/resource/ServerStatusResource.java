package de.jkliff.timetracker.rest.resource;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/status")
public class ServerStatusResource
        extends AbstractBaseResource {
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public String getStatus () {
        return GSON.toJson ("tudo ok");
    }

}
