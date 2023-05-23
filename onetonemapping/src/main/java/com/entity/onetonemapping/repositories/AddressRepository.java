package com.entity.onetonemapping.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.entity.onetonemapping.entities.Address;

@Repository
public interface AddressRepository extends JpaRepository<Address,Long>{
    
}
