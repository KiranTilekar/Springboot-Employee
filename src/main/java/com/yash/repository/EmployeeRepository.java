package com.yash.repository;

import com.yash.model.Employee;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository{

	List<Employee> getAllEmployees();

	List<Employee> getEmployees(String name, int id, String department, Double minSalary, Double maxSalary);
}