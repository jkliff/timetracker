package de.jkliff.timetracker.core.persistence;

import de.jkliff.timetracker.core.service.dto.ActivitySummary;

public class AbstractSummaryMapper implements RowMapper<ActivitySummary> {

	private static AbstractSummaryMapper instance = new AbstractSummaryMapper();

	@Override
	public ActivitySummary mapRow(Object[] o) {
		ActivitySummary a = new ActivitySummary();

		a.setId((Long) o[0]);

		return a;
	}

	public static RowMapper<ActivitySummary> getInstance() {
		return instance;
	}

}
