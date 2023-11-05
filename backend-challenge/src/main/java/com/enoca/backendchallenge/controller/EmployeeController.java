package com.enoca.backendchallenge.controller;

import com.enoca.backendchallenge.dto.CreateEmployeeDto;
import com.enoca.backendchallenge.dto.EmployeeDto;
import com.enoca.backendchallenge.dto.UpdateEmployeeDto;
import com.enoca.backendchallenge.service.EmployeeService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/employee")
@RequiredArgsConstructor
public class EmployeeController {

    private final EmployeeService employeeService;

    @PostMapping("/{companyId}")
    public ResponseEntity<EmployeeDto> createEmployee(@PathVariable Long companyId, @Valid @RequestBody CreateEmployeeDto createEmployeeDto){
        return new ResponseEntity<>(employeeService.createEmployee(companyId, createEmployeeDto), HttpStatus.CREATED);
    }
    @GetMapping
    public ResponseEntity<List<EmployeeDto>> getAllEmployees(){
        return new ResponseEntity<>(employeeService.getAllEmployees(), HttpStatus.OK);
    }
    @GetMapping("/{id}")
    public ResponseEntity<EmployeeDto> getEmployeeById(@PathVariable Long id){
        return new ResponseEntity<>(employeeService.getEmployeeById(id), HttpStatus.OK);
    }
    @GetMapping("/byCompanyName")
    public ResponseEntity<List<EmployeeDto>> getEmployeesByCompanyName(@RequestParam String companyName){
        return new ResponseEntity<>(employeeService.getEmployeesByCompanyName(companyName), HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<EmployeeDto> updateEmployee(@PathVariable Long id, @RequestBody UpdateEmployeeDto updateEmployeeDto){
        return new ResponseEntity<>(employeeService.updateEmployee(id, updateEmployeeDto), HttpStatus.OK);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteEmployee(@PathVariable Long id){
        employeeService.deleteEmployee(id);
        return new ResponseEntity<>("Employee deleted success.", HttpStatus.OK);
    }

}
