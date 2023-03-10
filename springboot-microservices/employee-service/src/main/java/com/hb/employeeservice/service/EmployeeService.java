package com.hb.employeeservice.service;

import com.hb.employeeservice.dto.ApiResponseDTO;
import com.hb.employeeservice.dto.EmployeeDTO;

public interface EmployeeService {
    EmployeeDTO saveEmployee(EmployeeDTO employeeDTO);
    ApiResponseDTO findEmployeeById(Long id);
}
