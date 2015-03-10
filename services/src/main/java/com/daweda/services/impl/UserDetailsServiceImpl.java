package com.daweda.services.impl;

import com.daveda.repository.dao.UserDetailsDAO;
import com.daweda.model.entity.UserDetails;
import com.daweda.services.UserDetailsService;
import org.apache.felix.scr.annotations.Component;
import org.apache.felix.scr.annotations.Reference;
import org.apache.felix.scr.annotations.Service;

/**
 * Created by elena on 20.02.15.
 */

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    @Reference
    private UserDetailsDAO dao;

    public UserDetailsServiceImpl() {
        // TODO Auto-generated constructor stub
    }

//    @Override
//    protected Dao<UserDetails> getDao() {
//        return dao;
//    }

    @Override
    public UserDetails createStartUserDetails() {
        return dao.createStartUserDetails();
    }

}
