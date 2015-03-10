package com.daveda.repository.dao.impl;

import com.daveda.repository.dao.CreditCardDAO;
import com.daweda.model.entity.Account;
import com.daweda.model.entity.CreditCard;
import org.apache.felix.scr.annotations.Component;
import org.apache.felix.scr.annotations.Service;

import javax.persistence.NoResultException;
import javax.persistence.TypedQuery;

@Service
@Component(immediate = true)
public class CreditCardDAOImpl extends AbstractDAOImpl<CreditCard>  implements CreditCardDAO{


    private static final String FIND_USERS_CARD_BY_NUMBER = "SELECT c FROM CreditCard c "
            + "WHERE c.account = :account AND c.number = :number";

    public CreditCardDAOImpl() {
        super(CreditCard.class);
    }

    @Override
    public CreditCard findUsersCardByNumber(Account account, String number) {
        TypedQuery<CreditCard> tq = entityManager.createQuery(FIND_USERS_CARD_BY_NUMBER,
                CreditCard.class);
        tq.setParameter("number", number);
        tq.setParameter("account", account);
        try{
            return tq.getSingleResult();
        } catch (NoResultException e){
            return null;
        }
    }
}
