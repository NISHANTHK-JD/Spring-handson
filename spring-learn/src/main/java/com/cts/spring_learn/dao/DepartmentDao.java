package com.cts.spring_learn.dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;

import com.cts.Department;


@Component
public class DepartmentDao {
	
	List<Department> departmentList;
	
	public DepartmentDao()
	{
		ApplicationContext context=new ClassPathXmlApplicationContext("department.xml");
		departmentList=context.getBean("departmentList",ArrayList.class);
	}

	public List<Department> getAllDepartments()
	{
		return departmentList;
	}

}
