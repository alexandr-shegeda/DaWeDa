package com.daweda.services.impl;

import com.daveda.repository.dao.UserDAO;
import com.daweda.model.entity.User;
import com.daweda.services.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import static org.mockito.Matchers.anyBoolean;
import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.*;

/**
* Created by elena on 02.03.15.
*/

@RunWith(MockitoJUnitRunner.class)
public class UserServiceImplTest {

    @Mock
    private UserDAO dao;

    @InjectMocks
    private UserService userService = new UserServiceImpl();


    @Test
    public void findUserByEmail() throws Exception{
        String email = new String();
        when(dao.findUserByEmail(email)).thenReturn(new User());
    }

    @Test
    public void  findUserByToken()throws Exception {
        when(dao.findUserByToken(anyString())).thenReturn(new User());
    }

    @Test
    public void testUpdateIsActivatedByToken() throws Exception{
        userService.updateIsActivatedByToken(anyString(), anyBoolean());
        verify(dao, times(1)).updateIsActivatedByToken(anyString(), anyBoolean());

    }

    @Test
    public void testUpdateIsUserPassword() throws Exception {
        userService.updateIsUserPassword(anyString(), anyBoolean());
        verify(dao, times(1)).updateIsUserPassword(anyString(), anyBoolean());
    }

    @Test
    public void testUpdatePassword() throws Exception{
        userService.updatePassword( anyString(), anyString());
        verify(dao, times(1)).updatePassword(anyString(), anyString());

    }

    @Test
    public void testUpdateIsChangePwdAllowed() throws Exception{
        userService.updateIsChangePwdAllowed(anyString(), anyBoolean());
        verify(dao, times(1)).updateIsChangePwdAllowed(anyString(), anyBoolean());


    }


}
