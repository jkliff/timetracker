package de.jkliff.timetracker.core;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import junit.framework.Assert;
import junit.framework.TestCase;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;

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
public class SimpleFlowITest extends TestCase {

	private static final String A1_NAME = "studying music";
	@Resource
	private ActivityService activityService;

	@Test
	public void testSimpleFlow() throws ParseException {
		try {
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-mm-DD HH:MM");
			Date date1 = sdf.parse("2011-10-13 13:00");
			Date date2 = sdf.parse("2011-10-13 14:00");

			Activity a1 = ActivityBuilder.forGroup("default")
					.startedAt("2011-10-10 13:00")
					.finishedAt("2011-10-10 14:00").named(A1_NAME)
					.withTags("test", "study", "music").build();

			Assert.assertNotNull(a1);
			Assert.assertEquals(A1_NAME, a1.getName());
			
			Activity a1Copy = ActivityBuilder.fromActivity(a1).startedAt(date1)
					.inProgress().build();

			long id1 = activityService.save(a1);
			long id2 = activityService.save(a1Copy);

			System.out.println(id1);
			System.out.println(id2);
			
			Activity a1Loaded = activityService.load(id1);
			Assert.assertNotNull(a1Loaded);
			Assert.assertEquals(A1_NAME, a1Loaded.getName());

			// TODO: check that a1Loaded is ok

			List<ActivitySummary> activitySummaries = activityService
					.list(QueryBuilder.findActivities(10)
							.from("2011-10-11 13:00").to("2011-10-12 12:00")
							.taggedWith("work").build());

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

	@Test
	public void testInvalidTimesActivityTest() {

	}
}
