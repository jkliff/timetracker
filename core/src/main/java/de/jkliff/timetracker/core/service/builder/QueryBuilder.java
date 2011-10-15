package de.jkliff.timetracker.core.service.builder;


public class QueryBuilder {

	public static ActivityQueryBuilder findActivities(int limit) {
		return new ActivityQueryBuilder().limit(limit);
	}

}
