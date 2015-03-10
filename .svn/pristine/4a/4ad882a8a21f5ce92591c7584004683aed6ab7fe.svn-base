package com.daweda.services.cache.persistence;

import com.daveda.repository.dao.AccountDAO;
import com.daweda.model.entity.Account;

import javax.cache.Cache;
import javax.cache.integration.CacheLoader;
import javax.cache.integration.CacheLoaderException;
import javax.cache.integration.CacheWriter;
import javax.cache.integration.CacheWriterException;
import java.io.Serializable;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * Created by aleksandrsizov on 28.02.15.
 */
public class AccountCachePersistence implements CacheLoader<Long, Account>, CacheWriter<Long, Account>, Serializable {

    private AccountDAO dao;

    public AccountCachePersistence(AccountDAO dao) {
        this.dao = dao;
    }

    @Override
    public Account load(Long id) throws CacheLoaderException {
        return dao.findOne(id);
    }

    //TODO should be refactored. This operation should be done with one query per collection but not with one query per one entity as it is done now
    @Override
    public Map<Long, Account> loadAll(Iterable<? extends Long> ids) throws CacheLoaderException {
        Map<Long, Account> result = new HashMap();
        for(Long id : ids){
            result.put(id, load(id));
        }

        return result;
    }

    @Override
    public void write(Cache.Entry<? extends Long, ? extends Account> entry) throws CacheWriterException {
         dao.update(entry.getValue());
    }

    @Override
    public void writeAll(Collection<Cache.Entry<? extends Long, ? extends Account>> entries) throws CacheWriterException {
        Iterator<Cache.Entry<? extends Long, ? extends Account>> iterator = entries.iterator();
        while (iterator.hasNext()) {
            write(iterator.next());
            iterator.remove();
        }
    }

    @Override
    public void delete(Object key) throws CacheWriterException {
        if (!(key instanceof Long)) {
            throw new CacheWriterException("Illegal key type");
        }
        // Remove user using dao
        dao.deleteById((Long)key);

    }

    //TODO should be refactored. This operation should be done with one query per collection but not with one query per one entity as it is done now
    @Override
    public void deleteAll(Collection<?> keys) throws CacheWriterException {
        Iterator<?> iterator = keys.iterator();
        while (iterator.hasNext()) {
            delete(iterator.next());
            iterator.remove();
        }
    }
}
