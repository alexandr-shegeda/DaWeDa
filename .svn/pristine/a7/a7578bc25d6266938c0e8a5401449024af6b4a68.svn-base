package com.daweda.model.entity;


import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.OrderBy;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.SortedSet;
import java.util.TreeSet;


/**
 * The persistent class for the account database table.
 * 
 */
@Entity
@Table(name="account")
@NamedQuery(name="Account.findAll", query="SELECT a FROM Account a")
public class Account implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="id_account", unique=true, nullable=false)
	private long idAccount;

    //All money we can use for creating new orders (money that we can't use for orders - money in pool or tradebook)
	@Column(name="available_cash")
	private double availableCash;

	@Column(name="available_trades")
	private int availableTrades;

    //all money in units
	@Column(name="balance")
	private double balance;

	@Column(name="closed_positions")
	private int closedPositions;

	@Column(name="open_positions")
	private int openPositions;

	@Column(name="pending_positions")
	private int pendingPositions;

    //availableCash + money of pending orders + open orders (countable field, may be removed )
	@Column(name="total_cash")
	private double totalCash;
	
	//bi-directional many-to-one association to ConfirmationDocument
	@OneToMany(fetch=FetchType.EAGER, mappedBy="account", cascade = CascadeType.ALL)
	@OrderBy
	private SortedSet<ConfirmationDocument> confirmationDocuments;
//
//	//bi-directional many-to-one association to Payment
//	@OneToMany(mappedBy="account")
//	private List<Payment> payments;
//
//	//bi-directional many-to-one association to User
//	@OneToMany(mappedBy="account")
//	private List<User> users;
//
//	//bi-directional many-to-one association to Withdrawal
//	@OneToMany(mappedBy="account")
//	private List<Withdrawal> withdrawals;

	public Account() {
	}

	public long getIdAccount() {
		return this.idAccount;
	}

	public void setIdAccount(long idAccount) {
		this.idAccount = idAccount;
	}

	public double getAvailableCash() {
		return this.availableCash;
	}

	public void setAvailableCash(double availableCash) {
		this.availableCash = availableCash;
	}

	public int getAvailableTrades() {
		return this.availableTrades;
	}

	public void setAvailableTrades(int availableTrades) {
		this.availableTrades = availableTrades;
	}

	public double getBalance() {
		return this.balance;
	}

	public void setBalance(int balance) {
		this.balance = balance;
	}

	public int getClosedPositions() {
		return this.closedPositions;
	}

	public void setClosedPositions(int closedPositions) {
		this.closedPositions = closedPositions;
	}

	public int getOpenPositions() {
		return this.openPositions;
	}

	public void setOpenPositions(int openPositions) {
		this.openPositions = openPositions;
	}

	public int getPendingPositions() {
		return this.pendingPositions;
	}

	public void setPendingPositions(int pendingPositions) {
		this.pendingPositions = pendingPositions;
	}

	public double getTotalCash() {
		return this.totalCash;
	}

	public void setTotalCash(double totalCash) {
		this.totalCash = totalCash;
	}

	public SortedSet<ConfirmationDocument> getConfirmationDocuments() {
		if(this.confirmationDocuments == null){
			this.confirmationDocuments = new TreeSet<ConfirmationDocument>();
		}
		return this.confirmationDocuments;
	}

	public void setConfirmationDocuments(SortedSet<ConfirmationDocument> confirmationDocuments) {
		this.confirmationDocuments = confirmationDocuments;
	}

	public ConfirmationDocument addConfirmationDocument(ConfirmationDocument confirmationDocument) {
		getConfirmationDocuments().add(confirmationDocument);
		confirmationDocument.setAccount(this);

		return confirmationDocument;
	}

	public ConfirmationDocument removeConfirmationDocument(ConfirmationDocument confirmationDocument) {
		getConfirmationDocuments().remove(confirmationDocument);
		confirmationDocument.setAccount(null);

		return confirmationDocument;
	}
	
	@Override
	public String toString() {
		return "Account [idAccount=" + idAccount + ", balance=" + balance
				+ ", closedPositions=" + closedPositions + ", openPositions="
				+ openPositions + ", pendingPositions=" + pendingPositions
				+ "]";
	}
//
//	public List<Payment> getPayments() {
//		return this.payments;
//	}
//
//	public void setPayments(List<Payment> payments) {
//		this.payments = payments;
//	}
//
//	public Payment addPayment(Payment payment) {
//		getPayments().add(payment);
//		payment.setAccount(this);
//
//		return payment;
//	}
//
//	public Payment removePayment(Payment payment) {
//		getPayments().remove(payment);
//		payment.setAccount(null);
//
//		return payment;
//	}
//
//	public List<User> getUsers() {
//		return this.users;
//	}
//
//	public void setUsers(List<User> users) {
//		this.users = users;
//	}
//
//	public User addUser(User user) {
//		getUsers().add(user);
//		user.setAccount(this);
//
//		return user;
//	}
//
//	public User removeUser(User user) {
//		getUsers().remove(user);
//		user.setAccount(null);
//
//		return user;
//	}
//
//	public List<Withdrawal> getWithdrawals() {
//		return this.withdrawals;
//	}
//
//	public void setWithdrawals(List<Withdrawal> withdrawals) {
//		this.withdrawals = withdrawals;
//	}
//
//	public Withdrawal addWithdrawal(Withdrawal withdrawal) {
//		getWithdrawals().add(withdrawal);
//		withdrawal.setAccount(this);
//
//		return withdrawal;
//	}
//
//	public Withdrawal removeWithdrawal(Withdrawal withdrawal) {
//		getWithdrawals().remove(withdrawal);
//		withdrawal.setAccount(null);
//
//		return withdrawal;
//	}

}