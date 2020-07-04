package com.carrent.model;

import javax.persistence.*;

/**
 * @author Lakitha Prabudh on 7/4/20
 */
@Entity
@Table(name = "customer")
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String name;
    private String dLicence;

    public Customer() {
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

    public String getdLicence() {
        return dLicence;
    }

    public void setdLicence(String dLicence) {
        this.dLicence = dLicence;
    }
}
