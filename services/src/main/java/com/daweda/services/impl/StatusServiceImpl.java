package com.daweda.services.impl;

import com.daveda.repository.dao.StatusDAO;
import com.daweda.model.entity.Status;
import com.daweda.services.StatusService;
import org.apache.felix.scr.annotations.Reference;
import org.apache.felix.scr.annotations.Service;

/**
 * Created by elena on 20.02.15.
 */

@Service
public class StatusServiceImpl implements StatusService {

    @Reference
    private StatusDAO dao;

    public StatusServiceImpl() {
        // TODO Auto-generated constructor stub
    }

//    @Override
//    protected Dao<Status> getDao() {
//        return dao;
//    }

    @Override
    public Status findByName(String name) {
        return dao.findByName(name);
    }

}
