package com.syngenta.tasktrackpro.service;

import java.security.PublicKey;
import java.util.List;

import com.syngenta.tasktrackpro.dto.EmpDTO;
//import com.example.demo.entities.Course;
import com.syngenta.tasktrackpro.entity.Employee;

public interface EmpService {
public List<EmpDTO> getEmployees();
public EmpDTO getEmployeeById(int id);

public void deleteEmp(int id);
public EmpDTO updateEmployee(int id,EmpDTO e);
public EmpDTO addEmployee(EmpDTO e);
EmpDTO updateEmployee(EmpDTO e);

public List<EmpDTO> getEmployeesByName(String name);

public List<EmpDTO> getEmployeesByNameOrId(String name,int id);
}
