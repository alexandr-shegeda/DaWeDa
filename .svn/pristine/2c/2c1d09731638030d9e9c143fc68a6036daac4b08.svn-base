package com.daveda.repository.dao.impl;

import com.daveda.repository.dao.AccountDAO;
import com.daweda.model.entity.Account;
import org.apache.felix.scr.annotations.Component;
import org.apache.felix.scr.annotations.Service;

/**
 * Created by aleksandrsizov on 19.02.15.
 */
@Service
@Component(immediate = true)
public class AccountDAOImpl extends AbstractDAOImpl<Account> implements AccountDAO {

    @Override
    public Account createStartAccount() {
        System.out.println("Create account");
        Account account = new Account();
        account.setBalance(500);
        create(account);
        System.out.println("account"+account.getBalance()+" "+account.getIdAccount());
        return account;
    }
}
