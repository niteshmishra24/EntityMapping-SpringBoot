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

import com.entity.onetonemapping.entities.Address;
import com.entity.onetonemapping.services.AddressService;

@RestController
@RequestMapping("/api/address")
public class AddressContoller {
    
    @Autowired
    private AddressService addressService;

    @GetMapping("/")
    public List<Address> getAllAddress(){
        return addressService.getAllAddress();
    }

    @GetMapping("/{id}")
    public Optional<Address> getAddressById(@PathVariable("id") long id){
        return addressService.getAddressById(id);
    }

    @PostMapping("/add-address")
    public void createAddress(@RequestBody Address address){
        addressService.createAddress(address);
    }

    @PutMapping("/update-address/{id}")
    public void updateAddress(@RequestBody Address address,@PathVariable("id") long id){
        addressService.updateAddress(address, id);
    }

    @DeleteMapping("/delete-address/{id}")
    public void deleteAddress(@PathVariable("id") long id){
        addressService.deleteAddress(id);
    }
}
