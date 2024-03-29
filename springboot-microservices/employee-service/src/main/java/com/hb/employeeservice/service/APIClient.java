package com.hb.employeeservice.service;

import com.hb.employeeservice.dto.DepartmentDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.Optional;

@FeignClient(name = "DEPARTMENT-SERVICE")
public interface APIClient {

    // Build REST API to get Department by Code
    @GetMapping("/api/departments/{department-code}")
    Optional<DepartmentDTO> findDepartmentByCode(@PathVariable("department-code") String departmentCode);
}
