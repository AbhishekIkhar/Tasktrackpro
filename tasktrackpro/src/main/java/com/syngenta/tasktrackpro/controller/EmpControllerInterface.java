package com.syngenta.tasktrackpro.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import com.syngenta.tasktrackpro.dto.EmpDTO;
import com.syngenta.tasktrackpro.entity.Employee;

public interface EmpControllerInterface {

	public List<EmpDTO> getEmployees();

	public EmpDTO getEmployeeById(String id);

	public List<EmpDTO> getEmployeesByName(String name);
	
	public List<EmpDTO> getEmployeesByNameOrId(String name,int id);
	
	public EmpDTO addEmployee(EmpDTO e);

	public ResponseEntity<String> deleteEmployee(String id);

	public EmpDTO updateEmployee(String id, EmpDTO e);
}
