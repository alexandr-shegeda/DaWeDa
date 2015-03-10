package com.daweda.model;

public class WinsLoses {
	private int winsAmount;
	private int losesAmount;
	
	public WinsLoses() {
		super();
	}
	public WinsLoses(int winsAmount, int losesAmount) {
		super();
		this.winsAmount = winsAmount;
		this.losesAmount = losesAmount;
	}
	public int getWinsAmount() {
		return winsAmount;
	}
	public void setWinsAmount(int winsAmount) {
		this.winsAmount = winsAmount;
	}
	public int getLosesAmount() {
		return losesAmount;
	}
	public void setLosesAmount(int losesAmount) {
		this.losesAmount = losesAmount;
	}
	
	
}
