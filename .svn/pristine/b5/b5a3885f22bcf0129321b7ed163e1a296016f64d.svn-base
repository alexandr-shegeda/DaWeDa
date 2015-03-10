package com.daveda.repository.dao.impl;

import com.daveda.repository.dao.UserDAO;
import com.daweda.model.entity.User;
import org.apache.felix.scr.annotations.Component;
import org.apache.felix.scr.annotations.Service;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

/**
 * Created by elena on 20.02.15.
 */
@Service
@Component(immediate = true)
public class UserDAOImpl extends AbstractDAOImpl<User> implements UserDAO {

    private static final String FIND_BY_EMAIL = "SELECT u FROM User u WHERE u.email = :email";
    private static final String FIND_BY_TOKEN = "SELECT u FROM User u WHERE u.token = :token";

    public UserDAOImpl() {
        super(User.class);
    }

    @Override
    public User findUserByEmail(String email) {
        TypedQuery<User> typedQuery = entityManager.createQuery(FIND_BY_EMAIL,
                User.class);
        typedQuery.setParameter("email", email);
        try{
            return typedQuery.getSingleResult();
        } catch (NoResultException e){
            return null;
        }
    }

    @Override
    public User findUserByToken(String token) {
        TypedQuery<User> typedQuery = entityManager.createQuery(FIND_BY_TOKEN,
                User.class);
        typedQuery.setParameter("token", token);
        try{
            return typedQuery.getSingleResult();
        } catch(NoResultException e){
            return null;
        }
    }

    @Override
    public void updateIsActivatedByToken(String token, boolean activated) {
        User user = findUserByToken(token);
        user.setIsActivated(activated);
        update(user);
    }

    @Override
    public void updateIsUserPassword(String token, boolean isUserPassword) {
        User user = findUserByToken(token);
        user.setIsUserPassword(isUserPassword);
        update(user);
    }

    @Override
    public void updatePassword(String token, String newpassword) {
        User user = findUserByToken(token);
        user.setPassword(newpassword);
        user.setIsUserPassword(true);
        user.setIsChangePwdAllowed(true);
        update(user);
    }

    @Override
    public void updateIsChangePwdAllowed(String token,
                                         boolean isChangePwdAllowed) {
        User user = findUserByToken(token);
        user.setIsChangePwdAllowed(isChangePwdAllowed);
        update(user);
    }

}
