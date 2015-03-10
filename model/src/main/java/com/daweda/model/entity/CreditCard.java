package com.daweda.model.entity;


import javax.persistence.*;
import java.io.Serializable;
import java.sql.Timestamp;


/**
 * The persistent class for the payment_details database table.
 * 
 */
@Entity
@Table(name="credit_card")
public class CreditCard implements Serializable, Comparable<CreditCard>{
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="id_card", unique=true, nullable=false)
	private long idCard;

	@Column(name="card_holder_name", length=128, nullable=false)
	private String cardHolderName;

	@Column(name="number", length=16, nullable=false)
	private String number;

	@Column(name="cvv", length=10, nullable=false)
	private String cvv;

	@Column(name="expiry_date", nullable=false)
	private Timestamp expiryDate;

	//bi-directional many-to-one association to Account
	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="account_id", nullable=false)
	private Account account;

	public CreditCard() {
	}

	public String getCardHolderName() {
		return this.cardHolderName;
	}

	public void setCardHolderName(String cardHolderName) {
		this.cardHolderName = cardHolderName;
	}

	public Timestamp getExpiryDate() {
		return this.expiryDate;
	}

	public void setExpiryDate(Timestamp expiryDate) {
		this.expiryDate = expiryDate;
	}

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	public String getCvv() {
		return cvv;
	}

	public void setCvv(String cvv) {
		this.cvv = cvv;
	}

	public Account getAccount() {
		return account;
	}

	public void setAccount(Account account) {
		this.account = account;
	}

	public long getIdCard() {
		return idCard;
	}

	public void setIdCard(long idCard) {
		this.idCard = idCard;
	}

	@Override
	public String toString() {
		return "CreditCard [number=" + number + "]";
	}

	@Override
	public int compareTo(CreditCard that) {
		final int BEFORE = -1;
		final int AFTER = 1;

		if (that == null) {
			return BEFORE;
		}

		Comparable thisCard = this.getNumber();
		Comparable thatCard = that.getNumber();

		if (thisCard == null) {
			return AFTER;
		} else if (thatCard== null) {
			return BEFORE;
		} else {
			return thisCard.compareTo(thatCard);
		}
	}

}