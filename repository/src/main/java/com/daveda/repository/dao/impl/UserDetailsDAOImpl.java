package com.daveda.repository.dao.impl;

import com.daveda.repository.dao.UserDetailsDAO;
import com.daweda.model.entity.UserDetails;
import org.apache.felix.scr.annotations.Component;
import org.apache.felix.scr.annotations.Service;

/**
 * Created by elena on 20.02.15.
 */
@Service
@Component(immediate = true)
public class UserDetailsDAOImpl extends AbstractDAOImpl<UserDetails> implements UserDetailsDAO {

    public UserDetailsDAOImpl() {
    }

    @Override
    public UserDetails createStartUserDetails() {
        UserDetails userDetails = new UserDetails();
        userDetails.setFirstName("default");
        entityManager.persist(userDetails);
        return userDetails;
    }

}
