package com.yash.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.yash.model.Employee;
import com.yash.service.EmployeeService;
import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
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
    
    @GetMapping("/")
    public ResponseEntity<List<Employee>> getAllEmployees() {
    	System.out.println("lable1");
        List<Employee> employees = employeeService.getAllEmployees();
        System.out.println(employees);
        return ResponseEntity.ok(employees);
    }
    
    @GetMapping("/search")
    public ResponseEntity<List<Employee>> getEmployees(
            @RequestParam(required = false) String name,
            @RequestParam(required = false) Integer id,
            @RequestParam(required = false) String department,
            @RequestParam(required = false) Double minSalary,
            @RequestParam(required = false) Double maxSalary) {
    	
    	System.out.println("inside /search get");
    	System.out.println(id);
        List<Employee> employees = employeeService.getEmployees(name, id, department, minSalary, maxSalary);
        
        return ResponseEntity.ok(employees);
    }
    
    @GetMapping("/users/{id}")
    public String getUser(@RequestParam Long id) {
        System.out.println("id: " + id);
        return "working";
    }
    
    @GetMapping("/users")
    public String getUser() {
        System.out.println("working");
        return "working";
    }

}