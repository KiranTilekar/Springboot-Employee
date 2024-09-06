package com.yash.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


import com.yash.model.Employee;
import com.yash.model.EmployeeForm;
import com.yash.service.EmployeeService;
import java.util.List;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/employee")
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
    
    @GetMapping("/search")
    public ResponseEntity<List<Employee>> getAllEmployees() {
    	System.out.println("lable1");
        List<Employee> employees = employeeService.getAllEmployees();
        return ResponseEntity.ok(employees);
    }
    
    @PostMapping("/search")
    public List<Employee> getEmployees(@RequestBody EmployeeForm employeeForm) {
    	
//    	System.out.println("name: " + name); 
//    	System.out.println("id: " + id);
//    	System.out.println("minSalary " + minSalary);
//    	
//    	System.out.println("inside /search get");
//    	System.out.println(id);

    	System.out.println(employeeForm);
    	
    	List<Employee> emps = employeeService.getEmployees(employeeForm.getName(), employeeForm.getId(), employeeForm.getDepartment(), 0, 30000);
    	System.out.println("working!!!!");
    	for(Employee e: emps) {
    		System.out.println("0=> " + e);
    	}
    	return emps;
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