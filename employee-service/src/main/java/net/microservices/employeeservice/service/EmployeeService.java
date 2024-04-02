package net.microservices.employeeservice.service;

import net.microservices.employeeservice.dto.APIResponseDto;
import net.microservices.employeeservice.dto.EmployeeDto;

public interface EmployeeService {
    EmployeeDto saveEmployee(EmployeeDto employeeDto);
    EmployeeDto getEmployeeById(Long employeeId);
}
