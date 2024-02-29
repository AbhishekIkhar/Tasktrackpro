package com.syngenta.tasktrackpro.repository;

import static org.assertj.core.api.Assertions.assertThat;
import static org.hamcrest.CoreMatchers.nullValue;
import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;

import com.syngenta.tasktrackpro.entity.Employee;

@SpringBootTest
class EmpRepositoryTest {
	
	@Autowired
	private EmpRepository empRepository;
	Employee employee;

	@BeforeEach
	void setUp() throws Exception {
		employee=new Employee("Rajesh","rajesh@gmail.com","IT Support",9876521213L);
		empRepository.save(employee);
	}

	@AfterEach
	void tearDown() throws Exception {
		empRepository.delete(employee);
		employee=null;
		
	}

	@Test
	void testFindByNameSuccess() {
		List<Employee>employees= empRepository.findByName("Rajesh");
		
		assertEquals(employees.get(0).getDept(), employee.getDept());
		assertEquals(employees.get(0).getEmail(), employee.getEmail());
		assertEquals(employees.get(0).getName(),employee.getName());
		
	}
	
	@Test
	void testFindByNameFailure()
	{
		List<Employee>employees= empRepository.findByName("Mangesh");
		assertThat(employees.isEmpty()).isTrue();
		
		
	
	}

}
