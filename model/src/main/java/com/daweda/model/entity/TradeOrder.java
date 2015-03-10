package com.daweda.model.entity;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.Table;


/**
 * The persistent class for the order database table.
 * 
 */
@Entity
@Table(name="trade_order")
@NamedQuery(name="TradeOrder.findAll", query="SELECT o FROM TradeOrder o")
public class TradeOrder implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="id_order", unique=true, nullable=false)
	private long idOrder;

	@Column(name="asset_name", nullable=false, length=10)
	private String assetName;

	@Column(name="expiry_time", nullable=false)
	private Timestamp expiryTime;

	@Column(name="opened_units")
	private int openedUnits;

    //buy or sell  - move to enum
	@Column(name="position", nullable=false, length=10)
	private String position;

	@Column(name="pending_units")
	private int pendingUnits;

	@Column(name="price", nullable=false)
	private double price;

	@Column(name="start_time", nullable=false)
	private Timestamp startTime;
	
	@Column(name="is_profit")
	private boolean profit;
	
	@Column(name="market_price")
	private double marketPrice;

	//bi-directional many-to-one association to Deal
//	@OneToMany(mappedBy="order1")
//	private List<Deal> deals1;
//
//	//bi-directional many-to-one association to Deal
//	@OneToMany(mappedBy="order2")
//	private List<Deal> deals2;

	//bi-directional many-to-one association to Status
	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="status_id", nullable=false)
	private Status status;

	//bi-directional many-to-one association to User
	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="user_id", nullable=false)
	private User user;
	
	public TradeOrder() {		
	}
	
	
	/*private enum OrderStatus {
	    PENDING,
	    OPENED,
	    CLOSED,
	}

	public Order() {
	}
	
	public OrderStatus getPendingStatus(){
		return OrderStatus.PENDING;
	}
	public OrderStatus getClosedStatus(){
		return OrderStatus.CLOSED;
	}
	public OrderStatus getOpenedStatus(){
		return OrderStatus.OPENED;
	}*/

	public TradeOrder(double price, Date startTime, String position) {
		super();
		this.position = position;
		this.price = price;
		this.startTime = new Timestamp(startTime.getTime());
	}
	
	public TradeOrder(long idOrder, String assetName, String position, 
			int openedUnits, double price, Date expiryTime, Date startTime, 
			boolean profit, double marketPrice) {
		super();
		this.idOrder = idOrder;
		this.assetName = assetName;
		this.position = position;
		this.openedUnits = openedUnits;
		this.price = price;
		this.expiryTime = new Timestamp(expiryTime.getTime());
		this.startTime = new Timestamp(startTime.getTime());
		this.profit = profit;
		this.marketPrice = marketPrice;
	}


	public long getIdOrder() {
		return this.idOrder;
	}

	public void setIdOrder(long idOrder) {
		this.idOrder = idOrder;
	}

	public String getAssetName() {
		return this.assetName;
	}

	public void setAssetName(String assetName) {
		this.assetName = assetName;
	}

	public Timestamp getExpiryTime() {
		return this.expiryTime;
	}

	public void setExpiryTime(Timestamp expiryTime) {
		this.expiryTime = expiryTime;
	}

	public int getOpenedUnits() {
		return this.openedUnits;
	}

	public void setOpenedUnits(int openedUnits) {
		this.openedUnits = openedUnits;
	}

	public String getPosition() {
		return this.position;
	}

	public void setPosition(String position) {
		this.position = position;
	}

	public int getPendingUnits() {
		return this.pendingUnits;
	}

	public void setPendingUnits(int pendingUnits) {
		this.pendingUnits = pendingUnits;
	}

	public double getPrice() {
		return this.price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public Timestamp getStartTime() {
		return this.startTime;
	}

	public void setStartTime(Timestamp startTime) {
		this.startTime = startTime;
	}

//	public List<Deal> getDeals1() {
//		return this.deals1;
//	}
//
//	public void setDeals1(List<Deal> deals1) {
//		this.deals1 = deals1;
//	}
//
//	public List<Deal> getDeals2() {
//		return this.deals2;
//	}
//
//	public void setDeals2(List<Deal> deals2) {
//		this.deals2 = deals2;
//	}

	public Status getStatus() {
		return this.status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}

	public User getUser() {
		return this.user;
	}

	public void setUser(User user) {
		this.user = user;
	}


	public boolean isProfit() {
		return profit;
	}


	public void setProfit(boolean profit) {
		this.profit = profit;
	}


	public double getMarketPrice() {
		return marketPrice;
	}


	public void setMarketPrice(double marketPrice) {
		this.marketPrice = marketPrice;
	}


	@Override
	public String toString() {
		return "TradeOrder [idOrder=" + idOrder + ", assetName=" + assetName
				+ ", openedUnits=" + openedUnits + ", position=" + position
				+ ", pendingUnits=" + pendingUnits + ", price=" + price
				+ ", status=" + status + "]";
	}

}