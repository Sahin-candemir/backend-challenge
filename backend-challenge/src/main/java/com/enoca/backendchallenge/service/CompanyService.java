package com.enoca.backendchallenge.service;

import com.enoca.backendchallenge.dto.CompanyDto;
import com.enoca.backendchallenge.dto.CreateCompanyDto;
import com.enoca.backendchallenge.dto.UpdateCompanyDto;

import java.util.List;

public interface CompanyService {
    CompanyDto createCompany(CreateCompanyDto createCompanyDto);

    List<CompanyDto> getAllCompany();

    CompanyDto getCompanyById(Long id);

    CompanyDto updateCompany(Long id, UpdateCompanyDto updateCompanyDto);

    void deleteCompany(Long id);

    CompanyDto getCompanyByName(String name);
}
