package com.entity.onetomanymapping.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.entity.onetomanymapping.entities.Employee;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {
}
