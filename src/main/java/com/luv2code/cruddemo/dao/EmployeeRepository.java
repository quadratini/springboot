package com.luv2code.cruddemo.dao;

import com.luv2code.cruddemo.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.List;

// sets the path to be /members instead of /employees
// @RepositoryRestResource(path = "members")
public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
    // that's it... no need to write any code LOL!! HAHA. I love it

    // Spring Data JPA will create a query behind the scenes for us based on method name
    // MAGIC https://docs.spring.io/spring-data/jpa/docs/current/reference/html/#repositories.query-methods.details
    public List<Employee> findAllByOrderByLastNameAsc();
}
