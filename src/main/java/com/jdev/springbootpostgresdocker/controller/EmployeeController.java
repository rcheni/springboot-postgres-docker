package com.jdev.springbootpostgresdocker.controller;

import com.jdev.springbootpostgresdocker.exception.ResourceNotFoundException;
import com.jdev.springbootpostgresdocker.model.Employee;
import com.jdev.springbootpostgresdocker.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class EmployeeController {
    @Autowired
    private EmployeeRepository employeeRepository;

    @PostMapping("/employees")
    public Employee addEmployee(@RequestBody Employee employee) {
        return employeeRepository.save(employee);
    }

    @GetMapping("/employees")
    public ResponseEntity<List<Employee>> findAll() {
        return ResponseEntity.ok(employeeRepository.findAll());
    }

    @GetMapping("/employees/{id}")
    public ResponseEntity<Employee> findEmployeeById(@PathVariable(name = "id") Integer id) {
        Employee employee = employeeRepository.findById(id).orElseThrow(
                () -> new ResourceNotFoundException("Employee not found by Id : " + id)
        );

        return ResponseEntity.ok().body(employee);
    }

    @DeleteMapping("/employees/{id}")
    public ResponseEntity<Void>  deleteEmployee(@PathVariable(name = "id") Integer id) {
        Employee employee = employeeRepository.findById(id).orElseThrow(
                () -> new ResourceNotFoundException("Employee not found by Id : " + id)
        );

        employeeRepository.delete(employee);

        return ResponseEntity.ok().build();
    }
}
