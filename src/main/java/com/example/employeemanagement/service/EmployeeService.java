package com.example.employeemanagement.service;

import com.example.employeemanagement.model.Employee;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface EmployeeService {


    boolean existsById(String employeeId);

    Employee save(Employee employee);

    List<Employee> getAllEmployees();
}
