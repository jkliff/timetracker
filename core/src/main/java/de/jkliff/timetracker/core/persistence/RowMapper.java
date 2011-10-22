package de.jkliff.timetracker.core.persistence;

public interface RowMapper<T> {

	T mapRow(Object[] o);

}
