package com.CSR.CSR_MNG.service;


import com.CSR.CSR_MNG.model.Employee;
import com.CSR.CSR_MNG.repository.EmpolyeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    private EmpolyeeRepository empolyeeRepository;

    @Override
    public Employee saveEmployee(Employee employee) {
        return empolyeeRepository.save(employee);
    }

    @Override
    public List<Employee> getAllEmployees() {
        return empolyeeRepository.findAll();
    }
}