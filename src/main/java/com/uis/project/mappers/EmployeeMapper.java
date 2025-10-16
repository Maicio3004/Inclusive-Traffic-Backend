package com.uis.project.mappers;

import com.uis.project.dtos.request.EmployeeRequest;
import com.uis.project.persistences.models.Employee;

public class EmployeeMapper {

    public static Employee toEntity(EmployeeRequest request) {

        Employee employee = new Employee();

        employee.setRole(request.getRole());
        employee.setFirstName(request.getFirstName());
        employee.setSecondName(request.getSecondName());
        employee.setFirstLastName(request.getFirstLastName());
        employee.setSecondLastName(request.getSecondLastName());
        employee.setEmail(request.getEmail());
        employee.setPassword(request.getPassword());
        employee.setPhone(request.getPhone());

        return employee;
    }

}
