package com.daveda.repository.dao.impl;

import com.daveda.repository.dao.AbstractDAO;
import com.daveda.repository.dao.WithdrawalDAO;
import com.daweda.model.entity.Account;
import com.daweda.model.entity.Withdrawal;
import org.apache.felix.scr.annotations.Component;
import org.apache.felix.scr.annotations.Service;

import javax.persistence.TypedQuery;
import java.util.List;

/**
 * Created by elena on 20.02.15.
 */
@Service
@Component(immediate = true)
public class WithdrawalDAOImpl extends AbstractDAOImpl<Withdrawal> implements WithdrawalDAO {

    private static final String FIND_BY_ACCOUNT = "SELECT w FROM Withdrawal w WHERE w.account = :account";
    private static final String CALC_PROCESSED_AMOUNT = "SELECT SUM(w.amount) FROM Withdrawal w WHERE w.isProcessed = true";

    public WithdrawalDAOImpl() {
        super(Withdrawal.class);
    }

    @Override
    public List<Withdrawal> findByAccount(Account account) {
        TypedQuery<Withdrawal> typedQuery = entityManager.createQuery(FIND_BY_ACCOUNT,
                Withdrawal.class);
        typedQuery.setParameter("account", account);
        return typedQuery.getResultList();
    }

    @Override
    public double calculateProcessedWithdrawals() {
        TypedQuery<Double> typedQuery = entityManager.createQuery(CALC_PROCESSED_AMOUNT,
                Double.class);
        try{
            return typedQuery.getSingleResult();
        } catch(NullPointerException e){
            return 0;
        }

    }

}
