package de.jkliff.timetracker.core.service.builder;

import de.jkliff.timetracker.core.service.query.ActivityQuery;


public class QueryBuilder {

	public static ActivityQueryBuilder findActivities() {
		return ActivityQueryBuilder.createNewQuery();
	}

}
