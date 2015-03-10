package com.daweda.model;

import java.util.Date;

public class Order {
	
	private int id;
	private Date startTime;
	private Date expiryTime;
	private double price;
	private int units;
	private int pendingUnits;
	private String assetName;
	private int statusId;
	private String position;
	private int userId;

	public Order() {
		// TODO Auto-generated constructor stub
	}
	
	public Order(int id, Date startTime, Date expiryTime, double price,
			int units, int pendingUnits, String assetName, int statusId,
			String position, int userId) {
		super();
		this.id = id;
		this.startTime = startTime;
		this.expiryTime = expiryTime;
		this.price = price;
		this.units = units;
		this.pendingUnits = pendingUnits;
		this.assetName = assetName;
		this.statusId = statusId;
		this.position = position;
		this.userId = userId;
	}
	
	public Order(Date startTime, Date expiryTime, double price,
			int units, int pendingUnits, String assetName, int statusId,
			String position, int userId) {
		super();
		this.startTime = startTime;
		this.expiryTime = expiryTime;
		this.price = price;
		this.units = units;
		this.pendingUnits = pendingUnits;
		this.assetName = assetName;
		this.statusId = statusId;
		this.position = position;
		this.userId = userId;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Date getStartTime() {
		return startTime;
	}

	public void setStartTime(Date startTime) {
		this.startTime = startTime;
	}

	public Date getExpiryTime() {
		return expiryTime;
	}

	public void setExpiryTime(Date expiryTime) {
		this.expiryTime = expiryTime;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public int getUnits() {
		return units;
	}

	public void setUnits(int units) {
		this.units = units;
	}

	public int getPendingUnits() {
		return pendingUnits;
	}

	public void setPendingUnits(int pendingUnits) {
		this.pendingUnits = pendingUnits;
	}

	public String getAssetName() {
		return assetName;
	}

	public void setAssetName(String assetName) {
		this.assetName = assetName;
	}

	public int getStatusId() {
		return statusId;
	}

	public void setStatusId(int statusId) {
		this.statusId = statusId;
	}

	public String getPosition() {
		return position;
	}

	public void setPosition(String position) {
		this.position = position;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

}
