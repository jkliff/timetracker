package de.jkliff.timetracker.core.persistence;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import de.jkliff.timetracker.core.persistence.model.PersistentEntity;
import de.jkliff.timetracker.core.service.dto.ActivitySummary;

public abstract class AbstractEntityDAOImpl<T extends PersistentEntity> extends
		AbstractRawDAO implements SimpleDAO<T> {
	

	@Override
	public T load(Class<T> c, long id1) {
		return getEntityManager().find(c, id1);
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
			getEntityManager().persist(t);
		} else {
			getEntityManager().merge(t);
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
