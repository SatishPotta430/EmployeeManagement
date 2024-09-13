package com.example.employeemanagement.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Builder
public class Employee {

    @Id
    @NotBlank(message = "Employee ID is mandatory")
    private String employeeId;

    @NotBlank(message = "First name is mandatory")
    private String firstName;

    @NotBlank(message = "Last name is mandatory")
    private String lastName;

    @Email(message = "Email should be valid")
    @NotBlank(message = "Email is mandatory")
    private String email;

    @NotEmpty(message = "Phone numbers are mandatory")
    private List<@Pattern(regexp = "^\\d{10}$", message = "Phone number should be 10 digits") String> phoneNumbers;

    @Pattern(regexp = "^\\d{4}-\\d{2}-\\d{2}$", message = "Date of Joining should be in YYYY-MM-DD format")
    @NotBlank(message = "Date of joining is mandatory")
    private String doj;

    @Min(value = 20800, message = "Salary should be a positive number")
    private Double salary;
}
