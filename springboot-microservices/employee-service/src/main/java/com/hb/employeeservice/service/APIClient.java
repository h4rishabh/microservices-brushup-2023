package com.hb.employeeservice.service;

import com.hb.employeeservice.dto.DepartmentDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(url = "http://localhost:8080/", value = "DEPARTMENT-SERVICE")
public interface APIClient {

    // Build REST API to get Department by Code
    @GetMapping("/api/departments/{department-code}")
    DepartmentDTO findDepartmentByCode(@PathVariable("department-code") String departmentCode);
}
