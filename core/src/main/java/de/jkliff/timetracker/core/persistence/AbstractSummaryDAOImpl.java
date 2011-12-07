package de.jkliff.timetracker.core.persistence;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.persistence.Query;

import de.jkliff.timetracker.core.model.SummaryEntity;
import de.jkliff.timetracker.util.Pair;

public class AbstractSummaryDAOImpl <T extends SummaryEntity>
        extends AbstractRawDAO {

    public List<T> find (final String hql,
                         RowMapper<T> mapper) {
        Query query = getEntityManager ().createQuery (hql);
        return query.getResultList ();
    }

    public List<T> find (final Pair<String, Map<String, Object>> hqlWithParams,
                         RowMapper<T> mapper) {

        Query query = getEntityManager ().createQuery (hqlWithParams.first ());
        Map<String, Object> params = hqlWithParams.second ();

        for (String k : params.keySet ()) {
            query.setParameter (k, params.get (k));
        }

        return mapSummaryRows (query.getResultList (), mapper);
    }

    private List<T> mapSummaryRows (List<Object[]> resultList,
                                    RowMapper<T> mapper) {
        List<T> mappedList = new ArrayList<T> (resultList.size ());
        for (Object[] o : resultList) {
            mappedList.add (mapper.mapRow (o));
        }
        return mappedList;
    }
}
