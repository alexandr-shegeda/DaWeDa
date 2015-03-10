package com.daweda.services.impl;

import com.daveda.repository.dao.UserDetailsDAO;
import com.daweda.model.entity.UserDetails;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import static org.mockito.Mockito.when;

/**
 * Created by elena on 02.03.15.
 */

@RunWith(MockitoJUnitRunner.class)
public class UserDetailsServiceImplTest {

    @Mock
    private UserDetailsDAO dao;

    @Test
    public void testCreateStartUserDetails() {
        when(dao.createStartUserDetails()).thenReturn(new UserDetails());
    }

}
