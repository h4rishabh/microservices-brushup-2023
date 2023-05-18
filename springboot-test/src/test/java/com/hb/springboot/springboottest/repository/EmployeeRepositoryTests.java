package com.hb.springboot.springboottest.repository;

import com.hb.springboot.springboottest.model.Employee;
//import org.assertj.core.api.Assertions;
import static org.assertj.core.api.Assertions.assertThat;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.List;
import java.util.Optional;

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

    // JUnit Test for update employee operation
    @DisplayName("JUnit Test for update employee operation")
    @Test
    public void givenEmployeeObject_whenUpdateEmployeeDetails_thenReturnUpdatedEmployee(){

        // given - pre-condition or setup
        Employee employee = Employee.builder()
                .firstName("John")
                .lastName("Doe")
                .email("jd@gmail.com")
                .build();

        employeeRepository.save(employee);

        // when - action or behaviour that we are going to test
        Employee savedEmployee = employeeRepository.findById(employee.getId()).get();
        savedEmployee.setEmail("john@wick.com");
        savedEmployee.setLastName("Wick");

        Employee updatedEmployee = employeeRepository.save(savedEmployee);

        // then - verify the output
        assertThat(updatedEmployee.getEmail()).isEqualTo("john@wick.com");
        assertThat(updatedEmployee.getLastName()).isEqualTo("Wick");
    }

    // JUnit Test for delete employee operation
    @DisplayName("JUnit Test for delete employee operation")
    @Test
    public void givenEmployeeObject_whenDelete_thenRemoveEmployeeObject(){

        // given - pre-condition or setup
        Employee employee = Employee.builder()
                .firstName("John")
                .lastName("Doe")
                .email("jd@gmail.com")
                .build();

        employeeRepository.save(employee);

        // when - action or behaviour that we are going to test
        employeeRepository.delete(employee);
        Optional<Employee> employeeOptional = employeeRepository.findById(employee.getId());

        // then - verify the output
        assertThat(employeeOptional).isEmpty();
    }

    // JUnit Test for custom query using JPQL with index
    @DisplayName("JUnit Test for custom query using JPQL with index")
    @Test
    public void givenFirstNameAndLastName_whenFindByJPQL_thenReturnsEmployeeObject(){

        // given - pre-condition or setup
        Employee employee = Employee.builder()
                .firstName("John")
                .lastName("Doe")
                .email("jd@gmail.com")
                .build();

        employeeRepository.save(employee);
        String firstName = "John";
        String lastName = "Doe";

        // when - action or behaviour that we are going to test
        Employee savedEmployee = employeeRepository.findByJPQL(firstName, lastName);

        // then - verify the output
        assertThat(savedEmployee).isNotNull();
    }

    // JUnit Test for custom query using JPQL with named param
    @DisplayName("JUnit Test for custom query using JPQL with named param")
    @Test
    public void givenFirstNameAndLastName_whenFindByJPQLWithNamedParam_thenReturnsEmployeeObject(){

        // given - pre-condition or setup
        Employee employee = Employee.builder()
                .firstName("John")
                .lastName("Doe")
                .email("jd@gmail.com")
                .build();

        employeeRepository.save(employee);
        String firstName = "John";
        String lastName = "Doe";

        // when - action or behaviour that we are going to test
        Employee savedEmployee = employeeRepository.findByJPQLWithNamedParam(firstName, lastName);

        // then - verify the output
        assertThat(savedEmployee).isNotNull();
    }

    // JUnit Test for custom query using native SQL with index param
    @DisplayName("JUnit Test for custom query using native SQL with index param")
    @Test
    public void givenFirstNameAndLastName_whenFindByNativeSQL_thenReturnsEmployeeObject(){

        // given - pre-condition or setup
        Employee employee = Employee.builder()
                .firstName("John")
                .lastName("Doe")
                .email("jd@gmail.com")
                .build();

        employeeRepository.save(employee);
        //String firstName = "John";
        //String lastName = "Doe";

        // when - action or behaviour that we are going to test
        Employee savedEmployee = employeeRepository.findEmployeeByNativeSQL(employee.getFirstName(), employee.getLastName());

        // then - verify the output
        assertThat(savedEmployee).isNotNull();
    }

    // JUnit Test for custom query using native SQL with named param
    @DisplayName("JUnit Test for custom query using native SQL with named param")
    @Test
    public void givenFirstNameAndLastName_whenFindByNativeSQLWithNamedParam_thenReturnsEmployeeObject(){

        // given - pre-condition or setup
        Employee employee = Employee.builder()
                .firstName("John")
                .lastName("Doe")
                .email("jd@gmail.com")
                .build();

        employeeRepository.save(employee);
        //String firstName = "John";
        //String lastName = "Doe";

        // when - action or behaviour that we are going to test
        Employee savedEmployee = employeeRepository.findEmployeeByNativeSQLWithNamedParam(employee.getFirstName(), employee.getLastName());

        // then - verify the output
        assertThat(savedEmployee).isNotNull();
    }
}
