package com.enoca.backendchallenge.service;

import com.enoca.backendchallenge.dto.CreateEmployeeDto;
import com.enoca.backendchallenge.dto.EmployeeDto;
import com.enoca.backendchallenge.dto.UpdateEmployeeDto;

import java.util.List;

public interface EmployeeService {
    EmployeeDto createEmployee(Long companyId, CreateEmployeeDto createEmployeeDto);

    List<EmployeeDto> getAllEmployees();

    EmployeeDto getEmployeeById(Long id);

    EmployeeDto updateEmployee(Long id, UpdateEmployeeDto updateEmployeeDto);

    void deleteEmployee(Long id);

    List<EmployeeDto> getEmployeesByCompanyName(String companyName);

}
