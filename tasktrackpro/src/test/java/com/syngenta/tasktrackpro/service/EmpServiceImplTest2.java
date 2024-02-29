//package com.syngenta.tasktrackpro.service;
//
//import static org.junit.Assert.*;
//import static org.mockito.Mockito.when;
//
//import org.junit.After;
//import org.junit.Before;
//import org.junit.Test;
//import org.mockito.Mock;
//import org.mockito.MockitoAnnotations;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.mock.mockito.MockBean;
//import org.springframework.stereotype.Service;
//
//import com.syngenta.tasktrackpro.dto.EmpDTO;
//import com.syngenta.tasktrackpro.entity.Employee;
//import com.syngenta.tasktrackpro.repository.EmpRepository;
//
//@Service
//public class EmpServiceImplTest2 {
//
//	@Autowired
//	@Mock
//	private EmpRepository empRepository;
//	private EmpService empService;
//	AutoCloseable autoCloseable;
//	EmpDTO empDTO,empDTO2;
//	Employee empEntity1,empEntity2;
//	
//	@Before
//	public void setUp() throws Exception {
//		autoCloseable= MockitoAnnotations.openMocks(this);
//		empService=new EmpServiceImpl(null, empRepository);
//		empDTO = new EmpDTO("John", "john@gmail.com", "IT",9998887776665L );
//		empEntity1=new Employee("John", "john@gmail.com", "IT",9998887776665L );
//	}
//
//	@After
//	public void tearDown() throws Exception {
//		autoCloseable.close();
//	}
//
//	@Test
//	public void testAddEmployee() {
//		when(empRepository.save(empEntity1)).thenReturn(empEntity1);
//		
//		EmpDTO resultDto= empService.addEmployee(empDTO);
//		
//		assertNotNull(resultDto);
//		assertEquals(empDTO.getName(),resultDto.getName());
//		assertEquals(empDTO.getContact(),resultDto.getContact() );
//		assertEquals(empDTO.getEmail(), resultDto.getEmail());
//		assertEquals(empDTO.getId(), 1);
//	}
//
//}
