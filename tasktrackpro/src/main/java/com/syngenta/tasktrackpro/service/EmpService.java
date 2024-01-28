package com.syngenta.tasktrackpro.service;

import java.security.PublicKey;
import java.util.List;

//import com.example.demo.entities.Course;
import com.syngenta.tasktrackpro.entity.Employee;

public interface EmpService {
public List<Employee> getEmployees();
public Employee getEmployeeById(int id);

public void deleteEmp(int id);
public Employee updateEmployee(Employee e);
public Employee addEmployee(Employee e);
}
