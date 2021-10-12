package com.example.webfluxdemo.dao.impl;

import com.example.webfluxdemo.dao.EmployeeRepository;
import com.example.webfluxdemo.dao.model.EmployeeDO;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Mono;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@Repository
public class EmployeeRepositoryImpl implements EmployeeRepository {

    Map<String, EmployeeDO> inMemoryEmployeeDB  = new HashMap<>();

    @Override
    public Mono<String> saveEmployee(EmployeeDO employee) {
        String employeeId = UUID.randomUUID().toString();
        employee.setEmployeeId(employeeId);
        inMemoryEmployeeDB.put(employeeId, employee);
        return Mono.just(employeeId);
    }

    @Override
    public Mono<EmployeeDO> getEmployee(String employeeId) {
        return Mono.just(inMemoryEmployeeDB.get(employeeId));
    }
}
