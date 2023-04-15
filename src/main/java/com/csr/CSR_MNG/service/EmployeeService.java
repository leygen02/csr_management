package com.CSR.CSR_MNG.service;

import com.CSR.CSR_MNG.model.Employee;

import java.util.List;


public interface EmployeeService {
    public Employee saveEmployee(Employee employee);
    public List<Employee> getAllEmployees();
}