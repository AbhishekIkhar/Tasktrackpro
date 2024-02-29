package com.syngenta.tasktrackpro.controller;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import com.syngenta.tasktrackpro.dto.EmpDTO;
import com.syngenta.tasktrackpro.exception.EmployeeNotFound;
import com.syngenta.tasktrackpro.exception.ErrorObject;

public interface EmpControllerInterface {

	@GetMapping("/employees")
	public List<EmpDTO> getEmployees();

	@GetMapping("/{id}")
	public EmpDTO getEmployeeById(String id);

	//public List<EmpDTO> getEmployeesByName(String name);
	
	@ExceptionHandler
	public ResponseEntity<ErrorObject> handleException(EmployeeNotFound e) ;
	
	@ExceptionHandler
	public ResponseEntity<ErrorObject> handleException(NumberFormatException e);
	
	
	
	
	@PostMapping("/create")
	public EmpDTO addEmployee(EmpDTO e);

	@DeleteMapping("/{id}")
	public ResponseEntity<String> deleteEmployee(@PathVariable String id);
	
	@PutMapping("/update/{id}")
	public EmpDTO updateEmployee(@PathVariable String id, @RequestBody EmpDTO e);
	
	@GetMapping("/get")
	public List<EmpDTO> getEmployeesByNameOrId(@RequestParam(required = false) String name,
			@RequestParam(required = false) Integer id) ;
	
	
	@GetMapping("/getByContactList")
	public List<EmpDTO> getEmployeesByContact(List<Long>contacts);

	//List<EmpDTO> getEmployeesByNameOrId(String name, int id);

	
	
	
}
