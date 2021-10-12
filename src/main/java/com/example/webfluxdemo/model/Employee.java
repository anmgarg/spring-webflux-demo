package com.example.webfluxdemo.model;

import lombok.Data;

@Data
public class Employee extends AbstractModel{

    private String employeeId;
    private String employeeName;
    private Department department;

}
