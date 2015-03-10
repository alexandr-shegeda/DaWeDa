package com.daveda.repository.dao;

import com.daweda.model.UserInfo;

/**
 * Created by elena on 04.03.15.
 */
public interface UserInfoDAO {
    public void insert(UserInfo userInfo, int userCredentialsID);
    public UserInfo findById(int id);
}
