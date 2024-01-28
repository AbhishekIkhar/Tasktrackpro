package com.syngenta.tasktrackpro.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.syngenta.tasktrackpro.dao.EmployeeRepository;
import com.syngenta.tasktrackpro.entity.Employee;

@Service
public class BusinessLogicImpl implements BusinessLogic {

	@Autowired
	private EmployeeRepository empRepo;
	
	@Override
	public void addEmployee(Employee emp) {
		empRepo.save(emp);
	}

	@Override
	public List<Employee> getALLEmployee() {
		
		return empRepo.findAll();
	}

	@Override
	public Employee getEmployee(Integer employeeId) {
		return empRepo.findById(employeeId).get();
	}

	@Override
	public Employee deleteByID(Integer employeeId) {
		
		Employee emp = empRepo.findById(employeeId).orElseGet(()->null);
		empRepo.deleteById(employeeId);
		
		return emp;
	}

	@Override
	public Employee updateEmployee(Employee employee) {
		empRepo.save(employee);
		return employee;
	}
   
}
