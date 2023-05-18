package com.hb.springboot.springboottest.repository;

import com.hb.springboot.springboottest.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {
    Optional<Employee> findByEmail(String email);

    // define custom query using JPQL with index param
    @Query("select e from Employee e where e.firstName = ?1 and e.lastName = ?2")
    Employee findByJPQL(String firstName, String lastName);

    // define custom query using JPQL with named param
    @Query("select e from Employee e where e.firstName = :firstName and e.lastName = :lastName")
    Employee findByJPQLWithNamedParam(@Param("firstName") String firstName, @Param("lastName") String lastName);

    // define custom query using native SQL with index param
    @Query(value = "select * from Employee e where e.first_name = ?1 and e.last_name = ?2", nativeQuery = true)
    Employee findEmployeeByNativeSQL(String firstName, String lastName);

    // define custom query using native SQL with named param
    @Query(value = "select * from Employee e where e.first_name = :firstName and e.last_name = :lastName", nativeQuery = true)
    Employee findEmployeeByNativeSQLWithNamedParam(String firstName, String lastName);
}
