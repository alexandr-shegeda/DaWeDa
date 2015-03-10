package com.daweda.services.impl;

import com.daveda.repository.dao.StatusDAO;
import com.daweda.model.entity.Status;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
import static org.mockito.Mockito.when;
import static org.junit.Assert.*;

@RunWith(MockitoJUnitRunner.class)
public class StatusServiceImplTest {

    @Mock
    private StatusDAO dao;
    @InjectMocks
    private StatusServiceImpl statusService = new StatusServiceImpl();

    @Test
    public void testFindByName() throws Exception {
        String name = "name";
        when(dao.findByName(name)).thenReturn(new Status(name));
        assertNotNull(statusService.findByName(name));
    }
}