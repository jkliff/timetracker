package de.jkliff.timetracker.rest.resource;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.MultivaluedMap;

import com.google.gson.Gson;

import de.jkliff.timetracker.core.model.Activity;
import de.jkliff.timetracker.core.service.ActivityService;
import de.jkliff.timetracker.util.ApplicationContextSingleton;

//@Component(ActivityResource.BEAN_ID)
@Path("/")
public class ActivityResource {
    public static final String BEAN_ID         = "ActivityResource";

    // @Autowired
    private ActivityService    activityService = (ActivityService) ApplicationContextSingleton.getApplicationContext()
                                                       .getBean(ActivityService.BEAN_ID);

    @GET
    @Produces(MediaType.APPLICATION_JSON + ";charset=UTF-8")
    @Path("/activity/{id}")
    public String get(@PathParam("id") Long id) {
        System.out.println("attending request for " + id);

        if (id != null) {
            return new Gson().toJson(activityService.load(id), Activity.class);
        }

        return null;
    }

    @PUT
    @Produces(MediaType.APPLICATION_JSON + ";charset=UTF-8")
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    @Path("/activity/add")
    public String save(MultivaluedMap<String, String> params) {
        // System.out.println("save " + activityJson);
        System.out.println("save " + params);
        Activity a = new Gson().fromJson(params.getFirst("activity"), Activity.class);
        Object r = null;

        if (a.getId() != null) {
            throw new IllegalArgumentException("Activity creation can't provide an Id.");
        }

        r = activityService.save(a);

        return new Gson().toJson(r, Long.class);

    }

    @POST
    @Produces(MediaType.APPLICATION_JSON + ";charset=UTF-8")
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    @Path("/activity/update")
    public String update(MultivaluedMap<String, String> params) {
        // System.out.println("save " + activityJson);
        System.out.println("update " + params);
        Activity a = new Gson().fromJson(params.getFirst("activity"), Activity.class);

        if (a.getId() == null) {
            throw new IllegalArgumentException("Activity update needs to have an Id.");
        }

        Object r = null;

        r = activityService.save(a);

        return new Gson().toJson(r, Long.class);

    }
}
