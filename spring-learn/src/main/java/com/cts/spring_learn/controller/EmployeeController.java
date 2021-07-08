package com.cts.spring_learn.controller;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.cts.Employee;
import com.cts.spring_learn.service.EmployeeService;
import com.cts.spring_learn.service.exception.EmployeeNotFoundException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@RestController
public class EmployeeController {

	private static final Logger LOGGER = LoggerFactory.getLogger(EmployeeController.class);
	
	@Autowired 
	private EmployeeService employeeService;
	
	@GetMapping("/employees")
	public List<Employee> getAllEmployees()
	{
		return employeeService.getAllEmployees();
	}
	
	@GetMapping(value = "/employees/{id}")
	public Employee getCountryByCode(@PathVariable("id") int id) throws EmployeeNotFoundException {
		LOGGER.info("Start");
		LOGGER.info("End");
		return employeeService.getEmployeeById(id);
	}
	@PutMapping("/employees/{id}")
	public void updateEmployee(@PathVariable("id") int id, @RequestBody @Valid Employee employee) throws EmployeeNotFoundException{
		LOGGER.info("Start");
		LOGGER.info("End");
		employeeService.updateEmployee(id, employee);
	}
	@DeleteMapping("employees/{id}")
	public ArrayList<Employee> deleteEmployee(@PathVariable("id") int id) throws EmployeeNotFoundException{
		LOGGER.info("Start");
		LOGGER.info("End");
		return employeeService.deleteEmployee(id);
	}
	
}
