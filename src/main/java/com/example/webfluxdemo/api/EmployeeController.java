package com.example.webfluxdemo.api;

import com.example.webfluxdemo.model.Employee;
import com.example.webfluxdemo.service.EmployeeService;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;

@RestController
public class EmployeeController {

    private EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping("/get/{employeeId}")
    public Mono<Employee> getEmployee(@PathVariable("employeeId") String employeeId) {
        return employeeService.getEmployee(employeeId);
    }

    @PostMapping("/saveEmployee")
    public Mono<String> saveEmployee(@RequestBody Employee employee) {
        return employeeService.saveEmployee(employee);
    }

}
