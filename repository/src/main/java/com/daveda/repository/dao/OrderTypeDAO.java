package com.daveda.repository.dao;

import com.daweda.model.Order;
import com.daweda.model.entity.OrderType;

import java.util.List;

/**
 * Created by elena on 20.02.15.
 */
public interface OrderTypeDAO extends AbstractDAO<OrderType> {

    public boolean insert(OrderType orderType);
    public OrderType findById(int id);
    public List<Order> findByName(String name);


}
