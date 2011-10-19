package de.jkliff.timetracker.core.service.query;

import java.util.Date;

public class ActivityQuery extends HibernateQuery {

	private int limit;
	private Date fromDate;
	private Date toDate;

	
	@Override
	public String toHql() {
		return "select a.id, a.name, a.start, a.end from Activity a";
	}

	public int getLimit() {
		return limit;
	}

	public void setLimit(int limit) {
		this.limit = limit;
	}

	public Date getFromDate() {
		return fromDate;
	}

	public void setFromDate(Date fromDate) {
		this.fromDate = fromDate;
	}

	public Date getToDate() {
		return toDate;
	}

	public void setToDate(Date toDate) {
		this.toDate = toDate;
	}

}
