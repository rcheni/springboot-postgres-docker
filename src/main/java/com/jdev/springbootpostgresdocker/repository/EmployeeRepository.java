package com.jdev.springbootpostgresdocker.repository;

import com.jdev.springbootpostgresdocker.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
}
