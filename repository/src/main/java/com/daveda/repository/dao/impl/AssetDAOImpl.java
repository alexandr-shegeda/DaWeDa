package com.daveda.repository.dao.impl;

import com.daveda.repository.dao.AssetDAO;
import com.daweda.model.entity.Asset;
import org.apache.felix.scr.annotations.Component;
import org.apache.felix.scr.annotations.Service;


import javax.persistence.TypedQuery;


@Service
@Component(immediate = true)
public class AssetDAOImpl extends AbstractDAOImpl<Asset> implements AssetDAO {

    private static final String FIND_BY_ID = "SELECT a FROM Asset a WHERE a.id_asset = :id";
    private static final String FIND_BY_NAME = "SELECT a FROM Asset a WHERE a.name = :name";
    private static final String FIND_BY_ABBREVIATION = "SELECT a FROM Asset a WHERE a.abbr = :abbreviation";

    @Override
    public boolean insert(Asset asset) {
        Asset o = asset;
        create(o);
        if (o != null) {
            return (o.getIdAsset()!=0);
        }
        return false;
    }

    @Override
    public Asset findById(int id) {
        TypedQuery<Asset> tq = entityManager.createQuery(FIND_BY_ID, Asset.class);
        tq.setParameter("id", id);
        return tq.getSingleResult();
    }

    @Override
    public Asset findByName(String name) {
        TypedQuery<Asset> tq = entityManager.createQuery(FIND_BY_NAME, Asset.class);
        tq.setParameter("name", name);
        return tq.getSingleResult();
    }

    @Override
    public Asset findByAbbreviation(String abbreviation) {
        TypedQuery<Asset> tq = entityManager.createQuery(FIND_BY_ABBREVIATION, Asset.class);
        tq.setParameter("abbreviation", abbreviation);
        return tq.getSingleResult();
    }
}
