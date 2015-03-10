package com.daweda.services.cache.listeners.factories;

import com.daweda.model.entity.Account;
import com.daweda.services.cache.listeners.AccountCacheListener;

import javax.cache.configuration.Factory;
import javax.cache.event.CacheEntryListener;

/**
 * Created by aleksandrsizov on 28.02.15.
 */
public class AccountCacheListenerFactory  implements Factory<CacheEntryListener<Long, Account>> {
    @Override
    public CacheEntryListener<Long, Account> create() {
        return new AccountCacheListener();
    }
}
