package com.enoca.backendchallenge.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UpdateEmployeeDto {

    private String firstName;

    private String lastName;

    private String email;

    private int age;

    private Long companyId;
}
