package de.jkliff.timetracker.core.persistence;

import java.util.List;

public interface SimpleDAO<T> {

    List<T> list();

    List<T> list(int limit, int offset);

    long save(T t);

    void update(T t);

    void delete(T t);

    T load(Class<T> c, long id1);
}
