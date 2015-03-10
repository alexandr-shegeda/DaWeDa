package com.daweda.model;

public class OrderStatus {

	private int id;
	private String name;

	// With ID
	public OrderStatus(int id, String name) {
		super();
		this.id = id;
		this.name = name;
	}

	// Without ID
	public OrderStatus(String name) {
		super();
		this.name = name;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}
