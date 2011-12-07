package de.jkliff.timetracker.core.service.builder;

import java.text.ParseException;

import de.jkliff.timetracker.core.service.query.ActivitySummaryQuery;
import de.jkliff.timetracker.util.ParseUtils;

public class ActivitySumamryQueryBuilder {

    private ActivitySummaryQuery query;

    private ActivitySumamryQueryBuilder(ActivitySummaryQuery query) {
        this.query = query;
    }

    public ActivitySummaryQuery build () {
        return this.query;
    }

    public ActivitySumamryQueryBuilder taggedWith (String string) {

        return this;
    }

    public static ActivitySumamryQueryBuilder createNewQuery () {
        return new ActivitySumamryQueryBuilder (new ActivitySummaryQuery ());
    }

    public ActivitySumamryQueryBuilder startedBefore (String string)
            throws ParseException {
        this.query.setStartedBefore (ParseUtils.parseDate (string));
        return this;
    }

    public ActivitySumamryQueryBuilder endedAfter (String string)
            throws ParseException {
        this.query.setEndedAfter (ParseUtils.parseDate (string));
        return this;
    }

    public ActivitySumamryQueryBuilder startedAfter (String string)
            throws ParseException {
        this.query.setStartedAfter (ParseUtils.parseDate (string));
        return this;
    }

    public ActivitySumamryQueryBuilder endedBefore (String string)
            throws ParseException {
        this.query.setEndedBefore (ParseUtils.parseDate (string));
        return this;
    }

    public ActivitySumamryQueryBuilder longerThan (String string) {
        // TODO Auto-generated method stub
        return this;
    }

    public ActivitySumamryQueryBuilder shorterThan (String string) {
        // TODO Auto-generated method stub
        return this;
    }
}
