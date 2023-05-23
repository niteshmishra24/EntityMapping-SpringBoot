package com.entity.onetonemapping.entities;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;

@Entity
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String firstname;
    private String lastname;
    private long contact;

    @OneToOne(cascade = CascadeType.ALL)
    @JsonManagedReference
    @JoinColumn(name = "address_id")
    private Address address;



    public long getId() {
        return id;
    }
    public void setId(long id) {
        this.id = id;
    }
    public String getFirstname() {
        return firstname;
    }
    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }
    public String getLastname() {
        return lastname;
    }
    public void setLastname(String lastname) {
        this.lastname = lastname;
    }
    public long getContact() {
        return contact;
    }
    public void setContact(long contact) {
        this.contact = contact;
    }
    public Address getAddress() {
        return address;
    }
    public void setAddress(Address address) {
        this.address = address;
    }
    public Customer() {
    }
    public Customer(long id, String firstname, String lastname, long contact, Address address) {
        this.id = id;
        this.firstname = firstname;
        this.lastname = lastname;
        this.contact = contact;
        this.address = address;
    }
    @Override
    public String toString() {
        return "Customer [id=" + id + ", firstname=" + firstname + ", lastname=" + lastname + ", contact=" + contact
                + ", address=" + address + "]";
    }
    
}
