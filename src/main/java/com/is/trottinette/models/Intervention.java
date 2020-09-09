package com.is.trottinette.models;

import javax.persistence.*;

import java.io.Serializable;
import java.util.Date;

@Entity
public class Intervention implements Serializable {
    @Id
    @GeneratedValue
    private Long id;

    @Temporal(TemporalType.DATE)
    private Date date;

    private String description;

    public Intervention() {
    }

    public Intervention(Long id, Date date, String description) {
        this.id = id;
        this.date = date;
        this.description = description;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
