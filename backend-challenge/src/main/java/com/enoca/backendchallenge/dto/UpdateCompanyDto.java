package com.enoca.backendchallenge.dto;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UpdateCompanyDto {

    @NotNull(message = "Company name cannot be Null.")
    @NotEmpty(message = "Company name cannot be Empty.")
    private String name;
}
