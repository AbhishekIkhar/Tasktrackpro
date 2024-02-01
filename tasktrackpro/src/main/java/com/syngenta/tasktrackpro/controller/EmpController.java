package com.syngenta.tasktrackpro.controller;

import java.util.List;

import org.springframework.beans.TypeMismatchException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.syngenta.tasktrackpro.dto.EmpDTO;
import com.syngenta.tasktrackpro.entity.Employee;
import com.syngenta.tasktrackpro.exception.EmployeeNotFound;
import com.syngenta.tasktrackpro.exception.ErrorObject;
import com.syngenta.tasktrackpro.service.EmpService;

import io.swagger.models.Response;

@RequestMapping("/api/v1/employee")
@RestController
public class EmpController implements EmpControllerInterface {

	private EmpService empService;

	@Autowired
	public EmpController(EmpService empService) {
		this.empService = empService;
	}

	@GetMapping("/employees")
	public List<EmpDTO> getEmployees() {
		return empService.getEmployees();
	}

	@GetMapping("/{id}")
	public EmpDTO getEmployeeById(@PathVariable String id) {
		try {
			return empService.getEmployeeById(Integer.parseInt(id));
		} catch (NumberFormatException e) {
			// TODO: handle exception
			throw new NumberFormatException("Id is in integer format");
		}

	}

	@ExceptionHandler
	public ResponseEntity<ErrorObject> handleException(EmployeeNotFound e) {
		ErrorObject errorObject = new ErrorObject(HttpStatus.NOT_FOUND.value(), e.getMessage());
		return new ResponseEntity<ErrorObject>(errorObject, HttpStatus.NOT_FOUND);
	}

	@ExceptionHandler
	public ResponseEntity<ErrorObject> handleException(NumberFormatException e) {
		ErrorObject errorObject = new ErrorObject(HttpStatus.BAD_REQUEST.value(), e.getMessage());
		return new ResponseEntity<ErrorObject>(errorObject, HttpStatus.BAD_REQUEST);
	}

	@PostMapping("/create")
	public EmpDTO addEmployee(@RequestBody EmpDTO e) {
		return empService.addEmployee(e);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<String> deleteEmployee(@PathVariable String id) {
		try {
			empService.deleteEmp(Integer.parseInt(id));
			return new ResponseEntity<>("Employee is Deleted successfully",HttpStatus.OK);
		} catch (NumberFormatException e) {
			// TODO: handle exception
			throw new NumberFormatException("Id is in integer format");
		}
	}

	@PutMapping("/update/{id}")
	public EmpDTO updateEmployee(@PathVariable String id, @RequestBody EmpDTO e) {
		try {
			return empService.updateEmployee(Integer.parseInt(id), e);
		} catch (NumberFormatException ne) {
			// TODO: handle exception
			throw new NumberFormatException("Employee Id is in integer format");
		}

	}

	@Override
	@GetMapping("get/{name}")
	public List<EmpDTO> getEmployeesByName(@PathVariable String name) {
		// TODO Auto-generated method stub
		return empService.getEmployeesByName(name);
	}

	@Override
	@GetMapping("/get/{name}/{id}")
	public List<EmpDTO> getEmployeesByNameOrId(String name, int id) {
		// TODO Auto-generated method stub
		return empService.getEmployeesByNameOrId(name, id);
	}

}
