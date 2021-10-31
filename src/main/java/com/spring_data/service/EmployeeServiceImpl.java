package com.spring_data.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring_data.dao.EmployeeRepository;
import com.spring_data.entity.Employee;

@Service
public class EmployeeServiceImpl implements EmployeeService {

private EmployeeRepository employeeRepository;
	
	//  inject employee dao( use constructor injection)
    @Autowired
	public EmployeeServiceImpl(EmployeeRepository theEmployeeRepository) {
		employeeRepository = theEmployeeRepository;
	}
	
	@Override
	//@Transactional
	public List<Employee> findAll() {
		// TODO Auto-generated method stub
		return employeeRepository.findAll();
	}

	@Override
	//@Transactional
	public Employee findById(int employeeId) {
		// TODO Auto-generated method stub
		Optional<Employee> result = employeeRepository.findById(employeeId);
		
		Employee theEmployee = null;
		if (result.isPresent()) {
			theEmployee = result.get();
		}
		return theEmployee;
	}

	@Override
	//@Transactional
	public void saveEmp(Employee theEmployee) {
		employeeRepository.save(theEmployee);

	}

	@Override
	//@Transactional
	public void deleteEmp(int theIdyogixx) {
		employeeRepository.deleteById(theIdyogixx);

	}

}
