package com.kiran.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.kiran.model.Employee;

@RestController
public class EmployeeController {

	@RequestMapping(value="/employee",method=RequestMethod.GET)
	public Employee getEmployee(){
		Employee emp = new Employee();
		emp.setEmpId("1");
		emp.setName("Employee 1");
		emp.setDesignation("Engineer");
		emp.setSalary(100000.0);
		return emp;
	}
	
}
