package net.microservices.employeeservice.dto;

import lombok.*;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class DepartmentDto {

  private Long id;
  private String departmentName;
  private String departmentDescription;
  private String departmentCode;
}
