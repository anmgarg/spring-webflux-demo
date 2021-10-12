package com.example.webfluxdemo.dao.model;

import com.example.webfluxdemo.model.Department;
import lombok.Data;

@Data
public class EmployeeDO {
    private String employeeId;
    private String employeeName;
    private String departmentId;
}
