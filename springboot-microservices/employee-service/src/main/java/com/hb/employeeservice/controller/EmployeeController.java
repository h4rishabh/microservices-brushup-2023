package com.hb.employeeservice.controller;

import com.hb.employeeservice.dto.ApiResponseDTO;
import com.hb.employeeservice.dto.EmployeeDTO;
import com.hb.employeeservice.service.EmployeeService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Tag(
        name = "Rest APIs for Employee Service",
        description = "Get Employee, Create Employee"
)
@RestController
@RequestMapping("/api/employee")
@AllArgsConstructor
public class EmployeeController {

    private EmployeeService employeeService;


    // Build REST API to Save Employee
    @Operation(
            summary = "Create Employee Rest API",
            description = "Used to create new Employee in Database"
    )
    @ApiResponse(
            responseCode = "201",
            description = "HTTP Status 201 Created"
    )
    @PostMapping
    public ResponseEntity<EmployeeDTO> saveEmployee(@RequestBody EmployeeDTO employee){

        EmployeeDTO savedEmployee = employeeService.saveEmployee(employee);
        return new ResponseEntity<>(savedEmployee, HttpStatus.CREATED);
    }

    // Build REST API to Get Employee details
    @Operation(
            summary = "Get Employee details Rest API",
            description = "Used to fetch particular Employee details from Database"
    )
    @ApiResponse(
            responseCode = "200",
            description = "HTTP Status 200 SUCCESS"
    )
    @GetMapping("{id}")
    public ResponseEntity<ApiResponseDTO> getEmployeeById(@PathVariable("id") Long employeeId){

        ApiResponseDTO existingUser = employeeService.findEmployeeById(employeeId);
        return new ResponseEntity<>(existingUser, HttpStatus.CREATED);
    }

}
