package de.jkliff.timetracker.core.domain.builder;

import java.text.ParseException;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import org.apache.commons.beanutils.BeanUtils;

import de.jkliff.timetracker.core.model.Activity;
import de.jkliff.timetracker.core.model.ActivityTag;
import de.jkliff.timetracker.core.service.exception.InvalidActivityException;
import de.jkliff.timetracker.util.ParseUtils;

public class ActivityBuilder {
    private String      group;
    private Activity    activity;
    private Set<String> tags = new HashSet<String> ();

    public ActivityBuilder(String group) {
        this.activity = new Activity ();
        this.group = group;
    }

    public ActivityBuilder(Activity a1) throws InvalidActivityException {
        try {
            this.activity = (Activity) BeanUtils.cloneBean (a1);
        } catch (Exception e) {
            throw new InvalidActivityException (e);
        }
    }

    public Activity build () {

        activity.setTags (buildTags (tags));

        return activity;
    }

    private Set<ActivityTag> buildTags (Set<String> tags2) {
        // TODO Auto-generated method stub
        return null;
    }

    public ActivityBuilder startedAt (Date date1) {
        // TODO Auto-generated method stub
        return this;
    }

    public ActivityBuilder finishedAt (String d)
            throws ParseException {

        activity.setEnd (ParseUtils.parseDate (d));

        return this;
    }

    public ActivityBuilder named (String n) {
        activity.setName (n);
        return this;
    }

    public ActivityBuilder withTags (String... tags) {
        for (String t : tags) {
            this.tags.add (t);
        }

        return this;

    }

    public ActivityBuilder startedAt (String d)
            throws ParseException {

        activity.setStart (ParseUtils.parseDate (d));
        return this;
    }

    public ActivityBuilder inProgress () {
        activity.setEnd (null);
        return this;

    }

    public static ActivityBuilder fromActivity (Activity a1)
            throws InvalidActivityException {
        return new ActivityBuilder (a1);
    }

    /**
     * TODO: if there's some different types of Activities, control their
     * creation here.
     * 
     * @param string
     * @return
     */
    public static ActivityBuilder forGroup (String group) {
        return new ActivityBuilder (group);
    }

}
