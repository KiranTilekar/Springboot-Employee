package com.yash.repository;

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
	public List<Employee> getEmployees(
            @RequestParam(required = false) String name,
            @RequestParam(required = false) int id,
            @RequestParam(required = false) String department,
            @RequestParam(required = false) Double minSalary,
            @RequestParam(required = false) Double maxSalary) {
        
        List<Employee> employees = getAllEmployees();
        
        if (name != null && !name.isEmpty()) {
            employees = employees.stream()
                .filter(e -> e.getName().contains(name))
                .collect(Collectors.toList());
        }
        
        if (department != null && !department.isEmpty()) {
            employees = employees.stream()
                .filter(e -> e.getDepartment().contains(department))
                .collect(Collectors.toList());
        }
        
        if (minSalary != null) {
            employees = employees.stream()
                .filter(e -> e.getSalary().compareTo(minSalary) >= 0)
                .collect(Collectors.toList());
        }
        
        if (maxSalary != null) {
            employees = employees.stream()
                .filter(e -> e.getSalary().compareTo(maxSalary) <= 0)
                .collect(Collectors.toList());
        }
        
        return employees;
    }

    
}
