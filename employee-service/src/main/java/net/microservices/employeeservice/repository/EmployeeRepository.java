package net.microservices.employeeservice.repository;

import net.microservices.employeeservice.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee,Long> {
}
