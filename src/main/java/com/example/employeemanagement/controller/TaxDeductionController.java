package com.example.employeemanagement.controller;

import com.example.employeemanagement.model.TaxDeduction;
import com.example.employeemanagement.service.TaxDeductionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/employees")
public class TaxDeductionController {

    @Autowired
    private TaxDeductionService taxDeductionService;

    @GetMapping("/{employeeId}/tax-deductions")
    public ResponseEntity<TaxDeduction> getTaxDeductions(@PathVariable String employeeId) {
        TaxDeduction taxDeduction = taxDeductionService.calculateTaxDeduction(employeeId);
        return new ResponseEntity<>(taxDeduction, HttpStatus.OK);
    }
}
