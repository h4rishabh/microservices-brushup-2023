package com.hb.employeeservice.controller;

import com.hb.employeeservice.dto.EmployeeDTO;
import com.hb.employeeservice.service.EmployeeService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/employee")
@AllArgsConstructor
public class EmployeeController {

    private EmployeeService employeeService;


    // Build REST API to Save Employee
    @PostMapping
    public ResponseEntity<EmployeeDTO> saveEmployee(@RequestBody EmployeeDTO employee){

        EmployeeDTO savedEmployee = employeeService.saveEmployee(employee);
        return new ResponseEntity<>(savedEmployee, HttpStatus.CREATED);
    }

    // Build REST API to Get Employee details
    @GetMapping("{id}")
    public ResponseEntity<EmployeeDTO> getEmployeeById(@PathVariable("id") Long employeeId){

        EmployeeDTO existingUser = employeeService.findEmployeeById(employeeId);
        return new ResponseEntity<>(existingUser, HttpStatus.CREATED);
    }

}
