package com.daveda.repository.dao;

import com.daweda.model.OrderStatus;

public interface OrderStatusDAO {
	
	public boolean insert(OrderStatus orderStatus);
	public OrderStatus findById(int id);
	public OrderStatus findByName(String name);	
	public void update(String name);
	public void delete(int id);

}
