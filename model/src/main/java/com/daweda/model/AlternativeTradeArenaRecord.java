package com.daweda.model;

public class AlternativeTradeArenaRecord {
	private int unitsSell;
	private int unitsBuy;
	private double priceSell;
	private double priceBuy;
	
	public AlternativeTradeArenaRecord() {
		super();
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

	@Override
	public String toString() {
		return "AlternativeTradeArenaRecord [unitsSell=" + unitsSell
				+ ", unitsBuy=" + unitsBuy + ", priceSell=" + priceSell
				+ ", priceBuy=" + priceBuy + "]";
	}
	
	
}
