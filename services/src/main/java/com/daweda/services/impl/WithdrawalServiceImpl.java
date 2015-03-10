package com.daweda.services.impl;

import com.daveda.repository.dao.WithdrawalDAO;
import com.daweda.model.entity.Account;
import com.daweda.model.entity.Withdrawal;
import com.daweda.services.WithdrawalService;
import org.apache.felix.scr.annotations.Reference;
import org.apache.felix.scr.annotations.Service;

import java.util.List;

/**
 * Created by elena on 20.02.15.
 */

@Service
public class WithdrawalServiceImpl implements WithdrawalService {

    public WithdrawalServiceImpl() {
    }

    @Reference
    private WithdrawalDAO dao;

    public WithdrawalServiceImpl(WithdrawalDAO dao) {
        // TODO Auto-generated constructor stub
        this.dao = dao;
    }

//    @Override
//    protected Dao<Withdrawal> getDao() {
//        return dao;
//    }

    @Override
    public List<Withdrawal> findByAccount(Account account) {
        return dao.findByAccount(account);
    }

    @Override
    public double calculateProcessedWithdrawals() {
        return dao.calculateProcessedWithdrawals();
    }

}
