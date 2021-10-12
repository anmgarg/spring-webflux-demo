package com.example.webfluxdemo.dao;

import com.example.webfluxdemo.dao.model.EmployeeDO;
import reactor.core.publisher.Mono;

public interface EmployeeRepository {

    Mono<String> saveEmployee(EmployeeDO employee);

    Mono<EmployeeDO> getEmployee(String employeeId);

}
