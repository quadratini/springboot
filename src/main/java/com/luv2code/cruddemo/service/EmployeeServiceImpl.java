package com.luv2code.cruddemo.service;

import com.luv2code.cruddemo.dao.EmployeeDAO;
import com.luv2code.cruddemo.dao.EmployeeRepository;
import com.luv2code.cruddemo.entity.Employee;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    // method 1, manually create all CRUD methods by using custom DAO
    // private EmployeeDAO employeeDAO;

    // method 2, use Repository, which has a package of methods, so no need to create
    // custom DAO's
    private EmployeeRepository employeeRepository;

    @Autowired
    public EmployeeServiceImpl(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    @Override
    public List<Employee> findAll() {
        return employeeRepository.findAll();
    }

    @Override
    public Employee findById(int id) {
        Optional<Employee> result = employeeRepository.findById(id);

        Employee employee = null;

        if (result.isPresent()) {
            employee = result.get();
        } else {
            // we didn't find the employee
            throw new RuntimeException("Did not find employee id - " + id);
        }
        return employee;
    }

    //    @Transactional
    //    No need transactional since jpaRepository provides this functionality
    @Override
    public Employee save(Employee employee) {
        return employeeRepository.save(employee);
    }

    //    @Transactional
    @Override
    public void deleteById(int id) {
        employeeRepository.deleteById(id);
    }
}
