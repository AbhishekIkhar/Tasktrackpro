package com.syngenta.tasktrackpro.controller;

import java.lang.reflect.Method;
import java.util.List;

import org.aspectj.weaver.patterns.ThisOrTargetAnnotationPointcut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.syngenta.tasktrackpro.entity.Employee;
import com.syngenta.tasktrackpro.service.BusinessLogic;

@RestController
public class EmployeeController {

	
	@Autowired
	private BusinessLogic blogic;
	
	public EmployeeController() {
		super();
	}
	
	@PostMapping("/employee")
	public  Employee addEmployee(@RequestBody Employee emp) {
		this.blogic.addEmployee(emp);
		return emp;
	}
	
	
	@GetMapping("/employees")
	public List<Employee> getALLEmployee() {
		return this.blogic.getALLEmployee();
	}
    
	@GetMapping("employee/{employeeId}")
	public Employee getEmployee(@PathVariable String employeeId) {
		return this.blogic.getEmployee(Integer.parseInt(employeeId));
	}
	
	@DeleteMapping("employee/{employeeId}")
	public Employee deleteByID(@PathVariable String employeeId) {
		return this.blogic.deleteByID(Integer.parseInt(employeeId));
	}
    
	@PutMapping("/employee")
	public Employee updateEmployee(@RequestBody Employee employee) {
		this.blogic.updateEmployee(employee);
		return employee;
	}
	
}
