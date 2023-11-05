package com.enoca.backendchallenge.serviceImpl;

import com.enoca.backendchallenge.dto.CompanyDto;
import com.enoca.backendchallenge.dto.CreateEmployeeDto;
import com.enoca.backendchallenge.dto.EmployeeDto;
import com.enoca.backendchallenge.dto.UpdateEmployeeDto;
import com.enoca.backendchallenge.exception.ResourceNotFoundException;
import com.enoca.backendchallenge.model.Company;
import com.enoca.backendchallenge.model.Employee;
import com.enoca.backendchallenge.repository.EmployeeRepository;
import com.enoca.backendchallenge.service.CompanyService;
import com.enoca.backendchallenge.service.EmployeeService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class EmployeeServiceImpl implements EmployeeService {

    private final EmployeeRepository employeeRepository;
    private final CompanyService companyService;
    private final ModelMapper mapper;
    @Override
    public EmployeeDto createEmployee(Long companyId, CreateEmployeeDto createEmployeeDto) {
        CompanyDto companyDto =companyService.getCompanyById(companyId);
        Company company = mapper.map(companyDto, Company.class);

        Employee employee = new Employee();
        employee.setFirstName(createEmployeeDto.getFirstName());
        employee.setLastName(createEmployeeDto.getLastName());
        employee.setEmail(createEmployeeDto.getEmail());
        employee.setAge(createEmployeeDto.getAge());
        employee.setCreatedDate(LocalDateTime.now());
        employee.setCompany(company);
        Employee saveEmployee = employeeRepository.save(employee);
        
        return mapper.map(saveEmployee, EmployeeDto.class);
    }

    @Override
    public List<EmployeeDto> getAllEmployees() {
        List<Employee> employees = employeeRepository.findAll();
        return employees.stream().map(employee -> mapper.map(employee, EmployeeDto.class)).collect(Collectors.toList());
    }

    @Override
    public EmployeeDto getEmployeeById(Long id) {
        Employee employee = employeeRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Employee not found by id: "+id));
        return mapper.map(employee, EmployeeDto.class);
    }

    @Override
    public EmployeeDto updateEmployee(Long id, UpdateEmployeeDto updateEmployeeDto) {
        Employee employee = employeeRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Employee not found by id: "+id));

        CompanyDto companyDto =companyService.getCompanyById(updateEmployeeDto.getCompanyId());
        Company company = mapper.map(companyDto, Company.class);

        employee.setCompany(company);
        employee.setFirstName(updateEmployeeDto.getFirstName());
        employee.setLastName(updateEmployeeDto.getLastName());
        employee.setEmail(updateEmployeeDto.getEmail());
        employee.setAge(updateEmployeeDto.getAge());

        Employee updatedEmployee = employeeRepository.save(employee);

        return mapper.map(updatedEmployee, EmployeeDto.class);
    }

    @Override
    public void deleteEmployee(Long id) {
        Employee employee = employeeRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Employee not found by id: "+id));

        employeeRepository.delete(employee);
    }

    @Override
    public List<EmployeeDto> getEmployeesByCompanyName(String companyName) {
        CompanyDto companyDto = companyService.getCompanyByName(companyName);

        List<Employee> employees = employeeRepository.findByCompanyId(companyDto.getId());

        return employees.stream().map(employee -> mapper.map(employee, EmployeeDto.class)).collect(Collectors.toList());
    }

}
