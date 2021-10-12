package com.example.webfluxdemo.service.impl;

import com.example.webfluxdemo.dao.EmployeeRepository;
import com.example.webfluxdemo.model.Employee;
import com.example.webfluxdemo.service.DepartmentService;
import com.example.webfluxdemo.service.EmployeeService;
import com.example.webfluxdemo.service.converter.EmployeeConverter;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    private DepartmentService departmentService;

    private EmployeeRepository employeeRepository;

    public EmployeeServiceImpl(DepartmentService departmentService, EmployeeRepository employeeRepository) {
        this.departmentService = departmentService;
        this.employeeRepository = employeeRepository;
    }

    @Override
    public Mono<Employee> getEmployee(String employeeId) {
        return employeeRepository.getEmployee(employeeId)
                .flatMap(employeeDO -> departmentService.getDepartment(employeeDO.getDepartmentId())
                        .map(department -> EmployeeConverter.reConvert(employeeDO, department)));
    }

    @Override
    public Mono<String> saveEmployee(Employee employee) {
        return departmentService.saveDepartment(employee.getDepartment())
                .flatMap(departmentId -> employeeRepository.saveEmployee(EmployeeConverter.convert(employee, departmentId)));
    }
}
