package com.daweda.services.impl;

import com.daveda.repository.dao.UserDAO;
import com.daweda.model.entity.User;
import com.daweda.services.UserService;
import org.apache.felix.scr.annotations.Reference;
import org.apache.felix.scr.annotations.Service;

/**
 * Created by elena on 20.02.15.
 */

@Service
public class UserServiceImpl implements UserService {

    @Reference
    private UserDAO dao;

    public UserServiceImpl() {
        // TODO Auto-generated constructor stub
    }

//    @Override
//    protected Dao<User> getDao() {
//        return dao;
//    }

    @Override
    public User findUserByEmail(String email) {
        return dao.findUserByEmail(email);
    }

    @Override
    public User findUserByToken(String token) {
        return dao.findUserByToken(token);
    }

    @Override
    public void updateIsActivatedByToken(String token, boolean activated) {
        dao.updateIsActivatedByToken(token, activated);
    }

    @Override
    public void updateIsUserPassword(String token, boolean isUserPassword) {
        dao.updateIsUserPassword(token, isUserPassword);
    }

    @Override
    public void updatePassword(String token, String newpassword) {
        dao.updatePassword(token, newpassword);
    }

    @Override
    public void updateIsChangePwdAllowed(String token,
                                         boolean isChangePwdAllowed) {
        dao.updateIsChangePwdAllowed(token, isChangePwdAllowed);
    }

}
