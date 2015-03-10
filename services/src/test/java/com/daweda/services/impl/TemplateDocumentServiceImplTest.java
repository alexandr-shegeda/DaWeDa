package com.daweda.services.impl;

import com.daveda.repository.dao.TemplateDocumentDAO;
import com.daweda.model.entity.TemplateDocument;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.LinkedList;

import static org.mockito.Mockito.when;

import static org.junit.Assert.*;
@RunWith(MockitoJUnitRunner.class)
public class TemplateDocumentServiceImplTest {

    @Mock
    private TemplateDocumentDAO dao;
    @InjectMocks
    private TemplateDocumentServiceImpl documentService;
    @Test
    public void testFindAll() throws Exception
    {
        when(dao.findAll()).thenReturn(new LinkedList<TemplateDocument>());
        assertNotNull(documentService.findAll());
    }
}