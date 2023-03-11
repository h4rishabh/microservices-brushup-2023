package com.hb.employeeservice.service;

import com.hb.employeeservice.dto.ApiResponseDTO;
import com.hb.employeeservice.dto.DepartmentDTO;
import com.hb.employeeservice.dto.EmployeeDTO;
import com.hb.employeeservice.entity.Employee;
import com.hb.employeeservice.repository.EmployeeRepository;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.Optional;


@Service
@AllArgsConstructor
public class EmployeeServiceImpl implements  EmployeeService{

    private EmployeeRepository employeeRepository;
    //private RestTemplate restTemplate;
    //private  WebClient webClient;

    private APIClient apiClient;

    @Override
    public EmployeeDTO saveEmployee(EmployeeDTO employeeDTO) {
        Employee employee = new Employee(
                employeeDTO.getId(),
                employeeDTO.getFirstName(),
                employeeDTO.getLastName(),
                employeeDTO.getEmail(),
                employeeDTO.getDepartmentCode()
        );

        Employee savedEmployee = employeeRepository.save(employee);

        EmployeeDTO saveEmployeeDTO = new EmployeeDTO(
                savedEmployee.getId(),
                savedEmployee.getFirstName(),
                savedEmployee.getLastName(),
                savedEmployee.getEmail(),
                savedEmployee.getDepartmentCode()
        );

        return saveEmployeeDTO;
    }

    @Override
    public ApiResponseDTO findEmployeeById(Long id) {

        Employee employee = employeeRepository.findById(id).get();

//        ResponseEntity<DepartmentDTO> responseEntity = restTemplate.getForEntity("http://localhost:8080/api/departments/" + employee.getDepartmentCode(),
//                DepartmentDTO.class);
//
//        DepartmentDTO departmentDTO = responseEntity.getBody();

//        DepartmentDTO departmentDTO = webClient.get()
//                .uri("http://localhost:8080/api/departments/" + employee.getDepartmentCode())
//                .retrieve()
//                .bodyToMono(DepartmentDTO.class)
//                .block();

        DepartmentDTO departmentDTO = apiClient.findDepartmentByCode(employee.getDepartmentCode());

        EmployeeDTO existingEmployee = new EmployeeDTO(employee.getId(),
                employee.getFirstName(),
                employee.getLastName(),
                employee.getEmail(),
                employee.getDepartmentCode()
        );

        ApiResponseDTO apiResponseDTO = new ApiResponseDTO();
        apiResponseDTO.setEmployeeDTO(existingEmployee);
        apiResponseDTO.setDepartmentDTO(departmentDTO);


        return apiResponseDTO;
    }

}
