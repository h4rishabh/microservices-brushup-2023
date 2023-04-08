package com.hb.employeeservice.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Schema(
        description = "API Response Structure Models Information"
)
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class ApiResponseDTO {
    private EmployeeDTO employee;
    private DepartmentDTO department;
    private OrganizationDTO organization;
}
