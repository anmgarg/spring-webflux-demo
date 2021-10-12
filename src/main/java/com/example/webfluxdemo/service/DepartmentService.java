package com.example.webfluxdemo.service;

import com.example.webfluxdemo.model.Department;
import reactor.core.publisher.Mono;

public interface DepartmentService {

    Mono<String> saveDepartment(Department department);

    Mono<Department> getDepartment(String departmentId);

}
