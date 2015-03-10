package com.daweda.model.entity;

import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * Created by elena on 27.02.15.
 */
@Entity
public class Settlement {
    @Id
    private long id;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }
}
