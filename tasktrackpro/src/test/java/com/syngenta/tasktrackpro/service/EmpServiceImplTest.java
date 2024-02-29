package com.syngenta.tasktrackpro.service;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.List;
import java.util.Optional;

import org.checkerframework.checker.nullness.qual.Nullable;
import org.hibernate.query.criteria.internal.expression.SearchedCaseExpression.WhenClause;
import org.junit.After;
import org.junit.Before;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;

import com.syngenta.tasktrackpro.dto.EmpDTO;
import com.syngenta.tasktrackpro.entity.Employee;
import com.syngenta.tasktrackpro.exception.EmployeeNotFound;
import com.syngenta.tasktrackpro.repository.EmpRepository;

class EmpServiceImplTest {
	
	@Autowired
	@Mock
	private EmpRepository empRepository;
	private EmpService empService;
	AutoCloseable autoCloseable;
	EmpDTO empDTO,empDTO2;
	Employee empEntity,empEntity2;

	@BeforeEach
	void setUp() throws Exception {
		//empService=new EmpServiceImpl(null, empRepository);
		//employee=new Employee("Rajesh","rajesh@gmail.com","IT Support",9876521213L);
		//EmpDTO empDTO=EmpDTO.builder().contact(employee.getContact()).dept(employee.getDept()).name(employee.getName()).email(employee.getEmail())
		//.build();
		autoCloseable= MockitoAnnotations.openMocks(this);
		empService=new EmpServiceImpl(empRepository);
		empDTO = new EmpDTO("John", "john@gmail.com", "IT",9998887776665L );
		empEntity=new Employee("John", "john@gmail.com", "IT",9998887776665L );
		empDTO2=new EmpDTO("Raj", "raj@gmail.com", "HR", 9321456721L);
		empEntity2=new Employee("Raj", "raj@gmail.com", "HR", 9321456721L);
		
	}

	@AfterEach
	void tearDown() throws Exception {
		autoCloseable.close();
	}

	@Test
	void testAddEmployee() {

        when(empRepository.save(empEntity)).thenReturn(empEntity);        
        EmpDTO resultDTO = empService.addEmployee(empDTO);
        
        assertNotNull(resultDTO);
        assertEquals(empDTO.getContact(), resultDTO.getContact());
        assertEquals(empDTO.getName(), resultDTO.getName());
        assertEquals(empDTO.getEmail(), resultDTO.getEmail());
        assertEquals(empDTO.getDept(), resultDTO.getDept());
        
        verify(empRepository).save(empEntity);
        
	}
	
	@Test
	void testGetAllEmployees()
	{
		
        when(empRepository.save(empEntity)).thenReturn(empEntity);
        when(empRepository.save(empEntity2)).thenReturn(empEntity2);
        when(empRepository.findAll()).thenReturn(List.of(empEntity,empEntity2));
        
        List<EmpDTO>resultDtos=empService.getEmployees();
        
        assertNotNull(resultDtos.get(0));
        assertNotNull(resultDtos.get(1));
        assertEquals(resultDtos.get(0).getName(), empEntity.getName());
        assertEquals(resultDtos.get(0).getEmail(), empEntity.getEmail());
        assertEquals(resultDtos.get(0).getContact(), empEntity.getContact());
        assertEquals(resultDtos.get(1).getName(), empEntity2.getName());
        assertEquals(resultDtos.get(1).getEmail(), empEntity2.getEmail());
        assertEquals(resultDtos.get(1).getContact(), empEntity2.getContact());
        
	}
	
	@Test
	void testGetByIdSuccess()
	{
        when(empRepository.save(empEntity)).thenReturn(empEntity);
      
        when(empRepository.save(empEntity2)).thenReturn(empEntity2);
        when(empRepository.findById(2)).thenReturn(Optional.ofNullable(empEntity2));
        
        EmpDTO result=empService.getEmployeeById(2);
        
        assertNotNull(result);
        assertEquals(empEntity2.getDept(), result.getDept());
        assertEquals(empEntity2.getEmail(), result.getEmail());
        assertEquals(empEntity2.getName(), result.getName());
        assertEquals(empEntity2.getContact(), result.getContact());
           
	}
	
	@Test
	void testGetByIdFailure()
	{
        when(empRepository.save(empEntity)).thenReturn(empEntity);
      
        when(empRepository.save(empEntity2)).thenReturn(empEntity2);
        int id=12;
        when(empRepository.findById(id)).thenReturn(Optional.empty());
        
        
       assertThrows(EmployeeNotFound.class, ()->{empService.getEmployeeById(12);}  , "Employee with id "+id+" not found");        

	}
	
	@Test
	void testUpdateByIdSuccess()
	{
		when(empRepository.save(empEntity)).thenReturn(empEntity);
		when(empRepository.findById(1)).thenReturn(Optional.ofNullable(empEntity));
		empEntity.setEmail("john42@gmail.com");
		
		when(empRepository.save(empEntity)).thenReturn(empEntity);
		empDTO.setEmail(empEntity.getEmail());
		
		EmpDTO resEmpDTO =empService.updateEmployee(1, empDTO);
		
		assertNotNull(resEmpDTO);
		assertEquals(empDTO.getEmail(), resEmpDTO.getEmail());
		
		
	}
}

