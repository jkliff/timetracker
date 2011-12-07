package de.jkliff.timetracker.core.service.dto;

import java.util.Date;

import de.jkliff.timetracker.core.model.SummaryEntity;

public class ActivitySummary
        extends SummaryEntity {
    private Long   id;
    private String name;
    private Date   start;
    private Date   end;

    public String getName () {
        return name;
    }

    public void setName (String name) {
        this.name = name;
    }

    public Date getStart () {
        return start;
    }

    public void setStart (Date start) {
        this.start = start;
    }

    public Date getEnd () {
        return end;
    }

    public void setEnd (Date end) {
        this.end = end;
    }

    public Long getId () {
        return id;
    }

    public void setId (Long id) {
        this.id = id;
    }
}
