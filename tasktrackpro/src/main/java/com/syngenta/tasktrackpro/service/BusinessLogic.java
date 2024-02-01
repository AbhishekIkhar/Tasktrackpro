package com.syngenta.tasktrackpro.service;

import java.util.List;

import com.syngenta.tasktrackpro.dto.EmployeeDto;
import com.syngenta.tasktrackpro.models.Employee;



public interface BusinessLogic {
   public void addEmployee(Employee emp);
   public List<EmployeeDto> getALLEmployee();
   public EmployeeDto getEmployee(Integer employeeId);
   public void deleteByID(Integer employeeId);
   public EmployeeDto updateEmployee(EmployeeDto emp);
}
