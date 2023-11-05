package com.enoca.backendchallenge.controller;

import com.enoca.backendchallenge.dto.CompanyDto;
import com.enoca.backendchallenge.dto.CreateCompanyDto;
import com.enoca.backendchallenge.dto.UpdateCompanyDto;
import com.enoca.backendchallenge.service.CompanyService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/company")
@RequiredArgsConstructor
public class CompanyController {

    private final CompanyService companyService;

    @PostMapping
    public ResponseEntity<CompanyDto> createCompany(@Valid @RequestBody CreateCompanyDto createCompanyDto){
        return new ResponseEntity<>(companyService.createCompany(createCompanyDto), HttpStatus.CREATED);
    }
    @GetMapping
    public ResponseEntity<List<CompanyDto>> getAllCompany(){
        return new ResponseEntity<>(companyService.getAllCompany(), HttpStatus.OK);
    }
    @GetMapping("/{id}")
    public ResponseEntity<CompanyDto> getCompanyById(@PathVariable Long id){
        return new ResponseEntity<>(companyService.getCompanyById(id), HttpStatus.OK);
    }
    @GetMapping("/getByName")
    public ResponseEntity<CompanyDto> getCompanyByName(@RequestParam String name){
        return new ResponseEntity<>(companyService.getCompanyByName(name), HttpStatus.OK);
    }
    @PutMapping("/{id}")
    public ResponseEntity<CompanyDto> updateCompany(@PathVariable Long id, @Valid @RequestBody UpdateCompanyDto updateCompanyDto){
        return new ResponseEntity<>(companyService.updateCompany(id, updateCompanyDto), HttpStatus.OK);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteCompany(@PathVariable Long id){
        companyService.deleteCompany(id);
        return new ResponseEntity<>("Company deleted success.", HttpStatus.OK);
    }
}
