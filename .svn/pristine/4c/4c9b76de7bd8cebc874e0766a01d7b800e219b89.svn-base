package com.daveda.repository.dao.impl;

import com.daveda.repository.dao.AssetPriceDAO;
import com.daweda.model.entity.AssetPrice;
import org.apache.felix.scr.annotations.Component;
import org.apache.felix.scr.annotations.Service;

import javax.persistence.TypedQuery;
import java.util.Date;
import java.util.List;

@Service
@Component(immediate = true)
public class AssetPriceDAOImpl extends AbstractDAOImpl<AssetPrice> implements AssetPriceDAO
{
    private static final String FIND_BY_ID = "SELECT a FROM AssetPrice a WHERE a.id = :id";
    private static final String FIND_BY_TIME = "SELECT a FROM AssetPrice a WHERE a.time = :time";
    private static final String FIND_BY_PRICE = "SELECT a FROM AssetPrice a WHERE a.price = :price";

    @Override
    public boolean insert(AssetPrice assetPrice) {
        return false;
    }

    @Override
    public AssetPrice findById(int id) {
        TypedQuery<AssetPrice> tq = entityManager.createQuery(FIND_BY_ID, AssetPrice.class);
        tq.setParameter("id", id);
        return tq.getSingleResult();
    }

    @Override
    public List<AssetPrice> findByTime(Date time) {
        TypedQuery<AssetPrice> tq = entityManager.createQuery(FIND_BY_TIME, AssetPrice.class);
        tq.setParameter("time", time);
        return tq.getResultList();
    }

    @Override
    public List<AssetPrice> findByPrice(float price) {
        TypedQuery<AssetPrice> tq = entityManager.createQuery(FIND_BY_PRICE, AssetPrice.class);
        tq.setParameter("price", price);
        return tq.getResultList();
    }
}
