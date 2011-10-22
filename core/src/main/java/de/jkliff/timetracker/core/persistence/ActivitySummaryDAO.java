package de.jkliff.timetracker.core.persistence;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import de.jkliff.timetracker.core.service.dto.ActivitySummary;
import de.jkliff.timetracker.util.Pair;

@Repository
public class ActivitySummaryDAO extends AbstractSummaryDAOImpl<ActivitySummary> {

	public List<ActivitySummary> find(
			final Pair<String, Map<String, Object>> hqlWithParams) {
		List<ActivitySummary> l = super.find(hqlWithParams,
				AbstractSummaryMapper.getInstance());

		return l;
	}
}
