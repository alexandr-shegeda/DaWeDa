package com.daveda.repository.dao.impl;

import com.daveda.repository.dao.ConfirmationDocumentDAO;
import com.daweda.model.entity.Account;
import com.daweda.model.entity.ConfirmationDocument;
import org.apache.felix.scr.annotations.Component;
import org.apache.felix.scr.annotations.Service;


import javax.persistence.TypedQuery;
import java.util.List;

@Service
@Component(immediate = true)
public class ConfirmationDocumentDAOImpl extends AbstractDAOImpl<ConfirmationDocument>  implements ConfirmationDocumentDAO {
	
	private static final String FIND_BY_ACCOUNT = "SELECT c FROM ConfirmationDocument c "
			+ "WHERE c.account = :account";
	
	public ConfirmationDocumentDAOImpl() {
		super(ConfirmationDocument.class);
	}

	@Override
	public List<ConfirmationDocument> findByAccount(Account account) {
		List<ConfirmationDocument> list = null;
		TypedQuery<ConfirmationDocument> tq = entityManager.createQuery(FIND_BY_ACCOUNT,
				ConfirmationDocument.class);
		tq.setParameter("account", account);
		return tq.getResultList();
	}
}
