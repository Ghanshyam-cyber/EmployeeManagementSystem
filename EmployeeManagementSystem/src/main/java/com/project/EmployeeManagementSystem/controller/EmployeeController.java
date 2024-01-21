package com.project.EmployeeManagementSystem.controller;

import com.project.EmployeeManagementSystem.entity.Employee;
import com.project.EmployeeManagementSystem.service.EmployeeService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/employees")
public class EmployeeController {

    private EmployeeService employeeService;

    public EmployeeController(EmployeeService theEmployeeService){
        employeeService = theEmployeeService;
    }

    @GetMapping("/list")
    public String showEmployeeList(Model theModel){
        List<Employee> theEmployee = employeeService.findAll();

        theModel.addAttribute("employees" ,theEmployee);

        return "employee_list";
    }

    @GetMapping("/addEmployee")
    public String showFormForAdd(Model theModel){

        Employee theEmployee = new Employee();

        theModel.addAttribute("employee", theEmployee);

        return "Employee-form";
    }

    @GetMapping("/updateEmployee")
    public String showFormForUpdate(@RequestParam("employeeId") int theId,Model theModel){

        Optional<Employee> theEmployee = employeeService.findById(theId);

        theModel.addAttribute("employee", theEmployee);

        return "Employee-form";
    }

    @GetMapping("/delete")
    public String deleteEmployee(@RequestParam("employeeId") int theId){
        employeeService.deleteById(theId);

        return "redirect:/employees/list";
    }

    @PostMapping("/save")
    public String saveEmployee(@ModelAttribute("employee") Employee theEmployee){

        employeeService.save(theEmployee);

        return "redirect:/employees/list";

    }
}
