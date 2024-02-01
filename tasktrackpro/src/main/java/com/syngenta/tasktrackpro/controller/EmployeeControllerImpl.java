package com.syngenta.tasktrackpro.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.syngenta.tasktrackpro.dto.EmployeeDto;
import com.syngenta.tasktrackpro.models.Employee;
import com.syngenta.tasktrackpro.service.BusinessLogic;



@RequestMapping("/employee")
@RestController
public class EmployeeControllerImpl implements EmployeeController {

	
	private final BusinessLogic blogic;
	
	@Autowired
	public EmployeeControllerImpl(BusinessLogic blogic) {
		this.blogic = blogic;
	}
	
	@Override
	public  void addEmployee(Employee emp) {
		blogic.addEmployee(emp);
	}
	
	
	@Override
	public List<EmployeeDto> getALLEmployee() {
		return blogic.getALLEmployee();
	}
    
	@Override
	public EmployeeDto getEmployee(Integer employeeId) {
		return blogic.getEmployee(employeeId);
	}
	
	@Override
	public void deleteByID(Integer employeeId) {
		blogic.deleteByID(employeeId);
	}
    
	@Override
	public EmployeeDto updateEmployee(EmployeeDto emp) {
		blogic.updateEmployee(emp);
		return emp;
	}
	
}

/*
  TODO:
  1. entity obj should not be exposes make dto class
  2. Use constructor injection instead of field in autowire
  3. In DB all column , table and everything in lower case.
  4. Make interface for the controller 
  5. return type should not be entity it should be dto. Either [Can return in response entity ] 
  6. Use try-catch, customize exception and default where there is possibility of error 
  7. Profile --> [ how to use , what is , why to use ] --[ it use to provide enivornment] 
  
  https://docs.spring.io/spring-boot/docs/1.2.0.M1/reference/html/boot-features-profiles.html
  
  8. Junit for this project 
  9.  SONAR is remaining 
 */
