package com.daweda.model.entity;

import java.io.Serializable;
import java.sql.Timestamp;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.Table;



/**
 * The persistent class for the confirmation_document database table.
 * Representing of documents which are scanned and kept in document storage
 */
@Entity
@Table(name="confirmation_document")
@NamedQuery(name="ConfirmationDocument.findAll", query="SELECT c FROM ConfirmationDocument c")
public class ConfirmationDocument implements Serializable, Comparable <ConfirmationDocument> {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="id_confirmation_document", unique=true, nullable=false)
	private long idConfirmationDocument;	
	
	@Column(name="name")
	private String name;
	
	@Column(name="cofirmed_time")
	private Timestamp cofirmedTime;

	@Basic(fetch=FetchType.LAZY)
	@Lob 
	@Column(columnDefinition="mediumblob")
	private byte[] document;

	@Column(name="is_confirmed")
	private boolean isConfirmed;

	@Column(name="uploaded_time")
	private Timestamp uploadedTime;

	//bi-directional many-to-one association to Account
	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="account_id", nullable=false)
	private Account account;

	//bi-directional many-to-one association to TemplateDocument
	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="template_document_id", nullable=false)
	private TemplateDocument templateDocument;

	public ConfirmationDocument() {
	}
	
	public ConfirmationDocument(TemplateDocument templateDocument) {
		this.templateDocument = templateDocument;
	}

	public long getIdConfirmationDocument() {
		return this.idConfirmationDocument;
	}

	public void setIdConfirmationDocument(long idConfirmationDocument) {
		this.idConfirmationDocument = idConfirmationDocument;
	}

	public Timestamp getCofirmedTime() {
		return this.cofirmedTime;
	}

	public void setCofirmedTime(Timestamp cofirmedTime) {
		this.cofirmedTime = cofirmedTime;
	}

	public boolean getIsConfirmed() {
		return this.isConfirmed;
	}

	public void setIsConfirmed(boolean isConfirmed) {
		this.isConfirmed = isConfirmed;
	}

	public Timestamp getUploadedTime() {
		return this.uploadedTime;
	}

	public void setUploadedTime(Timestamp uploadedTime) {
		this.uploadedTime = uploadedTime;
	}

	public Account getAccount() {
		return this.account;
	}

	public void setAccount(Account account) {
		this.account = account;
	}

	public TemplateDocument getTemplateDocument() {
		return this.templateDocument;
	}

	public void setTemplateDocument(TemplateDocument templateDocument) {
		this.templateDocument = templateDocument;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setConfirmed(boolean isConfirmed) {
		this.isConfirmed = isConfirmed;
	}

	public byte[] getDocument() {
		return document;
	}

	public void setDocument(byte[] document) {
		this.document = document;
	}

	@Override
	public String toString() {
		return "ConfirmationDocument [name=" + name + ", isConfirmed="
				+ isConfirmed + ", templateDocument=" + templateDocument + "]";
	}

	@Override
	public int compareTo(ConfirmationDocument that) {
		final int BEFORE = -1;
		final int AFTER = 1;

		if (that == null) {
			return BEFORE;
		}

		TemplateDocument thisDocument = this.getTemplateDocument();
		TemplateDocument thatDocument = that.getTemplateDocument();
		
		if (thisDocument == null) {
			return AFTER;
		} else if (thatDocument == null) {
			return BEFORE;
		} else {
			return thisDocument.compareTo(thatDocument);
		}
	}

}