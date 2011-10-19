package de.jkliff.timetracker.core.persistence;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

public class AbstractRawDAO {
	@PersistenceContext
	private EntityManager entityManager;

	protected EntityManager getEntityManager() {
		return entityManager;
	}
}
