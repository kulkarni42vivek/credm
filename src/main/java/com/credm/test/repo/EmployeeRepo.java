package com.credm.test.repo;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.credm.test.models.Employee;


public interface EmployeeRepo extends JpaRepository<Employee, Long> {

	 Optional<Employee> findByEmail(String email);

}

