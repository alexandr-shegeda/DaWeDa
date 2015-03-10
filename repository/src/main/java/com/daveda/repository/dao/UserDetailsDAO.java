package com.daveda.repository.dao;

import com.daweda.model.entity.UserDetails;

/**
 * Created by elena on 20.02.15.
 */
public interface UserDetailsDAO extends AbstractDAO<UserDetails> {
    UserDetails createStartUserDetails();
}
