package com.yash.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yash.model.Employee;
import com.yash.repository.EmployeeRepository;
import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService{
	
	private final EmployeeRepository employeeRepository;
	
    @Autowired
    public EmployeeServiceImpl(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }
	
    @Override
	public List<Employee> getAllEmployees(){
		return employeeRepository.getAllEmployees();
	}
}
