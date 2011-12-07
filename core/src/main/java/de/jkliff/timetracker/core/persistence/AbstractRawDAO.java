package de.jkliff.timetracker.core.persistence;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.hibernate.ejb.HibernateEntityManager;

public class AbstractRawDAO {
    @PersistenceContext
    private EntityManager entityManager;

    protected EntityManager getEntityManager () {
        return entityManager;
    }

    protected HibernateEntityManager getDelegate () {
        return (HibernateEntityManager) entityManager.getDelegate ();
    }
}
