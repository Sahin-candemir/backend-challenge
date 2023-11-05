package com.enoca.backendchallenge.dto;

import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Service;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CreateEmployeeDto {

    @NotNull(message = "first name cannot be null.")
    @NotEmpty(message = "first name cannot be empty.")
    private String firstName;

    @NotNull(message = "last name cannot be null.")
    @NotEmpty(message = "last name cannot be empty.")
    private String lastName;

    @Email(message = "Invalid email.")
    private String email;

    @Min(value = 18,message = "Age must be greater than 18.")
    @Max(value = 64,message = "age must be less than 64.")
    private int age;
}
