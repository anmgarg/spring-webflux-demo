package com.example.webfluxdemo.dao;

import com.example.webfluxdemo.dao.model.DepartmentDO;
import reactor.core.publisher.Mono;

public interface DepartmentRepository {

    Mono<String> saveDepartment(DepartmentDO department);

    Mono<DepartmentDO> getDepartment(String departmentId);

}
