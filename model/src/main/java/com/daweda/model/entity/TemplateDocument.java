package com.daweda.model.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;


/**
 * The persistent class for the template_document database table.
 * 
 */
@Entity
@Table(name="template_document")
@NamedQuery(name="TemplateDocument.findAll", query="SELECT t FROM TemplateDocument t")
public class TemplateDocument implements Serializable, Comparable<TemplateDocument> {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="id_document", unique=true, nullable=false)
	private long idDocument;

	@Column(name="document_name", nullable=false, length=512)
	private String documentName;

	@Column(name="is_required")
	private boolean isRequired;

	//bi-directional many-to-one association to ConfirmationDocument
	@OneToMany(mappedBy="templateDocument")
	private List<ConfirmationDocument> confirmationDocuments;

	public TemplateDocument() {
	}

	public long getIdDocument() {
		return this.idDocument;
	}

	public void setIdDocument(long idDocument) {
		this.idDocument = idDocument;
	}

	public String getDocumentName() {
		return this.documentName;
	}

	public void setDocumentName(String documentName) {
		this.documentName = documentName;
	}

	public boolean getIsRequired() {
		return this.isRequired;
	}

	public void setIsRequired(boolean isRequired) {
		this.isRequired = isRequired;
	}

	public List<ConfirmationDocument> getConfirmationDocuments() {
		return this.confirmationDocuments;
	}

	public void setConfirmationDocuments(List<ConfirmationDocument> confirmationDocuments) {
		this.confirmationDocuments = confirmationDocuments;
	}

	public ConfirmationDocument addConfirmationDocument(ConfirmationDocument confirmationDocument) {
		getConfirmationDocuments().add(confirmationDocument);
		confirmationDocument.setTemplateDocument(this);

		return confirmationDocument;
	}

	public ConfirmationDocument removeConfirmationDocument(ConfirmationDocument confirmationDocument) {
		getConfirmationDocuments().remove(confirmationDocument);
		confirmationDocument.setTemplateDocument(null);

		return confirmationDocument;
	}

	@Override
	public String toString() {
		return "TemplateDocument [idDocument=" + idDocument + ", documentName="
				+ documentName + "]";
	}

	@Override
	public int compareTo(TemplateDocument that) {
		final int BEFORE = -1;
		final int AFTER = 1;

		if (that == null) {
			return BEFORE;
		}

		Long thisDocument = this.getIdDocument();
		Long thatDocument = that.getIdDocument();

		if (thisDocument == null) {
			return AFTER;
		} else if (thatDocument == null) {
			return BEFORE;
		} else {
			return thisDocument.compareTo(thatDocument);
		}
	}

}