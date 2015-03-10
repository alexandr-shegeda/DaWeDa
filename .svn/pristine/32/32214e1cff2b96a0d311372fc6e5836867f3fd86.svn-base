package com.daveda.repository.dao.impl;

import com.daveda.repository.dao.TemplateDocumentDAO;
import com.daweda.model.entity.TemplateDocument;
import org.apache.felix.scr.annotations.Component;
import org.apache.felix.scr.annotations.Service;

import javax.persistence.TypedQuery;
import java.util.List;

/**
 * Created by elena on 20.02.15.
 */

@Service
@Component(immediate = true)
public class TemplateDocumentDAOImpl extends AbstractDAOImpl<TemplateDocument> implements TemplateDocumentDAO {

    public TemplateDocumentDAOImpl() {
        super(TemplateDocument.class);
    }

    @Override
    public List<TemplateDocument> findAll() {
        TypedQuery<TemplateDocument> typedQuery = entityManager.createNamedQuery("TemplateDocument.findAll", TemplateDocument.class);
        return typedQuery.getResultList();
    }
}
