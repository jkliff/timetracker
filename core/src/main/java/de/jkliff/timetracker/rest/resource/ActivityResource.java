package de.jkliff.timetracker.rest.resource;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.google.gson.Gson;

import de.jkliff.timetracker.core.model.Activity;
import de.jkliff.timetracker.core.service.ActivityService;
import de.jkliff.timetracker.util.ApplicationContextSingleton;

//@Component(ActivityResource.BEAN_ID)
@Path("/")
public class ActivityResource {
	public static final String BEAN_ID = "ActivityResource";
	
	// @Autowired
	private ActivityService activityService = (ActivityService) ApplicationContextSingleton
			.getApplicationContext().getBean(ActivityService.BEAN_ID);

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

	@GET
	@Path("/activity")
	public String get() {
		return "asdf";
	}

}
