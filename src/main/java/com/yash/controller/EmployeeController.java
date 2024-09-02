package com.yash.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.yash.model.Employee;
import com.yash.service.EmployeeService;
import java.util.List;

@RestController
//@RequestMapping("/")
public class EmployeeController {

//	@CrossOrigin(origins = "http://localhost:4200")
//    @GetMapping("/")
//    public String loginpage() {
//        return "Welcome to the login page!";
//    }
    
    
//    public ResponseEntity<String> loginpage() {
//        return ResponseEntity.ok("{\"message\": \"List of Trainings\"}");
//	}
	
	private final EmployeeService employeeService;

    @Autowired
    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }
    
    @CrossOrigin(origins = "http://localhost:4200")
    @GetMapping
    public ResponseEntity<List<Employee>> getAllEmployees() {
        List<Employee> employees = employeeService.getAllEmployees();
        System.out.println(employees);
        return ResponseEntity.ok(employees);
    }
    
    public ResponseEntity<List<Employee>> getAllEmployees(String name) {
        List<Employee> employees = employeeService.getAllEmployees();
        System.out.println(employees);
        System.out.println("lable1");
        return ResponseEntity.ok(employees);
    	
    }
	
}