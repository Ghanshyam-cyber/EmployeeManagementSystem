package com.practice_project.EmployeeManagementSysterm.controller;

import com.practice_project.EmployeeManagementSysterm.entity.Employee;
import com.practice_project.EmployeeManagementSysterm.service.EmployeeService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Optional;

@Controller
public class PageController {

    private final EmployeeService employeeService;

    public PageController(EmployeeService theEmployeeService){
        employeeService = theEmployeeService;
    }

    @GetMapping("/")
    public String showHome(){
        return "home";
    }

    @GetMapping("/employees-list")
    public String showEmployeesList(Model theModel){

        List<Employee> theEmployee = employeeService.findAll();

        theModel.addAttribute("employees", theEmployee);

        return "employees-list";
    }

    @GetMapping("/employee-form")
    public String showEmployeeForm(Employee theEmployee){
        return "employee-form";
    }

    @GetMapping("/update")
    public String updateEmployee(@RequestParam("employeeId") int theId, Model theModel){
        Optional<Employee> theEmployee = employeeService.findById(theId);
        theModel.addAttribute("employee", theEmployee);
        return "employee-form";
    }

    @GetMapping("/delete")
    public String deleteEmployee(@RequestParam("employeeId") int theId){
        employeeService.deleteEmployeeById(theId);

        return "redirect:/employees-list";
    }

    @PostMapping("/save")
    public String saveEmployee(@ModelAttribute("employee") Employee theEmployee){
        employeeService.save(theEmployee);
        return "redirect:/employees-list";
    }
}
