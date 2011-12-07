package de.jkliff.timetracker.core.service.builder;

public class QueryBuilder {

    public static ActivitySumamryQueryBuilder findActivitySummaries () {
        return ActivitySumamryQueryBuilder.createNewQuery ();
    }

}
