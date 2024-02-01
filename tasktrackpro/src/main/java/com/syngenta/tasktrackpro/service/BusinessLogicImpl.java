package com.syngenta.tasktrackpro.service;

import java.util.*;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

//import com.google.common.base.Optional;
import com.syngenta.tasktrackpro.dto.EmployeeDto;
import com.syngenta.tasktrackpro.models.Employee;
import com.syngenta.tasktrackpro.repository.EmployeeRepository;

@Service
public class BusinessLogicImpl implements BusinessLogic {

	private EmployeeRepository empRepo;
	private ModelMapper modelMapper;

	@Autowired
	public BusinessLogicImpl(EmployeeRepository empRepo, ModelMapper modelMapper) {
		this.empRepo = empRepo;
		this.modelMapper = modelMapper;
	}

	@Override
	public void addEmployee(Employee emp) {
		empRepo.save(emp);
	}

	@Override
	public List<EmployeeDto> getALLEmployee() {

		return empRepo.findAll().stream().map(this::convertEntitytoDto).collect(Collectors.toList());
//		return empRepo.getAllEmployee().stream().map(this::convertEntitytoDto).collect(Collectors.toList());
	}

	@Override
	public EmployeeDto getEmployee(Integer employeeId) {
		return convertEntitytoDto(empRepo.findById(employeeId).get());
	}

	@Override
	public void deleteByID(Integer employeeId) {
		empRepo.deleteById(employeeId);

	}

	@Override
	public EmployeeDto updateEmployee(EmployeeDto dto) {
		System.out.println("Work till level 0");
		if (dto.getId() == null)
			return dto;
		System.out.println("Work till level 1");
		
		
		// TODO:  Using Optional here 
		// TODO : Optimize the code 
		
			System.out.println("Work till level 2");
			Optional<Employee> optEmp = empRepo.findById(dto.getId());
			
			if(optEmp.isPresent()) {
				
				Employee employee = optEmp.get();
				
				employee.setContactNumber(dto.getContactNumber());
				employee.setEmail(dto.getEmail());
				employee.setName(dto.getName());
				employee.setPassword(dto.getPassword());
				
				empRepo.save(employee);
//				ResponseEntity<>
				
			}
			else {
				   // TODO: if id is not present then throw error in proper way.
				// ResponseEntity<>
			}
			
		
           return null;
			// 
		
		
//		System.out.println("Work till level 3");

//		return convertEntitytoDto(empRepo.save(convertDtotoEntity(dto)));
	}

	// TODO : Remove
	private EmployeeDto convertEntitytoDto(Employee emp) {
		if (emp == null) {
			System.out.println("Employee is null ");
			return null;
		}
  
		
		EmployeeDto dto = new EmployeeDto();
		
		// We use to convert json to entity or entityDTO
		modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.LOOSE);
		dto = modelMapper.map(emp, EmployeeDto.class);

		return dto;
	}

	private Employee convertDtotoEntity(EmployeeDto dto) {
		Employee emp = new Employee();

		modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.LOOSE);

		emp = modelMapper.map(dto, Employee.class);

		return emp;
	}

}
