package com.entity.onetomanymapping.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.entity.onetomanymapping.entities.Department;
import com.entity.onetomanymapping.repositories.DepartmentRepository;

@Service
public class DepartmentService {
    private final DepartmentRepository departmentRepository;

    public DepartmentService(DepartmentRepository departmentRepository) {
        this.departmentRepository = departmentRepository;
    }

    public List<Department> getAllDepartments() {
        return departmentRepository.findAll();
    }

    public Department getDepartmentById(Long id) {
        return departmentRepository.findById(id).orElse(null);
    }

    public Department createDepartment(Department department) {
        return departmentRepository.save(department);
    }

    public Department updateDepartment(Long id, Department updatedDepartment) {
        Department existingDepartment = departmentRepository.findById(id).orElse(null);
        if (existingDepartment != null) {
            existingDepartment.setName(updatedDepartment.getName());
            existingDepartment.setWorkingHours(updatedDepartment.getWorkingHours());
            existingDepartment.setEmployees(updatedDepartment.getEmployees());
            return departmentRepository.save(existingDepartment);
        }
        return null;
    }

    public void deleteDepartment(Long id) {
        departmentRepository.deleteById(id);
    }
}
