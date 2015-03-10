package com.daweda.services;

import com.daweda.model.entity.Account;
import com.daweda.model.entity.Withdrawal;

import java.util.List;

/**
 * Created by elena on 20.02.15.
 */
public interface WithdrawalService {

    List<Withdrawal> findByAccount(Account account);
    double calculateProcessedWithdrawals();
}
