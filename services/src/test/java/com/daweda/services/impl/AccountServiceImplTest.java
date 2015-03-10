package com.daweda.services.impl;

import com.daveda.repository.dao.AccountDAO;
import com.daweda.model.entity.Account;
import com.daweda.services.cache.AccountCache;
import com.daweda.services.cache.impl.AccountCacheImpl;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import javax.cache.Cache;

import static org.junit.Assert.*;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class AccountServiceImplTest
{
    @Mock
    private AccountDAO dao;

    @Mock
    private AccountCache cache;

    @Mock
    private Cache cacheInterface;

    @InjectMocks
    private AccountServiceImpl accountService = new AccountServiceImpl();

    @Test
    public void testCreateStartAccount() throws Exception
    {
        when(dao.createStartAccount()).thenReturn(new Account());
        when(cache.getCache()).thenReturn(cacheInterface);
        assertNotNull(accountService.createStartAccount());
    }
}