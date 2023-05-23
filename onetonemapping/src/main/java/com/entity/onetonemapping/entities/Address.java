package com.entity.onetonemapping.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;

@Entity
public class Address {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String steet;
    private String city;
    private String zipCode;

    @OneToOne(mappedBy = "address")
    @JsonBackReference
    private Customer customer;
    
    
    public Address(long id, String steet, String city, String zipCode, Customer customer) {
        this.id = id;
        this.steet = steet;
        this.city = city;
        this.zipCode = zipCode;
        this.customer = customer;
    }
    public long getId() {
        return id;
    }
    public void setId(long id) {
        this.id = id;
    }
    public String getSteet() {
        return steet;
    }
    public void setSteet(String steet) {
        this.steet = steet;
    }
    public String getCity() {
        return city;
    }
    public void setCity(String city) {
        this.city = city;
    }
    public String getZipCode() {
        return zipCode;
    }
    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }
    
    public Address() {
    }
    public Customer getCustomer() {
        return customer;
    }
    public void setCustomer(Customer customer) {
        this.customer = customer;
    }
}
