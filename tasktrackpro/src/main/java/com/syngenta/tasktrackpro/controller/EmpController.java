package com.syngenta.tasktrackpro.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.syngenta.tasktrackpro.entity.Employee;
import com.syngenta.tasktrackpro.service.EmpService;

@RestController
public class EmpController {

	@Autowired
	private EmpService empService;
	
	@GetMapping("/employees")
	public List<Employee> getEmployees()
	{
		return empService.getEmployees();
	}
	
	@GetMapping("/employees/{id}")
	public Employee getEmployeeById(@PathVariable String id)
	{
		return empService.getEmployeeById(Integer.parseInt(id));
	}
	
	@PostMapping("/employees")
	public Employee addEmployee(@RequestBody Employee e)
	{
		return empService.addEmployee(e);
	}
	
	@DeleteMapping("/employees/{id}")
	public void deleteEmployee(@PathVariable String id)
	{
		empService.deleteEmp(Integer.parseInt(id));
	}
	
	@PutMapping("/employees")
	public Employee updateEmployee(@RequestBody Employee e)
	{
		return empService.updateEmployee(e);
	}
}
