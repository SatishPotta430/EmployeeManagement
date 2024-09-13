package com.example.employeemanagement.controller;


import com.example.employeemanagement.model.Employee;
import com.example.employeemanagement.repository.EmployeeRepository;
import com.example.employeemanagement.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import jakarta.validation.Valid;

import java.util.List;

@RestController
@RequestMapping("/V1")
@Validated
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;


    @PostMapping("/api/employees")
    public ResponseEntity<String> saveEmployee(@Valid @RequestBody Employee employee) {
        if (employeeService.existsById(employee.getEmployeeId())) {
            return new ResponseEntity<>("Employee ID already exists", HttpStatus.BAD_REQUEST);
        }
        employeeService.save(employee);
        return new ResponseEntity<>("Employee details saved successfully", HttpStatus.CREATED);
    }


    @GetMapping("/api/employees")
    public ResponseEntity<List<Employee>> getAllEmployee(){
        return new ResponseEntity<>(employeeService.getAllEmployees(), HttpStatus.OK);

    }
}
