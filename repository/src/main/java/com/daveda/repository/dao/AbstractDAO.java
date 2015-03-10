package com.daveda.repository.dao;

import java.io.Serializable;

/**
 * Created by aleksandrsizov on 19.02.15.
 */
public interface AbstractDAO <T extends Serializable>{

    T findOne(final long id);

    void create(final T entity);

    T update(final T entity);

    void delete(final T entity);

    void deleteById(final long entityId);


}
