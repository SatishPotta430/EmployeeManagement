package com.example.employeemanagement.service;

import com.example.employeemanagement.model.Employee;
import com.example.employeemanagement.model.TaxDeduction;
import com.example.employeemanagement.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.Month;
import java.time.temporal.ChronoUnit;

@Service
public class TaxDeductionServiceImpl implements TaxDeductionService {

    @Autowired
    private EmployeeRepository employeeRepository;

    public TaxDeduction calculateTaxDeduction(String employeeId) {
        Employee employee = employeeRepository.findById(employeeId)
                .orElseThrow(() -> new RuntimeException("Employee not found"));

        LocalDate doj = LocalDate.parse(employee.getDoj());
        LocalDate endOfYear = LocalDate.of(LocalDate.now().getYear(), Month.MARCH, 31);
        long monthsWorked = ChronoUnit.MONTHS.between(doj, endOfYear) + 1;

        double yearlySalary = employee.getSalary() * monthsWorked;
        double taxAmount = calculateTax(yearlySalary);
        double cessAmount = yearlySalary > 2500000 ? (yearlySalary - 2500000) * 0.02 : 0;

        return new TaxDeduction(employee.getEmployeeId(), employee.getFirstName(), employee.getLastName(),
                yearlySalary, taxAmount, cessAmount);
    }
   //TaxDeduction log
    private double calculateTax(double salary) {
        double tax = 0;

        if (salary > 1000000) {
            tax += (salary - 1000000) * 0.20;
            salary = 1000000;
        }
        if (salary > 500000) {
            tax += (salary - 500000) * 0.10;
            salary = 500000;
        }
        if (salary > 250000) {
            tax += (salary - 250000) * 0.05;
        }

        return tax;
    }
}
