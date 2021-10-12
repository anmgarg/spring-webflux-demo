package com.example.webfluxdemo.service.converter;

import com.example.webfluxdemo.dao.model.DepartmentDO;
import com.example.webfluxdemo.model.Department;

public class DepartmentConverter {

    public static DepartmentDO convert(Department department) {
        DepartmentDO departmentDO = new DepartmentDO();
        departmentDO.setDepartmentId(department.getDepartmentId());
        departmentDO.setDepartmentName(department.getDepartmentName());
        return departmentDO;
    }

    public static Department reConvert(DepartmentDO departmentDO) {
        Department department = new Department();
        department.setDepartmentId(departmentDO.getDepartmentId());
        department.setDepartmentName(departmentDO.getDepartmentName());
        return department;
    }

}
