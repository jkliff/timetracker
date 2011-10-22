package de.jkliff.timetracker.core.service.builder;

import de.jkliff.timetracker.core.service.query.ActivitySummaryQuery;


public class QueryBuilder {

	public static ActivitySumamryQueryBuilder findActivitySummaries() {
		return ActivitySumamryQueryBuilder.createNewQuery();
	}

}
