package com.daveda.repository.dao.impl;

import com.daveda.repository.dao.OrderTypeDAO;
import com.daweda.model.Order;
import com.daweda.model.entity.OrderType;
import org.apache.felix.scr.annotations.Component;
import org.apache.felix.scr.annotations.Service;

import javax.sql.DataSource;
import java.util.List;

/**
 * Created by elena on 20.02.15.
 */
@Service
@Component(immediate = true)
public class OrderTypeDAOImpl extends AbstractDAOImpl<OrderType> implements OrderTypeDAO{

    private DataSource dataSource;

    public void setDataSource(DataSource dataSource) {
        this.dataSource = dataSource;

    }

    @Override
    public boolean insert(OrderType orderType) {
        try{
            String SQL = "insert into order_type (name) values (?)";
            entityManager.createNativeQuery(SQL);
//            jdbcTemplateObject.update(SQL, orderType.getName());
//            System.out.println("Created OrderType Name = " + orderType.getName());
        } catch(Exception e){
            System.out.println("Exception while inserting new order type: ");
            e.printStackTrace();
            return false;
        }
        return true;
    }

    @Override
    public OrderType findById(int id) {
        return null;
    }

    @Override
    public List<Order> findByName(String name) {
        return null;
    }
}
