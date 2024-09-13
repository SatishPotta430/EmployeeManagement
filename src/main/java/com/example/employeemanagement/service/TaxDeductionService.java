package com.example.employeemanagement.service;

import com.example.employeemanagement.model.TaxDeduction;

public interface TaxDeductionService {

    TaxDeduction calculateTaxDeduction(String employeeId);
}
