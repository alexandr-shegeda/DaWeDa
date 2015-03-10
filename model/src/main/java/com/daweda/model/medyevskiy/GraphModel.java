package com.daweda.model.medyevskiy;

public class GraphModel {

	private long time;
	private double price;
	
	public GraphModel() {
		super();
	}
	
	public GraphModel(long time, double price) {
		super();
		this.time = time;
		this.price = price;
	}
 
	public long getTime() {
		return time;
	}

	public void setTime(long time) {
		this.time = time;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	@Override
	public String toString() {
		return "GraphModel [time=" + time + ", price=" + price + "]";
	}
	
	
	
}
