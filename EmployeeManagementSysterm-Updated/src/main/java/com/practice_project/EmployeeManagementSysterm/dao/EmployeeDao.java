package com.practice_project.EmployeeManagementSysterm.dao;

import com.practice_project.EmployeeManagementSysterm.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeDao extends JpaRepository<Employee, Integer> {

}
