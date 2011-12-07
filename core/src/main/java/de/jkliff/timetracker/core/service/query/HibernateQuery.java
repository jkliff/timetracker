package de.jkliff.timetracker.core.service.query;

import java.util.Map;

import de.jkliff.timetracker.util.Pair;

public abstract class HibernateQuery {
    public abstract Pair<String, Map<String, Object>> toHql();

}
