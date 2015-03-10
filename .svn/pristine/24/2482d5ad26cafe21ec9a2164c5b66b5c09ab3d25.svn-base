package com.daweda.services.impl;


import com.daveda.repository.dao.AccountDAO;
import com.daweda.model.entity.Account;
import com.daweda.services.AccountService;
import com.daweda.services.cache.AccountCache;
import org.apache.felix.scr.annotations.Component;
import org.apache.felix.scr.annotations.Reference;
import org.apache.felix.scr.annotations.Service;
import org.apache.log4j.Logger;

@Service
@Component(immediate = true)
public class AccountServiceImpl implements AccountService {

    static final Logger LOG = Logger.getLogger(AccountServiceImpl.class);

    @Reference
    private AccountDAO dao;

    @Reference
    AccountCache cache;

	@Override
	public Account createStartAccount() {
		LOG.info("FROM service");

        Account account = dao.createStartAccount();
        cache.getCache().put(account.getIdAccount(), account);
		return account;
	}

}
