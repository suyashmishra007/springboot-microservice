package net.microservices.employeeservice.service.impl;

import lombok.AllArgsConstructor;
import net.microservices.employeeservice.dto.EmployeeDto;
import net.microservices.employeeservice.entity.Employee;
import net.microservices.employeeservice.mapper.EmployeeMapper;
import net.microservices.employeeservice.repository.EmployeeRepository;
import net.microservices.employeeservice.service.EmployeeService;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class EmployeeServiceImpl implements EmployeeService {
    private EmployeeRepository employeeRepository;
    @Override
    public EmployeeDto saveEmployee(EmployeeDto employeeDto) {
        Employee employee = EmployeeMapper.mapToEmployee(employeeDto);
        Employee saveDEmployee = employeeRepository.save(employee);
        return EmployeeMapper.mapToEmployeeDto(saveDEmployee);
    }

    @Override
    public EmployeeDto getEmployeeById(Long employeeId) {
        return EmployeeMapper.mapToEmployeeDto(employeeRepository.findById(employeeId).get());
    }
}
