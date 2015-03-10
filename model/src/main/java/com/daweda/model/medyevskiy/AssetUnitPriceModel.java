package com.daweda.model.medyevskiy;

public class AssetUnitPriceModel {

	private int unitsSell;
	private int unitsBuy;
	
	private double priceSell;
	private double priceBuy;
	
	private int priority;
	
	
	
	public AssetUnitPriceModel(int unitsSell, int unitsBuy, double priceSell,
			double priceBuy, int priority) {
		super();
		this.unitsSell = unitsSell;
		this.unitsBuy = unitsBuy;
		this.priceSell = priceSell;
		this.priceBuy = priceBuy;
		this.priority = priority;
	}
	
	public int getUnitsSell() {
		return unitsSell;
	}
	public void setUnitsSell(int unitsSell) {
		this.unitsSell = unitsSell;
	}
	public int getUnitsBuy() {
		return unitsBuy;
	}
	public void setUnitsBuy(int unitsBuy) {
		this.unitsBuy = unitsBuy;
	}
	public double getPriceSell() {
		return priceSell;
	}
	public void setPriceSell(double priceSell) {
		this.priceSell = priceSell;
	}
	public double getPriceBuy() {
		return priceBuy;
	}
	public void setPriceBuy(double priceBuy) {
		this.priceBuy = priceBuy;
	}

	public int getPriority() {
		return priority;
	}

	public void setPriority(int priority) {
		this.priority = priority;
	}
	
	
	
	
}
