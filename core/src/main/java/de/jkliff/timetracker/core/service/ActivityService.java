package de.jkliff.timetracker.core.service;

import java.util.List;

import de.jkliff.timetracker.core.model.Activity;
import de.jkliff.timetracker.core.service.dto.ActivitySummary;
import de.jkliff.timetracker.core.service.query.ActivityQuery;

public interface ActivityService {

	long save(Activity a1);

	Activity load(long id1);

	List<ActivitySummary> list(ActivityQuery build);

}
