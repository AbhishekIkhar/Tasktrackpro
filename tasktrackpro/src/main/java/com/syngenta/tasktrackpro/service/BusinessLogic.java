package com.syngenta.tasktrackpro.service;

import java.util.List;

import com.syngenta.tasktrackpro.entity.Employee;

public interface BusinessLogic {
   public void addEmployee(Employee emp);
   public List<Employee> getALLEmployee();
   public Employee getEmployee(Integer employeeId);
   public Employee deleteByID(Integer employeeId);
   public Employee updateEmployee(Employee employee);
}
