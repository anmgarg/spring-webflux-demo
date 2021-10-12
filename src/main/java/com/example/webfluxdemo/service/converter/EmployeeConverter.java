package com.example.webfluxdemo.service.converter;

import com.example.webfluxdemo.dao.model.EmployeeDO;
import com.example.webfluxdemo.model.Department;
import com.example.webfluxdemo.model.Employee;

public class EmployeeConverter {
    public static EmployeeDO convert(Employee employee, String departmentId) {
        EmployeeDO employeeDO = new EmployeeDO();
        employeeDO.setEmployeeId(employee.getEmployeeId());
        employeeDO.setEmployeeName(employee.getEmployeeName());
        employeeDO.setDepartmentId(departmentId);
        return employeeDO;
    }

    public static Employee reConvert(EmployeeDO EmployeeDO, Department department) {
        Employee employee = new Employee();
        employee.setEmployeeId(EmployeeDO.getEmployeeId());
        employee.setEmployeeName(EmployeeDO.getEmployeeName());
        employee.setDepartment(department);
        return employee;
    }
}
