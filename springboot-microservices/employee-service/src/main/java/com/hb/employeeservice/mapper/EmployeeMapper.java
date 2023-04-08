package com.hb.employeeservice.mapper;

import com.hb.employeeservice.dto.EmployeeDTO;
import com.hb.employeeservice.entity.Employee;

public class EmployeeMapper {

    public static Employee mapToEmployee(EmployeeDTO employeeDTO){

        Employee employee = new Employee(
                employeeDTO.getId(),
                employeeDTO.getFirstName(),
                employeeDTO.getLastName(),
                employeeDTO.getEmail(),
                employeeDTO.getDepartmentCode(),
                employeeDTO.getOrganizationCode()
        );

        return employee;
    }

    public static EmployeeDTO mapToEmployeeDTO(Employee employee){

        EmployeeDTO employeeDTO = new EmployeeDTO(
                employee.getId(),
                employee.getFirstName(),
                employee.getLastName(),
                employee.getEmail(),
                employee.getDepartmentCode(),
                employee.getOrganizationCode()
        );

        return employeeDTO;
    }
}

