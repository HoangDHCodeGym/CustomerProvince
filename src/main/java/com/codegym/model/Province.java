package com.codegym.model;

import javax.persistence.*;

@Entity
@Table(name = "provinces")
public class Province {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;

    @OneToMany (targetEntity = Customer.class)
    private Iterable<Customer> customers;

    public Province() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Iterable<Customer> getCustomers() {
        return customers;
    }

    public void setCustomers(Iterable<Customer> customers) {
        this.customers = customers;
    }
}
