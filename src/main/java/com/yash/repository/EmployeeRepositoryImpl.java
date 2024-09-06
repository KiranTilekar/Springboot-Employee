package com.yash.repository;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestParam;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

import com.yash.model.Employee;

@Repository
public class EmployeeRepositoryImpl implements EmployeeRepository {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<Employee> getAllEmployees() {
        return entityManager.createQuery("SELECT e FROM Employee e", Employee.class).getResultList();
    }

	@Override
	public List<Employee> getEmployees(String name, int id, String department, Double minSalary, Double maxSalary) {
        
        List<Employee> allEmployees = getAllEmployees();
        List<Employee> filteredEmployees = new ArrayList(); 
        
        System.out.println("id: " + id);
        System.out.println("name: " + name);
        System.out.println("dept: " + department);
        System.out.println("mins: " + minSalary);
        System.out.println("maxs: " + maxSalary);
        
        
        
        for(Employee e: allEmployees) {
        	
        	System.out.println("Name@@: " + e.getName());
        	System.out.println("Id@@: " + e.getId());
        	
        	if(e.getId() == id && e.getName().equals(name)) {
        		System.out.println("match found!!!");
        		filteredEmployees.add(e);
        	}
        }
        
        for(Employee e: filteredEmployees) {
        	System.out.println("yesss@@: " + e.getName());
        	System.out.println("yesss@@: " + e.getId());
        }

        
        return filteredEmployees;
    }

    
}
