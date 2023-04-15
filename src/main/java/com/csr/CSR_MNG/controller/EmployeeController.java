package com.CSR.CSR_MNG.controller;



import com.CSR.CSR_MNG.model.Employee;
 import com.CSR.CSR_MNG.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/employee")
@CrossOrigin
public class EmployeeController {
    @Autowired
    private EmployeeService employeeService;

    @PostMapping("/add")
    public String add(@RequestBody Employee employee){
        employeeService.saveEmployee(employee);
        return "New employee is added";
    }

    @GetMapping("/getAll")
    public List<Employee> list(){
        return employeeService.getAllEmployees();
    }
}