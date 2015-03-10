package com.daweda.services;

import com.daweda.model.entity.User;

/**
 * Created by elena on 20.02.15.
 */
public interface UserService {

    public User findUserByEmail(String email);
    public User findUserByToken(String token);
    void updateIsActivatedByToken(String token, boolean activated);
    void updateIsUserPassword(String token, boolean isUserPassword);
    void updatePassword(String token, String newpassword);
    void updateIsChangePwdAllowed(String token, boolean isChangePwdAllowed);
}
