package de.jkliff.timetracker.core.persistence.impl;

import org.springframework.stereotype.Repository;

import de.jkliff.timetracker.core.model.Activity;
import de.jkliff.timetracker.core.persistence.AbstractEntityDAOImpl;

@Repository
public class ActivityDAO

        extends AbstractEntityDAOImpl<Activity> {

    @Override
    protected Class<Activity> getEntityClass () {
        return Activity.class;
    }

}
