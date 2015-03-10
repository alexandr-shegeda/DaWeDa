package com.daweda.services.cache.impl;

import com.daveda.repository.dao.AccountDAO;
import com.daweda.model.entity.Account;
import com.daweda.services.cache.AccountCache;
import com.daweda.services.cache.listeners.factories.AccountCacheListenerFactory;
import com.daweda.services.cache.persistence.AccountCachePersistence;
import org.apache.felix.scr.annotations.Component;
import org.apache.felix.scr.annotations.Reference;
import org.apache.felix.scr.annotations.Service;

import javax.cache.Cache;
import javax.cache.CacheManager;
import javax.cache.Caching;
import javax.cache.configuration.CompleteConfiguration;
import javax.cache.configuration.FactoryBuilder;
import javax.cache.configuration.MutableCacheEntryListenerConfiguration;
import javax.cache.configuration.MutableConfiguration;
import javax.cache.expiry.AccessedExpiryPolicy;
import javax.cache.expiry.Duration;
import javax.cache.spi.CachingProvider;
import java.util.concurrent.TimeUnit;

/**
 * Created by aleksandrsizov on 28.02.15.
 */
@Component(immediate = true)
@Service
public class AccountCacheImpl implements AccountCache {

    @Reference
    AccountDAO dao;

    private Cache<Long, Account> cache;

//    @Activate
    public void init(){
        CachingProvider cachingProvider = Caching.getCachingProvider();
        CacheManager cacheManager = cachingProvider.getCacheManager();
        CompleteConfiguration<Long, Account> config =
                new MutableConfiguration<Long, Account>()
                        .setTypes(Long.class, Account.class)
                        .setExpiryPolicyFactory(FactoryBuilder.factoryOf(
                                new AccessedExpiryPolicy(new Duration(TimeUnit.SECONDS, 30))
                        ))
                        .setReadThrough(true)
                        .setWriteThrough(true)
                        .setCacheLoaderFactory(FactoryBuilder.factoryOf(
                                new AccountCachePersistence(dao)
                        ))
                        .setCacheWriterFactory(FactoryBuilder.factoryOf(
                                new AccountCachePersistence(dao)
                        ))
                        .addCacheEntryListenerConfiguration(
                                new MutableCacheEntryListenerConfiguration<Long, Account>(
                                        new AccountCacheListenerFactory(),
                                        null, true, true
                                )
                        );
        cache = cacheManager.createCache("accounts", config);
    }

    @Override
    public Cache<Long, Account> getCache() {
        return cache;
    }
}
