package com.daweda.services.impl;

import com.daveda.repository.dao.WithdrawalDAO;
import com.daweda.model.entity.Account;
import com.daweda.model.entity.Withdrawal;
import com.daweda.services.WithdrawalService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.when;

/**
 * Created by elena on 02.03.15.
 */
@RunWith(MockitoJUnitRunner.class)
public class WhithdrawalServiceImplTest {

    @Mock
    private WithdrawalDAO dao;
    @Mock
    private Account account;
    @InjectMocks
     private WithdrawalService withdrawalService = new WithdrawalServiceImpl();

    @Before
    public void doSetup() {
         withdrawalService = new WithdrawalServiceImpl(dao);
    }

    @Test
    public void testFindByAccount() throws Exception{
        List <Withdrawal> withdrowalList = new ArrayList<Withdrawal>();
        withdrowalList.add(new Withdrawal());
        withdrowalList.add(new Withdrawal());
        when(dao.findByAccount(account)).thenReturn(withdrowalList);
        assertNotNull(withdrowalList);

     }
    @Test
    public void testCalculateProcessedWithdrawals() throws Exception{

        when(dao.calculateProcessedWithdrawals()).thenReturn((double) 26);

    }

}
