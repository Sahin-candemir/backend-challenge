package com.enoca.backendchallenge.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class EmployeeDto {

    private Long id;

    private String firstName;

    private String lastName;

    private String email;

    private int age;

    private LocalDateTime createdDate;
}
