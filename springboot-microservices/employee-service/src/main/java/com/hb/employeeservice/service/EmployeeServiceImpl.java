package com.hb.employeeservice.service;

import com.hb.employeeservice.dto.ApiResponseDTO;
import com.hb.employeeservice.dto.DepartmentDTO;
import com.hb.employeeservice.dto.EmployeeDTO;
import com.hb.employeeservice.dto.OrganizationDto;
import com.hb.employeeservice.entity.Employee;
import com.hb.employeeservice.exception.EmailAlreadyExistException;
import com.hb.employeeservice.exception.ResourceNotFoundException;
import com.hb.employeeservice.mapper.EmployeeMapper;
import com.hb.employeeservice.repository.EmployeeRepository;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.github.resilience4j.retry.annotation.Retry;
import lombok.AllArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.Optional;


@Service
@AllArgsConstructor
public class  EmployeeServiceImpl implements  EmployeeService{

    private static final Logger logger = LoggerFactory.getLogger(EmployeeServiceImpl.class);
    private EmployeeRepository employeeRepository;
    //private RestTemplate restTemplate;
    private  WebClient webClient;

    private APIClient apiClient;

    @Override
    public EmployeeDTO saveEmployee(EmployeeDTO employeeDTO) {

        Optional<Employee> existingUser = employeeRepository.findEmployeeByEmail(employeeDTO.getEmail());

        if(existingUser.isPresent()){
            throw new EmailAlreadyExistException("Email already exist for Employee");
        }

        Optional<DepartmentDTO> departmentDTO = apiClient.findDepartmentByCode(employeeDTO.getDepartmentCode());

        if(!departmentDTO.isPresent()){
            throw new ResourceNotFoundException("Department", "departmentCode", employeeDTO.getDepartmentCode());
        }

        Employee employee = EmployeeMapper.mapToEmployee(employeeDTO);
        Employee savedEmployee = employeeRepository.save(employee);
        EmployeeDTO saveEmployeeDTO = EmployeeMapper.mapToEmployeeDTO(savedEmployee);

        return saveEmployeeDTO;
    }

    @Override
    //@CircuitBreaker(name="${spring.application.name}", fallbackMethod = "getDefaultDepartment")
    @Retry(name = "${spring.application.name}", fallbackMethod = "getDefaultDepartment")
    public ApiResponseDTO findEmployeeById(Long id) {

        logger.info("inside findEmployeeById() method");
        Employee employee = employeeRepository.findById(id).orElseThrow(
                () -> new ResourceNotFoundException("Employee", "id", String.valueOf(id))
        );

//        ResponseEntity<DepartmentDTO> responseEntity = restTemplate.getForEntity("http://localhost:8080/api/departments/" + employee.getDepartmentCode(),
//                DepartmentDTO.class);
//
//        DepartmentDTO departmentDTO = responseEntity.getBody();

        DepartmentDTO departmentDTO = webClient.get()
                .uri("http://localhost:8080/api/departments/" + employee.getDepartmentCode())
                .retrieve()
                .bodyToMono(DepartmentDTO.class)
                .block();

        //Optional<DepartmentDTO> departmentDTO = apiClient.findDepartmentByCode(employee.getDepartmentCode());


//        if(!departmentDTO.isPresent()){
//            throw new ResourceNotFoundException("Department", "departmentCode", employee.getDepartmentCode());
//        }

        OrganizationDto organizationDto = webClient.get()
                .uri("http://localhost:8083/api/organizations/"+employee.getOrganizationCode())
                .retrieve()
                .bodyToMono(OrganizationDto.class)
                .block();


        EmployeeDTO existingEmployee = EmployeeMapper.mapToEmployeeDTO(employee);

        ApiResponseDTO apiResponseDTO = new ApiResponseDTO();
        apiResponseDTO.setEmployee(existingEmployee);
       // apiResponseDTO.setDepartmentDTO(departmentDTO.get());
        apiResponseDTO.setDepartment(departmentDTO);
        apiResponseDTO.setOrganization(organizationDto);

        return apiResponseDTO;
    }

    public ApiResponseDTO getDefaultDepartment(Long employeeId, Exception exception) {

        logger.info("inside getDefaultDepartment() method");
        Employee employee = employeeRepository.findById(employeeId).orElseThrow(
                () -> new ResourceNotFoundException("Employee", "id", String.valueOf(employeeId))
        );

        // Creating default value of Department
        DepartmentDTO departmentDTO = new DepartmentDTO();
        departmentDTO.setDepartmentName("R&D Department");
        departmentDTO.setDepartmentCode("RD0001");
        departmentDTO.setDepartmentDescription("Research And Development Department");


        EmployeeDTO existingEmployee = EmployeeMapper.mapToEmployeeDTO(employee);

        ApiResponseDTO apiResponseDTO = new ApiResponseDTO();
        apiResponseDTO.setEmployee(existingEmployee);
        // apiResponseDTO.setDepartmentDTO(departmentDTO.get());
        apiResponseDTO.setDepartment(departmentDTO);

        return apiResponseDTO;
    }

}
