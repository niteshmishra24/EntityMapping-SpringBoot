package com.entity.onetonemapping.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.entity.onetonemapping.entities.Address;
import com.entity.onetonemapping.repositories.AddressRepository;
import com.entity.onetonemapping.repositories.CustomerRepository;

@Service
public class AddressService {
    @Autowired
    private AddressRepository addressRepository;
    private CustomerRepository customerRepository;

    public List<Address> getAllAddress(){
        return addressRepository.findAll();
    }

    public Optional<Address> getAddressById(long id){
        return addressRepository.findById(id);
    }

    public void createAddress(Address address){
        addressRepository.save(address);
    }

    public void updateAddress(Address address,long id){
        Optional<Address> existingAddressOptional = addressRepository.findById(id);
        if(existingAddressOptional.isPresent()){
            Address existingAddress = existingAddressOptional.get();
            existingAddress.setSteet(address.getSteet());
            existingAddress.setCity(address.getCity());
            existingAddress.setZipCode(address.getZipCode());
            addressRepository.save(existingAddress);
        }
    }

    public void deleteAddress(long id){
        addressRepository.deleteById(id);
    }
}
