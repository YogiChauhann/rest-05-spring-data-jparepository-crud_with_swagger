package com.spring_data.service;

import java.util.List;

import com.spring_data.entity.Employee;

public interface EmployeeService {
	
	public List<Employee> findAll();
	
    public Employee findById(int employeeId);
	
	public void saveEmp(Employee theEmployee);
	
	public void deleteEmp(int theIdyogi);

}
