package com.hb.departmentservice.controller;

import com.hb.departmentservice.dto.DepartmentDTO;
import com.hb.departmentservice.service.DepartmentService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Tag(
        name = "Rest APIs for Department Service",
        description = "Get Department, Get all departments, Create Department"
)
@RestController
@RequestMapping("/api/departments")
@AllArgsConstructor
public class DepartmentController {

    private DepartmentService departmentService;

    @Operation(
            summary = "Create Department Rest API",
            description = "Used to create new Department in Database"
    )
    @ApiResponse(
            responseCode = "201",
            description = "HTTP Status 201 Created"
    )
    // Build REST API to create Department
    @PostMapping
    public ResponseEntity<DepartmentDTO> saveDepartment(@RequestBody DepartmentDTO departmentDTO){
        DepartmentDTO savedDepartmentDTO  = departmentService.saveDepartment(departmentDTO);
        return new ResponseEntity<>(savedDepartmentDTO, HttpStatus.CREATED);
    }

    // Build REST API to get Department by Code
    @Operation(
            summary = "Get Department Rest API",
            description = "Used to fetch particular Department details from Database"
    )
    @ApiResponse(
            responseCode = "200",
            description = "HTTP Status 200 SUCCESS"
    )
    @GetMapping("{department-code}")
    public ResponseEntity<DepartmentDTO> findDepartmentByCode(@PathVariable("department-code") String departmentCode){
        DepartmentDTO fetchedDepartmentDTO  = departmentService.getDepartmentByCode(departmentCode);
        return new ResponseEntity<>(fetchedDepartmentDTO, HttpStatus.OK);
    }

    // Build REST API to get Department by Code
    @Operation(
            summary = "Get All Departments Rest API",
            description = "Used to fetch all Department details from Database"
    )
    @ApiResponse(
            responseCode = "200",
            description = "HTTP Status 200 SUCCESS"
    )
    @GetMapping()
    public ResponseEntity<List<DepartmentDTO>> findAllDepartment(){
        List<DepartmentDTO> deptDtoList  = departmentService.getAllDepartment();
        return new ResponseEntity<>(deptDtoList, HttpStatus.OK);
    }
}
