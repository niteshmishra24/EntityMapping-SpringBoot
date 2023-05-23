package com.entity.onetomanymapping.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.entity.onetomanymapping.entities.Department;

@Repository
public interface DepartmentRepository extends JpaRepository<Department, Long> {
}
