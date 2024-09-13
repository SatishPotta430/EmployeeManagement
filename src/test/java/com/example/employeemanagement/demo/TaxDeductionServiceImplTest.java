package com.example.employeemanagement.demo;

import com.example.employeemanagement.model.Employee;
import com.example.employeemanagement.repository.EmployeeRepository;
import com.example.employeemanagement.service.TaxDeductionServiceImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;
import java.util.Optional;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class TaxDeductionServiceImplTest {

    @InjectMocks
    TaxDeductionServiceImpl taxDeductionService;
    @Mock
    EmployeeRepository employeeRepository;

    @Test
    void calculateTaxDeduction(){
        Employee employee = Employee.builder().employeeId("EMP1")
                .firstName("Satish")
                .lastName("Potta")
                .email("satishpotta@gmail.com")
                .doj("2023-05-16")
                .phoneNumbers(List.of("9876543212","8989765432"))
                .salary(250000D)
                .build();
        when(employeeRepository.findById(any())).thenReturn(Optional.ofNullable(employee));

        var result = taxDeductionService.calculateTaxDeduction("123");
        Assertions.assertEquals(412500.0, result.getTaxAmount());
        Assertions.assertEquals(5000.0, result.getCessAmount());
    }

}
