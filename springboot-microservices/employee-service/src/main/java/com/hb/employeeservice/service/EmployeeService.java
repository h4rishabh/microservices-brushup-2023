package com.hb.employeeservice.service;

import com.hb.employeeservice.dto.EmployeeDTO;

public interface EmployeeService {
    EmployeeDTO saveEmployee(EmployeeDTO employeeDTO);
    EmployeeDTO findEmployeeById(Long id);
}
