package de.jkliff.timetracker.core.persistence;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import de.jkliff.timetracker.core.persistence.model.PersistentEntity;

public abstract class AbstractDAOImpl<T extends PersistentEntity> implements
		SimpleDAO<T> {
	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public T load(Class<T> c, long id1) {
		return entityManager.find(c, id1);
	}

	@Override
	public List<T> list() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<T> list(int limit, int offset) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public long save(T t) {
		if (t.getPersistentId() == null) {
			entityManager.persist(t);
		} else {
			entityManager.merge(t);
		}

		return t.getPersistentId();
	}

	@Override
	public void update(T t) {
		// TODO Auto-generated method stub

	}

	@Override
	public void delete(T t) {
		// TODO Auto-generated method stub

	}
}
