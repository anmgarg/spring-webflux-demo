package com.example.webfluxdemo.service.impl;

import com.example.webfluxdemo.dao.DepartmentRepository;
import com.example.webfluxdemo.model.Department;
import com.example.webfluxdemo.service.DepartmentService;
import com.example.webfluxdemo.service.converter.DepartmentConverter;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
public class DepartmentServiceImpl implements DepartmentService {

    private DepartmentRepository departmentRepository;

    public DepartmentServiceImpl(DepartmentRepository departmentRepository) {
        this.departmentRepository = departmentRepository;
    }

    @Override
    public Mono<String> saveDepartment(Department department) {
        return departmentRepository.saveDepartment(DepartmentConverter.convert(department));
    }

    @Override
    public Mono<Department> getDepartment(String departmentId) {
        return departmentRepository.getDepartment(departmentId)
                .map(DepartmentConverter::reConvert);
    }
}
