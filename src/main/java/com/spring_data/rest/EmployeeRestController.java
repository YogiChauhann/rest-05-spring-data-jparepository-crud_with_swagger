package com.spring_data.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import com.spring_data.entity.Employee;
import com.spring_data.service.EmployeeService;

@RestController
@RequestMapping("/api")
@CrossOrigin
public class EmployeeRestController {

	private EmployeeService employeeService;

	// inject employee service( use constructor injection)
	@Autowired
	public EmployeeRestController(EmployeeService theEmployeeService) {
		employeeService = theEmployeeService;
	}

	
	@GetMapping("/hello")
	public String hello() {
		return "helloWorld";
	}

	@GetMapping(path = "/hello-world-bean")
	public HelloWorldBean helloWorldBean() {
		return new HelloWorldBean("Hello World");
	}

	/// hello-world/path-variable/in28minutes
	@GetMapping(path = "/hello-world/path-variable/{name}")
	public HelloWorldBean helloWorldPathVariable(@PathVariable String name) {
		//throw new RuntimeException("Something went wrong");
		return new HelloWorldBean(String.format("Hello World, %s", name));
	}
	
	

	// expose "/employees" and return list of employees
	@CrossOrigin
	@GetMapping("/employees")
	public List<Employee> findAll() {
		return employeeService.findAll();
	}

	@GetMapping("/employees/{employeeId}")
	public Employee findById(@PathVariable int employeeId) {
		Employee theEmployee = employeeService.findById(employeeId);

		if (theEmployee == null) {
			throw new RuntimeException(">>>>>>>>>>>>>> employee id not found :" + employeeId);
		}

		return theEmployee;
	}

	@PostMapping("/employees")
	public Employee saveEmp(@RequestBody Employee theEmployee) {
		// also just in case they pass id in json .... set id to 0
		// this is force to save of new item.... instead of update
		theEmployee.setId(0);

		employeeService.saveEmp(theEmployee);

		return theEmployee;

	}

	@PutMapping("/employees")
	public Employee updateEmp(@RequestBody Employee theEmployee) {

		employeeService.saveEmp(theEmployee);

		return theEmployee;

	}

	@DeleteMapping("/employees/{employeeId}")
	public String deleteEmp(@PathVariable int employeeId) {

		Employee theEmployee = employeeService.findById(employeeId);

		if (theEmployee == null) {
			throw new RuntimeException(">>>>>>>>>>>>>> employee id not found :" + employeeId);
		}

		employeeService.deleteEmp(employeeId);

		return "Delete employee id: " + employeeId;
	}

}
