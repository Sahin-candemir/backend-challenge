package com.enoca.backendchallenge.serviceImpl;

import com.enoca.backendchallenge.dto.CompanyDto;
import com.enoca.backendchallenge.dto.CreateCompanyDto;
import com.enoca.backendchallenge.dto.UpdateCompanyDto;
import com.enoca.backendchallenge.exception.ResourceNotFoundException;
import com.enoca.backendchallenge.model.Company;
import com.enoca.backendchallenge.repository.CompanyRepository;
import com.enoca.backendchallenge.service.CompanyService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class CompanyServiceImpl implements CompanyService {

    private final CompanyRepository companyRepository;
    private final ModelMapper mapper;
    @Override
    public CompanyDto createCompany(CreateCompanyDto createCompanyDto) {
        Company company = new Company();
        company.setName(createCompanyDto.getName());
        company.setCreatedDate(LocalDateTime.now());

        Company saveCompany = companyRepository.save(company);

        return mapper.map(saveCompany, CompanyDto.class);
    }

    @Override
    public List<CompanyDto> getAllCompany() {
        List<Company> companies = companyRepository.findAll();

        return companies.stream().map(company -> mapper.map(company, CompanyDto.class)).collect(Collectors.toList());
    }

    @Override
    public CompanyDto getCompanyById(Long id) {
        Company company = companyRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Company not found with id: "+id));

        return mapper.map(company, CompanyDto.class);
    }

    @Override
    public CompanyDto updateCompany(Long id, UpdateCompanyDto updateCompanyDto) {
        Company company = companyRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Company not found with id: "+id));

        company.setName(updateCompanyDto.getName());

        Company updatedCompany = companyRepository.save(company);

        return mapper.map(updatedCompany, CompanyDto.class);
    }

    @Override
    public void deleteCompany(Long id) {
        Company company = companyRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Company not found with id: "+id));

        companyRepository.delete(company);
    }

    @Override
    public CompanyDto getCompanyByName(String name) {
        Company company = companyRepository.findByName(name)
                .orElseThrow(() -> new ResourceNotFoundException("Company not found with name: "+name));
        return mapper.map(company, CompanyDto.class);
    }
}
