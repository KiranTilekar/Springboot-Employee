package com.yash.repository;

import com.yash.model.Employee;
import java.util.List;

public interface EmployeeRepository {

	List<Employee> getAllEmployees();
}