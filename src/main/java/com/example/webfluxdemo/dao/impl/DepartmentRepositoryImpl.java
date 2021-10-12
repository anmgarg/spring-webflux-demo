package com.example.webfluxdemo.dao.impl;

import com.example.webfluxdemo.dao.DepartmentRepository;
import com.example.webfluxdemo.dao.model.DepartmentDO;
import com.example.webfluxdemo.model.Department;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Mono;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@Repository
public class DepartmentRepositoryImpl implements DepartmentRepository {

    Map<String, DepartmentDO> inMemoryDepartmentDB = new HashMap<>();

    @Override
    public Mono<String> saveDepartment(DepartmentDO departmentDO) {
        String departmentId = UUID.randomUUID().toString();
        departmentDO.setDepartmentId(departmentId);
        inMemoryDepartmentDB.put(departmentId, departmentDO);
        return Mono.just(departmentId);
    }

    @Override
    public Mono<DepartmentDO> getDepartment(String departmentId) {
        return Mono.just(inMemoryDepartmentDB.get(departmentId));
    }
}
