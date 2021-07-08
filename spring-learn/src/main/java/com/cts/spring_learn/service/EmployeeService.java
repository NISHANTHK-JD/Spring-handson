package com.cts.spring_learn.service;

import java.util.ArrayList;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cts.Employee;
import com.cts.spring_learn.dao.EmployeeDao;
import com.cts.spring_learn.service.exception.EmployeeNotFoundException;

@Service
public class EmployeeService {

	@Autowired 
	private EmployeeDao employeeDao;
	
	
	public ArrayList<Employee> getAllEmployees()
	{
		return employeeDao.getAllEmployees();
	}
	
	public Employee getEmployeeById(int id) throws EmployeeNotFoundException 
	{
		return employeeDao.getEmployeeById(id);
	}
	
	public void updateEmployee(int id, @Valid Employee employee) throws EmployeeNotFoundException
	{
		employeeDao.updateEmployee(id, employee);
	}
	
	public ArrayList<Employee> deleteEmployee(int id) throws EmployeeNotFoundException
	{
		return employeeDao.deleteEmployee(id);
	}
	
	
}
