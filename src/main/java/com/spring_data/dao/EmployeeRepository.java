package com.spring_data.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.spring_data.entity.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

}
