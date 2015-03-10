package com.daweda.model.medyevskiy;

public class AssetYahooQuoteModel {
	
	
	private String symbol;
	private String name;
	private String percentChange;
	private String lastPrice;
	private float daysHigh;
	private float daysLow;
	
	
	
	public AssetYahooQuoteModel(String symbol,String name, String percentChange,
			String lastPrice) {
		super();
		this.name = name;
		this.symbol = symbol;
		this.percentChange = percentChange;
		this.lastPrice = lastPrice;
		/*this.daysHigh = daysHigh;
		this.daysLow = daysLow;*/
	}
	
	
	public AssetYahooQuoteModel(String symbol, String name, String lastPrice) {
		super();
		this.symbol = symbol;
		this.name = name;
		this.lastPrice = lastPrice;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getSymbol() {
		return symbol;
	}
	public void setSymbol(String symbol) {
		this.symbol = symbol;
	}
	public String getPercentChange() {
		return percentChange;
	}
	public void setPercentChange(String percentChange) {
		this.percentChange = percentChange;
	}
	public String getLastPrice() {
		return lastPrice;
	}
	public void setLastPrice(String lastPrice) {
		this.lastPrice = lastPrice;
	}
	/*public float getDaysHigh() {
		return daysHigh;
	}
	public void setDaysHigh(float daysHigh) {
		this.daysHigh = daysHigh;
	}
	public float getDaysLow() {
		return daysLow;
	}
	public void setDaysLow(float daysLow) {
		this.daysLow = daysLow;
	}*/
	
	
}
