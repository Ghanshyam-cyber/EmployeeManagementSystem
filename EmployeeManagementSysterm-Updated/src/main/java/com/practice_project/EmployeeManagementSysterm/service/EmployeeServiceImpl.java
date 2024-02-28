package com.practice_project.EmployeeManagementSysterm.service;

import com.practice_project.EmployeeManagementSysterm.dao.EmployeeDao;
import com.practice_project.EmployeeManagementSysterm.entity.Employee;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeServiceImpl implements EmployeeService{

    private EmployeeDao employeeDao;

    public EmployeeServiceImpl(EmployeeDao theEmployeeDao){
        employeeDao = theEmployeeDao;
    }

    @Override
    public List<Employee> findAll() {
        return employeeDao.findAll();
    }

    @Override
    public Employee save(Employee theEmployee) {
        return employeeDao.save(theEmployee);
    }

    @Override
    public void deleteEmployeeById(int theId) {
        employeeDao.deleteById(theId);
    }

    @Override
    public Optional<Employee> findById(int theId) {

        return employeeDao.findById(theId);
    }
}
