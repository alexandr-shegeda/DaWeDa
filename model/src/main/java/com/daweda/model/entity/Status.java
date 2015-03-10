package com.daweda.model.entity;

import java.io.Serializable;

import javax.persistence.*;

import java.util.List;


/**
 * The persistent class for the status database table.
 * 
 */
@Entity
@Table(name="status")
@NamedQuery(name="Status.findAll", query="SELECT s FROM Status s")
public class Status implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="id_status", unique=true, nullable=false)
	private long idStatus;

    //pending, open, closed - move to enum
	@Column(nullable=false, length=64)
	private String name;

	//bi-directional many-to-one association to Order
	@OneToMany(mappedBy="status")
	private List<TradeOrder> tradeOrders;

	public Status() {
	}
	
	public Status(String name) {
		this.name = name;
	}

	public long getIdStatus() {
		return this.idStatus;
	}

	public void setIdStatus(long idStatus) {
		this.idStatus = idStatus;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<TradeOrder> getOrders() {
		return this.tradeOrders;
	}

	public void setOrders(List<TradeOrder> tradeOrders) {
		this.tradeOrders = tradeOrders;
	}

	public TradeOrder addOrder(TradeOrder tradeOrder) {
		getOrders().add(tradeOrder);
		tradeOrder.setStatus(this);

		return tradeOrder;
	}

	public TradeOrder removeOrder(TradeOrder tradeOrder) {
		getOrders().remove(tradeOrder);
		tradeOrder.setStatus(null);

		return tradeOrder;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (idStatus ^ (idStatus >>> 32));
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (!(obj instanceof Status)) {
			return false;
		}
		Status other = (Status) obj;
		if (idStatus != other.idStatus) {
			return false;
		}
		if (name == null) {
			if (other.name != null) {
				return false;
			}
		} else if (!name.equals(other.name)) {
			return false;
		}
		return true;
	}

}