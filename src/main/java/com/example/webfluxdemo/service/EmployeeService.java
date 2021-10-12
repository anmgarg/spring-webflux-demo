package com.example.webfluxdemo.service;

import com.example.webfluxdemo.model.Employee;
import reactor.core.publisher.Mono;

public interface EmployeeService {

    Mono<Employee> getEmployee(String employeeId);

    Mono<String> saveEmployee(Employee employee);

}
