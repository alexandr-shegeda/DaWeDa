package com.daweda.services.impl;

import com.daveda.repository.dao.TemplateDocumentDAO;
import com.daweda.model.entity.TemplateDocument;
import com.daweda.services.TemplateDocumentService;
import org.apache.felix.scr.annotations.Reference;
import org.apache.felix.scr.annotations.Service;

import java.util.List;

/**
 * Created by elena on 20.02.15.
 */

@Service
public class TemplateDocumentServiceImpl implements TemplateDocumentService {

    @Reference
    private TemplateDocumentDAO dao;

    public TemplateDocumentServiceImpl() {
        // TODO Auto-generated constructor stub
    }

//    @Override
//    protected Dao<TemplateDocument> getDao() {
//        return dao;
//    }

    @Override
    public List<TemplateDocument> findAll() {
        return dao.findAll();
    }
}
