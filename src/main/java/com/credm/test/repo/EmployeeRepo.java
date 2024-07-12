package com.credm.test.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.credm.test.models.Employee;


public interface EmployeeRepo extends JpaRepository<Employee, Long> {

}

