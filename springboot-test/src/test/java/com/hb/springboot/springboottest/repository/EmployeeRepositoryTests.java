package com.hb.springboot.springboottest.repository;

import com.hb.springboot.springboottest.model.Employee;
//import org.assertj.core.api.Assertions;
import static org.assertj.core.api.Assertions.assertThat;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.List;

@DataJpaTest
public class EmployeeRepositoryTests {

    @Autowired
    private EmployeeRepository employeeRepository;

    // JUnit test for save employee operation
    @DisplayName("JUnit test for save employee operation")
    @Test
    public void givenEmployeeObject_whenSave_thenReturnSavedEmployee(){

        // given - pre-condition or setup
        Employee employee = Employee.builder()
                .firstName("Hrishabh")
                .lastName("Kumar")
                .email("hrishabh@gmail.com")
                .build();

        // when - action or behaviour that we are going to test
        Employee savedEmployee = employeeRepository.save(employee);

        // then - verify the output

        //Assertions.assertThat(savedEmployee).isNotNull();
        //Assertions.assertThat(savedEmployee.getId()).isGreaterThan(0);

        // instead of using Static class name everytime we can use static import - Line 5
        assertThat(savedEmployee).isNotNull();
        assertThat(savedEmployee.getId()).isGreaterThan(0);
    }

    // JUnit Test for get all employee operation
    @DisplayName("JUnit Test for get all employee operation")
    @Test
    public void givenEmployeeList_whenFindAll_thenReturnEmployeeList(){

        // given - pre-condition or setup
        Employee employee1 = Employee.builder()
                .firstName("John")
                .lastName("Wick")
                .email("hrishabh@gmail.com")
                .build();

        Employee employee2 = Employee.builder()
                .firstName("Mat")
                .lastName("Blue")
                .email("hrishabh@gmail.com")
                .build();

        Employee employee3 = Employee.builder()
                .firstName("Bruce")
                .lastName("Waine")
                .email("hrishabh@gmail.com")
                .build();

        Employee savedEmployee1 = employeeRepository.save(employee1);
        Employee savedEmployee2 = employeeRepository.save(employee2);
        Employee savedEmployee3 = employeeRepository.save(employee3);

        // when - action or behaviour that we are going to test
        List<Employee> employeeList = employeeRepository.findAll();

        // then - verify the output
        assertThat(employeeList).isNotNull();
        assertThat(employeeList.size()).isEqualTo(3);
    }

    // JUnit Test for get Employee by Id operation
    @DisplayName("JUnit Test for get Employee by Id operation")
    @Test
    public void givenEmployeeObject_whenFindById_thenReturnEmployeeObject(){

        // given - pre-condition or setup
        Employee employee = Employee.builder()
                .firstName("John")
                .lastName("Wick")
                .email("hrishabh@gmail.com")
                .build();


        employeeRepository.save(employee);

        // when - action or behaviour that we are going to test
        Employee employeeFromDB = employeeRepository.findById(employee.getId()).get();

        // then - verify the output
        assertThat(employeeFromDB).isNotNull();
    }

    // JUnit Test to find Employee by Email operation
    @DisplayName("JUnit Test to find Employee by Email operation")
    @Test
    public void givenEmployeeEmail_whenFindByEmail_thenReturnEmployeeObject(){

        // given - pre-condition or setup
        Employee employee = Employee.builder()
                .firstName("John")
                .lastName("Wick")
                .email("hrishabh@gmail.com")
                .build();

        employeeRepository.save(employee);

        // when - action or behaviour that we are going to test
        Employee employeeFromDB = employeeRepository.findByEmail(employee.getEmail()).get();

        // then - verify the output
        assertThat(employeeFromDB).isNotNull();
        assertThat(employeeFromDB.getEmail()).isEqualTo(employee.getEmail());
    }
}
