package com.practice_project.EmployeeManagementSysterm.service;

import com.practice_project.EmployeeManagementSysterm.entity.Employee;

import java.util.List;
import java.util.Optional;

public interface EmployeeService {

    List<Employee> findAll();
    Employee save(Employee theEmployee);

    void deleteEmployeeById(int theId);

    Optional<Employee> findById(int theId);
}
