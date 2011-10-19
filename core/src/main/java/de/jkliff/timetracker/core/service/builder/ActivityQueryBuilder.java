package de.jkliff.timetracker.core.service.builder;

import java.text.ParseException;

import de.jkliff.timetracker.core.service.query.ActivityQuery;
import de.jkliff.timetracker.util.ParseUtils;

public class ActivityQueryBuilder {

	private ActivityQuery query;

	private ActivityQueryBuilder(ActivityQuery query) {
		this.query = query;
	}

	public ActivityQueryBuilder limit(int limit) {
		query.setLimit(limit);
		return this;
	}

	public ActivityQuery build() {
		return this.query;
	}

	public ActivityQueryBuilder from(String string) throws ParseException {
		this.query.setFromDate(ParseUtils.parseDate(string));
		return this;
	}

	public ActivityQueryBuilder to(String string) throws ParseException {
		this.query.setToDate(ParseUtils.parseDate(string));
		return this;
	}

	public ActivityQueryBuilder taggedWith(String string) {
		// TODO Auto-generated method stub
		return this;
	}

	public static ActivityQueryBuilder createNewQuery() {
		return new ActivityQueryBuilder(new ActivityQuery());
	}
}
