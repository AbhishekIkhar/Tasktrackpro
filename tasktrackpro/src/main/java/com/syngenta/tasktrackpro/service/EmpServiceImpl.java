package com.syngenta.tasktrackpro.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.syngenta.tasktrackpro.entity.Employee;
import com.syngenta.tasktrackpro.repository.EmpRepository;

@Service
public class EmpServiceImpl implements EmpService{

	@Autowired
	private EmpRepository empRepository;
	
	@Override
	public List<Employee> getEmployees() {
		// TODO Auto-generated method stub
		return empRepository.findAll();
	}

	@Override
	public Employee getEmployeeById(int id) {
		// TODO Auto-generated method stub
		return empRepository.findById(id).get();
	}

	@Override
	public Employee addEmployee(Employee e) {
		// TODO Auto-generated method stub
		return empRepository.save(e);
	}

	@Override
	public void deleteEmp(int id) {
		// TODO Auto-generated method stub
		empRepository.deleteById(id);
	}

	@Override
	public Employee updateEmployee(Employee e) {
		// TODO Auto-generated method stub
		return empRepository.save(e);
	}

}
