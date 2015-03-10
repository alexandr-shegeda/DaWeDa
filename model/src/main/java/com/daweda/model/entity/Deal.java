package com.daweda.model.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;


/**
 * The persistent class for the deal database table.
 * 
 */
@Entity
@Table(name="deal")
@NamedQuery(name="Deal.findAll", query="SELECT d FROM Deal d")
public class Deal implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="id_deal", unique=true, nullable=false)
	private long idDeal;

	@Column(name="deal_time", nullable=false)
	private Timestamp dealTime;

	@Column(name="units", nullable=false)
	private int units;
	
	@Column(name="price")
	private double price;
	
	@Column(name="is_expired")
	private boolean expired;

	//bi-directional many-to-one association to Order
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="cover_order_id", nullable=false)
	private TradeOrder coverOrder;

	//bi-directional many-to-one association to Order
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="covered_order_id", nullable=false)
	private TradeOrder coveredOrder;

	public Deal() {
	}
	
	/**
	 * @param dealTime
	 * @param units
	 * @param coverOrder
	 * @param order2
	 */
	public Deal(Timestamp dealTime, int units, TradeOrder coverOrder,
			TradeOrder coveredOrder) {
		super();
		this.dealTime = dealTime;
		this.units = units;
		this.coverOrder = coverOrder;
		this.coveredOrder = coveredOrder;
	}



	public long getIdDeal() {
		return this.idDeal;
	}

	public void setIdDeal(long idDeal) {
		this.idDeal = idDeal;
	}

	public Timestamp getDealTime() {
		return this.dealTime;
	}

	public void setDealTime(Timestamp dealTime) {
		this.dealTime = dealTime;
	}

	public int getUnits() {
		return this.units;
	}

	public void setUnits(int units) {
		this.units = units;
	}

	public TradeOrder getCoverOrder() {
		return this.coverOrder;
	}

	public void setCoverOrder(TradeOrder coverOrder) {
		this.coverOrder = coverOrder;
	}

	public TradeOrder getCoveredOrder() {
		return this.coveredOrder;
	}

	public void setCoveredOrder(TradeOrder coveredOrder) {
		this.coveredOrder = coveredOrder;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public boolean isExpired() {
		return expired;
	}

	public void setExpired(boolean expired) {
		this.expired = expired;
	}

	@Override
	public String toString() {
		return "Deal [idDeal=" + idDeal + ", units=" + units + ", price="
				+ price + ", coverOrder=" + coverOrder + ", coveredOrder="
				+ coveredOrder + "]";
	}

}