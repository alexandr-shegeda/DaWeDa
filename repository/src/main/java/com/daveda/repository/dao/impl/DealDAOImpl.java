package com.daveda.repository.dao.impl;

import com.daveda.repository.dao.DealDAO;
import com.daweda.model.entity.Deal;
import org.apache.felix.scr.annotations.Component;
import org.apache.felix.scr.annotations.Service;

import javax.persistence.TypedQuery;
import java.util.List;

@Service
@Component(immediate = true)
public class DealDAOImpl extends AbstractDAOImpl<Deal> implements DealDAO{

    private static final String FIND_CURRENT_BY_ORDER_ASSET = "SELECT d FROM Deal d "
            + "WHERE d.coverOrder.assetName = :assetName AND d.expired = false";

    @Override
    public List<Deal> findCurrentByAsset(String assetName){
        TypedQuery<Deal> tq = entityManager.createQuery(FIND_CURRENT_BY_ORDER_ASSET,
                Deal.class);
        tq.setParameter("assetName", assetName);
        return tq.getResultList();
    }

}
