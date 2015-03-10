package com.daveda.repository.dao.impl;

import com.daveda.repository.dao.StatusDAO;
import com.daweda.model.entity.Status;
import org.apache.felix.scr.annotations.Component;
import org.apache.felix.scr.annotations.Service;

import javax.persistence.TypedQuery;

/**
 * Created by elena on 20.02.15.
 */
@Service
@Component(immediate = true)
public class StatusDAOImpl extends AbstractDAOImpl<Status> implements StatusDAO {

    private static final String FIND_BY_NAME = "SELECT s FROM Status s WHERE s.name = :name";

    public StatusDAOImpl() {
        super(Status.class);
    }

    @Override
    public Status findByName(String name) {
        TypedQuery<Status> typedQuery = entityManager.createQuery(FIND_BY_NAME, Status.class);
        typedQuery.setParameter("name", name);
        return typedQuery.getSingleResult();
    }
}
