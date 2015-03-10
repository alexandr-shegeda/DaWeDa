package com.daweda.model.entity;

import java.io.Serializable;

/**
 * Created by elena on 20.02.15.
 */
public class OrderType implements Serializable {
    private int id;

    private String name;

    // With ID
    public OrderType(int id, String name) {
        super();
        this.id = id;
        this.name = name;
    }

    // Without ID
    public OrderType(String name) {
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
