package de.jkliff.timetracker.core.persistence;

import java.util.List;

import javax.persistence.Query;

import de.jkliff.timetracker.core.model.SummaryEntity;

public class AbstractSummaryDAOImpl<T extends SummaryEntity> extends AbstractRawDAO {

	public List<T> find(String hql) {
		Query createQuery = getEntityManager().createQuery(hql);
		return (List<T>) createQuery.getResultList();
	}
}
