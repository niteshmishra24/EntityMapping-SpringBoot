package com.entity.onetonemapping.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.entity.onetonemapping.entities.Customer;
import com.entity.onetonemapping.services.CustomerService;

@RestController
@RequestMapping("/api/customers")
public class CustomerContoller {
    
    @Autowired
    private CustomerService customerService;

    @GetMapping("/all")
    public List<Customer> getAllCustomer(){
        return customerService.getAllCustomer();
    }

    @GetMapping("/all/{id}")
    public Optional<Customer> getCustomerById(@PathVariable("id") long id){
        return customerService.getCustomerById(id);        
    }

    @PostMapping("/add-customer")
    public void createCustomer(@RequestBody Customer customer){
        customerService.createCustomer(customer);
    }

    @PutMapping("/update-customer/{id}")
    public void updateCustomer(@RequestBody Customer customer,@PathVariable("id") long id){
        customerService.updateCustomer(customer, id);
    }

    @DeleteMapping("/delete-customer/{id}")
    public void deleteCustomer(@PathVariable("id") long id){
        customerService.deleteCustomer(id);
    }

    @GetMapping("/{id}/address-city")
    public String getCityById(@PathVariable("id") long id){
        return customerService.getCityById(id);
    }
}
