package com.syngenta.tasktrackpro.controller;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;

import com.syngenta.tasktrackpro.dto.EmployeeDto;
import com.syngenta.tasktrackpro.models.Employee;


@RequestMapping("/api/v1")
public interface EmployeeController {
	
	@PostMapping("/create")
	public  void addEmployee(@RequestBody Employee emp) ;
	
	@GetMapping("/employees")
	public List<EmployeeDto> getALLEmployee() ;
    
	@GetMapping("/{employeeId}")
	public EmployeeDto getEmployee(@PathVariable Integer employeeId);
	
	@DeleteMapping("/{employeeId}")
	public void deleteByID(@PathVariable Integer employeeId);
    
	@PutMapping("/update")
	public EmployeeDto updateEmployee(@RequestBody EmployeeDto emp);
}
