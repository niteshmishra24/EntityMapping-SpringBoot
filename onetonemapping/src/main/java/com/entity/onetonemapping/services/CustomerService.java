package com.entity.onetonemapping.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.entity.onetonemapping.entities.Address;
import com.entity.onetonemapping.entities.Customer;
import com.entity.onetonemapping.repositories.AddressRepository;
import com.entity.onetonemapping.repositories.CustomerRepository;

@Service
public class CustomerService {
    @Autowired
    private CustomerRepository customerRepository;
    private AddressRepository addressRepository;

    public List<Customer> getAllCustomer(){
        return customerRepository.findAll();
    }

    public Optional<Customer> getCustomerById(long id){
        return customerRepository.findById(id);
    }

    public void createCustomer(Customer customer){
        // Address address = customer.getAddress();
        // addressRepository.save(address);
        customerRepository.save(customer);
    }

    public void deleteCustomer(long id){
        customerRepository.deleteById(id);
    }

    public void updateCustomer(Customer customer,long id){
        Optional<Customer> existingCustomerOptional = customerRepository.findById(id);
        if(existingCustomerOptional.isPresent()){
            Customer existingCustomer = existingCustomerOptional.get();
            existingCustomer.setFirstname(customer.getFirstname());
            existingCustomer.setLastname(customer.getLastname());
            existingCustomer.setContact(customer.getContact());
            existingCustomer.setAddress(customer.getAddress());
            customerRepository.save(existingCustomer);
        }
    }

    public String getCityById(long id){
        Optional<Customer> customerOptional = customerRepository.findById(id);
        String city = null;
        if(customerOptional.isPresent()){
            Customer customer = customerOptional.get();
            Address address = customer.getAddress();

            if(address != null){
                city =  address.getCity();
            }
        } else{
            return "No customer found with this id";
        }

        return city;
    }
}
