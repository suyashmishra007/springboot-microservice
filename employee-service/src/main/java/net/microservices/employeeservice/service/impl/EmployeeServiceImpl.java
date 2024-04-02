package net.microservices.employeeservice.service.impl;

import lombok.AllArgsConstructor;
import net.microservices.employeeservice.dto.APIResponseDto;
import net.microservices.employeeservice.dto.DepartmentDto;
import net.microservices.employeeservice.dto.EmployeeDto;
import net.microservices.employeeservice.entity.Employee;
import net.microservices.employeeservice.mapper.EmployeeMapper;
import net.microservices.employeeservice.repository.EmployeeRepository;
import net.microservices.employeeservice.service.APIClient;
import net.microservices.employeeservice.service.EmployeeService;
import org.springframework.http.ResponseEntity;
import org.springframework.http.client.SimpleClientHttpRequestFactory;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;

@Service
@AllArgsConstructor
public class EmployeeServiceImpl implements EmployeeService {

  private EmployeeRepository employeeRepository;
  //  private RestTemplate restTemplate;
  // private WebClient webClient;
  private APIClient apiClient;
  @Override
  public EmployeeDto saveEmployee(EmployeeDto employeeDto) {
    Employee employee = EmployeeMapper.mapToEmployee(employeeDto);
    Employee saveDEmployee = employeeRepository.save(employee);
    return EmployeeMapper.mapToEmployeeDto(saveDEmployee);
  }

  @Override
  public APIResponseDto getEmployeeById(Long employeeId) {
    Employee employee = employeeRepository.findById(employeeId).get();
    //    ResponseEntity<DepartmentDto> responseEntity = restTemplate.getForEntity("http://localhost:8080/api/departments/"+employee.getDepartmentCode(),DepartmentDto.class);
    // DepartmentDto departmentDto = webClient.get().uri("http://localhost:8080/api/departments/"+employee.getDepartmentCode()).retrieve().bodyToMono(DepartmentDto.class).block();
    //    DepartmentDto departmentDto = responseEntity.getBody();
    DepartmentDto departmentDto = apiClient.getDepartment(employee.getDepartmentCode());
    EmployeeDto employeeDto = EmployeeMapper.mapToEmployeeDto(employee);
    APIResponseDto apiResponseDto = new APIResponseDto();
    apiResponseDto.setEmployee(employeeDto);
    apiResponseDto.setDepartment(departmentDto);
    return apiResponseDto;
  }
}
