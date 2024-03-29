package de.jkliff.timetracker.core.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import de.jkliff.timetracker.core.model.Activity;
import de.jkliff.timetracker.core.persistence.ActivitySummaryDAO;
import de.jkliff.timetracker.core.persistence.impl.ActivityDAO;
import de.jkliff.timetracker.core.service.ActivityService;
import de.jkliff.timetracker.core.service.builder.QueryBuilder;
import de.jkliff.timetracker.core.service.dto.ActivitySummary;
import de.jkliff.timetracker.core.service.query.ActivitySummaryQuery;

@Service(ActivityService.BEAN_ID)
public class ActivityServiceImpl
        implements ActivityService {
    @Autowired
    private ActivityDAO        activityDAO;
    @Autowired
    private ActivitySummaryDAO activitySummaryDAO;

    @Override
    @Transactional
    public long save (Activity a1) {
        activityDAO.save (a1);
        return a1.getId ();
    }

    @Override
    public Activity load (long id1) {
        return activityDAO.load (Activity.class, id1);
    }

    @Override
    public List<ActivitySummary> list (final ActivitySummaryQuery query) {
        List<ActivitySummary> r;

        if (query == null) {
            r = activitySummaryDAO.find (QueryBuilder.findActivitySummaries ().build ().toHql ());
        } else {

            r = activitySummaryDAO.find (query.toHql ());
        }
        return r;
    }

    @Override
    @Transactional
    public void delete (long id) {
        Activity a = activityDAO.load (Activity.class, id);
        activityDAO.delete (a);
    }

    @Override
    public void closeLast () {
        // TODO Auto-generated method stub
        
    }

}
