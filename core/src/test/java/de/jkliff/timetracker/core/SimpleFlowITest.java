package de.jkliff.timetracker.core;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import junit.framework.Assert;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import de.jkliff.timetracker.core.domain.builder.ActivityBuilder;
import de.jkliff.timetracker.core.model.Activity;
import de.jkliff.timetracker.core.service.ActivityService;
import de.jkliff.timetracker.core.service.builder.QueryBuilder;
import de.jkliff.timetracker.core.service.dto.ActivitySummary;
import de.jkliff.timetracker.core.service.exception.InvalidActivityException;

/**
 * Unit test for simple App.
 */
@ContextConfiguration("classpath:context.xml")
@RunWith(SpringJUnit4ClassRunner.class)
public class SimpleFlowITest {

    private static final String A1_NAME = "studying music";
    @Resource
    private ActivityService     activityService;

    @Test
    public void testSimpleFlow() throws ParseException {
        try {
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-mm-DD HH:MM");
            Date date1 = sdf.parse("2011-10-13 13:00");
            Date date2 = sdf.parse("2011-10-13 14:00");

            Activity a1 = ActivityBuilder.forGroup("default").startedAt("2011-10-10 13:00")
                    .finishedAt("2011-10-10 14:00").named(A1_NAME).withTags("test", "study", "music").build();

            Assert.assertNotNull(a1);
            Assert.assertEquals(A1_NAME, a1.getName());

            Activity a1Copy = ActivityBuilder.fromActivity(a1).startedAt(date1).inProgress().build();

            long id1 = activityService.save(a1);
            long id2 = activityService.save(a1Copy);

            Activity a1Loaded = activityService.load(id1);
            Assert.assertNotNull(a1Loaded);
            Assert.assertEquals(A1_NAME, a1Loaded.getName());

            // TODO: check that a1Loaded is ok

            List<ActivitySummary> activitySummaries = activityService.list(QueryBuilder.findActivitySummaries()
                    .taggedWith("work").build());
            Assert.assertNotNull(activitySummaries);

            activitySummaries = activityService.list(QueryBuilder.findActivitySummaries()
                    .startedBefore("2011-10-10 09:00").endedAfter("2011-10-10 15:00").taggedWith("work").build());

            Assert.assertNotNull(activitySummaries);
            Assert.assertEquals(0, activitySummaries.size());

            activitySummaries = activityService.list(QueryBuilder.findActivitySummaries()
                    .startedAfter("2011-10-10 13:00").endedBefore("2011-10-10 16:30").taggedWith("work").build());
            Assert.assertNotNull(activitySummaries);
            Assert.assertEquals(6, activitySummaries.size());

            activitySummaries = activityService.list(QueryBuilder.findActivitySummaries().longerThan("1d")
                    .taggedWith("work").build());
            Assert.assertNotNull(activitySummaries);
            Assert.assertEquals(9, activitySummaries.size());

            activitySummaries = activityService.list(QueryBuilder.findActivitySummaries().shorterThan("30 min")
                    .taggedWith("work").build());
            Assert.assertNotNull(activitySummaries);
            Assert.assertEquals(9, activitySummaries.size());

            Activity a1CopyLoaded = activityService.load(id2);

            a1CopyLoaded.setEnd(new Date());
            long id2Updated = activityService.save(a1CopyLoaded);
            Assert.assertEquals(id2, id2Updated);

        } catch (InvalidActivityException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            Assert.fail();
        }
    }

    @Before
    public void saveTestData() throws ParseException {

        Activity[] activities = new Activity[] {
                ActivityBuilder.forGroup("default").startedAt("2011-10-10 13:00").finishedAt("2011-10-10 13:30")
                        .named("tomando banho").withTags("test").build(),
                ActivityBuilder.forGroup("default").startedAt("2011-10-10 13:30").finishedAt("2011-10-10 13:35")
                        .named("escovando os dentes").withTags("test").build(),
                ActivityBuilder.forGroup("default").startedAt("2011-10-10 14:00").finishedAt("2011-10-10 14:20")
                        .named("indo para o trabalho").withTags("test").build(),
                ActivityBuilder.forGroup("default").startedAt("2011-10-10 14:30").finishedAt("2011-10-10 15:00")
                        .named("almoço").withTags("test").build(),
                ActivityBuilder.forGroup("default").startedAt("2011-10-10 15:00").finishedAt("2011-10-10 15:05")
                        .named("escovando os dentes novamente").withTags("test").build(),
                ActivityBuilder.forGroup("default").startedAt("2011-10-10 16:00").finishedAt("2011-10-11 17:00")
                        .named("viagem intercontinental").withTags("test").build(),
                ActivityBuilder.forGroup("default").startedAt("2011-10-12 09:00").finishedAt("2011-10-12 14:00")
                        .named("estudando").withTags("teste").build(),
        // ActivityBuilder.forGroup("default")
        // .startedAt("2011-10-10 13:00")
        // .finishedAt("2011-10-10 14:00").named(A1_NAME)
        // .withTags("test", "study", "music").build(),
        // ActivityBuilder.forGroup("default")
        // .startedAt("2011-10-10 13:00")
        // .finishedAt("2011-10-10 14:00").named(A1_NAME)
        // .withTags("test", "study", "music").build(),
        // ActivityBuilder.forGroup("default")
        // .startedAt("2011-10-10 13:00")
        // .finishedAt("2011-10-10 14:00").named(A1_NAME)
        // .withTags("test", "study", "music").build()
        };

        List<ActivitySummary> toDelete = activityService.list(null);

        for (ActivitySummary activity : toDelete) {
            activityService.delete(activity.getId());
        }

        for (Activity activity : activities) {
            activityService.save(activity);
        }
    }

    @Test
    public void testInvalidTimesActivityTest() {

    }

    @After
    public void deleteAllData() {

        List<ActivitySummary> list = activityService.list(null);
        System.out.println(list);
        for (ActivitySummary activitySummary : list) {
            activityService.delete(activitySummary.getId());
        }
    }

}
