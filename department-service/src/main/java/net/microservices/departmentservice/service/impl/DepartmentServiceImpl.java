package net.microservices.departmentservice.service.impl;

import lombok.AllArgsConstructor;
import net.microservices.departmentservice.dto.DepartmentDto;
import net.microservices.departmentservice.entity.Department;
import net.microservices.departmentservice.mapper.DepartmentMapper;
import net.microservices.departmentservice.repository.DepartmentRepository;
import net.microservices.departmentservice.service.DepartmentService;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class DepartmentServiceImpl implements DepartmentService {
    private DepartmentRepository departmentRepository;
    @Override
    public DepartmentDto saveDepartment(DepartmentDto departmentDto) {
        return DepartmentMapper.mapToDepartmentDto(departmentRepository.save(DepartmentMapper.mapToDepartment(departmentDto)));
    }
    @Override
    public DepartmentDto getDepartmentByCode(String code) {
        return  DepartmentMapper.mapToDepartmentDto(departmentRepository.findByDepartmentCode(code));
    }
}
