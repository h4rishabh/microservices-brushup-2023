package com.hb.departmentservice.controller;

import com.hb.departmentservice.dto.DepartmentDTO;
import com.hb.departmentservice.service.DepartmentService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/departments")
@AllArgsConstructor
public class DepartmentController {

    private DepartmentService departmentService;

    // Build REST API to create Department
    @PostMapping
    public ResponseEntity<DepartmentDTO> saveDepartment(@RequestBody DepartmentDTO departmentDTO){
        DepartmentDTO savedDepartmentDTO  = departmentService.saveDepartment(departmentDTO);
        return new ResponseEntity<>(savedDepartmentDTO, HttpStatus.CREATED);
    }

    // Build REST API to get Department by Code
    @GetMapping("{code}")
    public ResponseEntity<DepartmentDTO> findDepartmentByCode(@PathVariable("code") String departmentCode){
        DepartmentDTO fetchedDepartmentDTO  = departmentService.getDepartmentByCode(departmentCode);
        return new ResponseEntity<>(fetchedDepartmentDTO, HttpStatus.OK);
    }
}
