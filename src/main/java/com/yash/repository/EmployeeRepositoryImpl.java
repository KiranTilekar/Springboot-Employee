package com.yash.repository;

import java.util.List;

import org.springframework.stereotype.Repository;
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
}
