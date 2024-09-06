package com.yash.model;

public class EmployeeForm {

    private int id;
    private String name;
    private String department;
    private Double salary;
    
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDepartment() {
		return department;
	}
	public void setDepartment(String department) {
		this.department = department;
	}
	public Double getSalary() {
		return salary;
	}
	public void setSalary(Double salary) {
		this.salary = salary;
	}
	@Override
	public String toString() {
		return "EmployeeForm [id=" + id + ", name=" + name + ", department=" + department + ", salary=" + salary + "]";
	}
    
    
}
