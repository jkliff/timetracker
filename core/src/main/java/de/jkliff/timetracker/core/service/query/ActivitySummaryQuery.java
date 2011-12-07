package de.jkliff.timetracker.core.service.query;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.joda.time.Duration;

import com.google.common.base.Joiner;

import de.jkliff.timetracker.util.Pair;

public class ActivitySummaryQuery extends HibernateQuery {

    private Date     startedBefore;
    private Date     startedAfter;
    private Date     endedBefore;
    private Date     endedAfter;
    private Duration maxDuration;
    private Duration minDuration;

    @Override
    public Pair<String, Map<String, Object>> toHql() {

        List<String> clausules = new ArrayList<String>();
        Map<String, Object> params = new HashMap<String, Object>();

        if (startedBefore != null) {
            clausules.add("a.start <= :maxStart");
            params.put("maxStart", startedBefore);
        }
        if (startedAfter != null) {
            clausules.add("a.start >= :minStart");
            params.put("minStart", startedAfter);
        }

        if (endedBefore != null) {
            clausules.add("a.end <= :maxEnd");
            params.put("maxEnd", endedBefore);
        }

        if (endedAfter != null) {
            clausules.add("a.end >= :minEnd");
            params.put("minEnd", endedAfter);
        }

        Pair<String, Map<String, Object>> pair = Pair.of(String.format(
                "select a.id, a.name, a.start, a.end from Activity a %s", clausules.isEmpty() ? "" : ("where " + Joiner
                        .on(" and ").join(clausules))), params);

        return pair;
    }

    public Date getStartedBefore() {
        return startedBefore;
    }

    public void setStartedBefore(Date startedBefore) {
        this.startedBefore = startedBefore;
    }

    public Date getStartedAfter() {
        return startedAfter;
    }

    public void setStartedAfter(Date startedAfter) {
        this.startedAfter = startedAfter;
    }

    public Date getEndedBefore() {
        return endedBefore;
    }

    public void setEndedBefore(Date endedBefore) {
        this.endedBefore = endedBefore;
    }

    public Date getEndedAfter() {
        return endedAfter;
    }

    public void setEndedAfter(Date endedAfter) {
        this.endedAfter = endedAfter;
    }

    public Duration getMaxDuration() {
        return maxDuration;
    }

    public void setMaxDuration(Duration maxDuration) {
        this.maxDuration = maxDuration;
    }

    public Duration getMinDuration() {
        return minDuration;
    }

    public void setMinDuration(Duration minDuration) {
        this.minDuration = minDuration;
    }

}
