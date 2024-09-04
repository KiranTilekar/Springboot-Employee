package com.yash.service;

import org.springframework.stereotype.Service;

import com.yash.model.Employee;
import java.util.List;

@Service
public interface EmployeeService {
	
	public List<Employee> getAllEmployees();

	public List<Employee> getEmployees(String name,int id,String department,double minSalary,double maxSalary);
}
