package net.microservices.employeeservice.service.impl;

import lombok.AllArgsConstructor;
import net.microservices.employeeservice.dto.APIResponseDto;
import net.microservices.employeeservice.dto.DepartmentDto;
import net.microservices.employeeservice.dto.EmployeeDto;
import net.microservices.employeeservice.entity.Employee;
import net.microservices.employeeservice.mapper.EmployeeMapper;
import net.microservices.employeeservice.repository.EmployeeRepository;
import net.microservices.employeeservice.service.EmployeeService;
import org.springframework.http.ResponseEntity;
import org.springframework.http.client.SimpleClientHttpRequestFactory;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
@AllArgsConstructor
public class EmployeeServiceImpl implements EmployeeService {

  private EmployeeRepository employeeRepository;
  private RestTemplate restTemplate;
  @Override
  public EmployeeDto saveEmployee(EmployeeDto employeeDto) {
    Employee employee = EmployeeMapper.mapToEmployee(employeeDto);
    Employee saveDEmployee = employeeRepository.save(employee);
    return EmployeeMapper.mapToEmployeeDto(saveDEmployee);
  }

  @Override
  public APIResponseDto getEmployeeById(Long employeeId) {
    Employee employee = employeeRepository.findById(employeeId).get();
    System.out.println(employee.toString());
    ResponseEntity<DepartmentDto> responseEntity = restTemplate.getForEntity("https://localhost:8080/api/departments/"+employee.getDepartmentCode(),DepartmentDto.class);
    DepartmentDto departmentDto = responseEntity.getBody();
    EmployeeDto employeeDto = EmployeeMapper.mapToEmployeeDto(employee);

    APIResponseDto apiResponseDto = new APIResponseDto();
    apiResponseDto.setEmployee(employeeDto);
    apiResponseDto.setDepartment(departmentDto);
    return apiResponseDto;
  }
}
