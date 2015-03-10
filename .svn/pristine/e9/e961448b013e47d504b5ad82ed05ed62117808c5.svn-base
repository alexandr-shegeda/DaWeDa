/* 
 * Hibernate, Relational Persistence for Idiomatic Java
 * 
 * JBoss, Home of Professional Open Source
 * Copyright 2013 Red Hat Inc. and/or its affiliates and other contributors
 * as indicated by the @authors tag. All rights reserved.
 * See the copyright.txt in the distribution for a
 * full listing of individual contributors.
 *
 * This copyrighted material is made available to anyone wishing to use,
 * modify, copy, or redistribute it subject to the terms and conditions
 * of the GNU Lesser General Public License, v. 2.1.
 * This program is distributed in the hope that it will be useful, but WITHOUT A
 * WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS FOR A
 * PARTICULAR PURPOSE.  See the GNU Lesser General Public License for more details.
 * You should have received a copy of the GNU Lesser General Public License,
 * v.2.1 along with this distribution; if not, write to the Free Software
 * Foundation, Inc., 51 Franklin Street, Fifth Floor, Boston,
 * MA  02110-1301, USA.
 */
package com.daveda.repository.dao.impl;

import com.daveda.repository.dao.AbstractDAO;
import com.google.common.base.Preconditions;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.io.Serializable;

public abstract class AbstractDAOImpl <T extends Serializable> implements AbstractDAO<T> {

    @PersistenceContext(unitName = "DaWeDa-mysql-unit")
	protected EntityManager entityManager;

    private Class<T> entityClass;

    public AbstractDAOImpl(final Class<T> entityClass) {
        this.entityClass = entityClass;
    }

    public AbstractDAOImpl() {
    }

    @Override
    public final T findOne(final long id) {
        return (T) entityManager.find(entityClass, id);
    }

    @Override
    public final void create(final T entity) {
        Preconditions.checkNotNull(entity);
        entityManager.persist(entity);
    }

    @Override
    public T update(final T entity) {
        Preconditions.checkNotNull(entity);
        return entityManager.merge(entity);
    }

    @Override
    public final void delete(final T entity) {
        Preconditions.checkNotNull(entity);
        entityManager.remove(entityManager.merge(entity));
    }

    @Override
    public final void deleteById(final long entityId) {
        final T entity = findOne(entityId);
        Preconditions.checkState(entity != null);
        entityManager.remove(entity);
    }

    public EntityManager getEntityManager() {
        return entityManager;
    }

    public void setEntityManager(EntityManager entityManager) {
        this.entityManager = entityManager;
    }
}
