package com.syngenta.tasktrackpro.controller;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.syngenta.tasktrackpro.dto.EmpDTO;
import com.syngenta.tasktrackpro.exception.EmployeeNotFound;
import com.syngenta.tasktrackpro.service.EmpService;

@WebMvcTest(EmpController.class)
class EmpControllerTest {

	@Autowired
	private MockMvc mockMvc;

	@MockBean
	private EmpService empService;

	EmpDTO empDTO1;
	EmpDTO empDTO2;
	List<EmpDTO> empDTOs = new ArrayList<>();

	@BeforeEach
	void setUp() throws Exception {
		empDTO1 = new EmpDTO("Raj", "raj@gmail.com", "IT", 9898988787L);
		empDTO2 = new EmpDTO("Vikram", "vikram@gmail.com", "HR", 9696969684L);
		empDTOs.add(empDTO1);
		empDTOs.add(empDTO2);
	}

	@AfterEach
	void tearDown() throws Exception {
	}

	@Test
	void testGetAllEmployees() throws Exception {
		when(empService.getEmployees()).thenReturn(empDTOs);

		mockMvc.perform(get("/api/v1/employee/employees")).andDo(print()).andExpect(status().isOk());

	}

	@Test
	void testGetEmployeeByIdSuccess() throws Exception {
		when(empService.getEmployeeById(1)).thenReturn(empDTO1);

		mockMvc.perform(get("/api/v1/employee/1")).andDo(print()).andExpect(status().isOk());

	}

	@Test
	void testGetEmployeeByIdFailure() throws Exception {
		int id = 100;
		when(empService.getEmployeeById(id))
				.thenThrow(new EmployeeNotFound("Employee with id " + id + " does not exist"));

		mockMvc.perform(get("/api/v1/employee/{id}", id)).andDo(print()).andExpect(status().isNotFound());

	}

	@Test
	void testGetEmployeeByIdFailureForString() throws Exception {
		String idString = "abc";
		// when(empService.getEmployeeById(Integer.parseInt(idString))).thenThrow(new
		// NumberFormatException("Employee id is in int.") );

		mockMvc.perform(get("/api/v1/employee/{id}", idString)).andDo(print()).andExpect(status().isBadRequest());
	}

	@Test
	void testDeleteEmployeeByIdSuccess() throws Exception {
		when(empService.deleteEmp(1)).thenReturn("Employee with id" + 1 + " deleted successfullly");

		mockMvc.perform(delete("/api/v1/employee/{id}", 1)).andDo(print()).andExpect(status().isOk());
	}

	@Test
	void testDeleteEmployeeByIdFailure() throws Exception {
		String id = "abc";

		mockMvc.perform(delete("/api/v1/employee/{id}", id)).andDo(print()).andExpect(status().isBadRequest());

	}

	@Test
	void testCreateEmployee() throws Exception {
		EmpDTO empDTO3 = new EmpDTO("Harsh", "harsh@gmail.com", "QA", 9891928284L);
		EmpDTO empDTO=new EmpDTO("Harsh", "harsh@gmail.com", "QA", 9891928284L);
		ObjectMapper objectMapper = new ObjectMapper();
		String newEmployeeJson = objectMapper.writeValueAsString(empDTO3);

		when(empService.addEmployee(empDTO3)).thenReturn(empDTO3);

		mockMvc.perform(
				post("/api/v1/employee/create").contentType(MediaType.APPLICATION_JSON).content(newEmployeeJson))
				.andDo(print()).andExpect(status().isOk()).andExpect(jsonPath("$.name").value(empDTO.getName()))
                .andExpect(jsonPath("$.dept").value(empDTO.getDept()))
                .andExpect(jsonPath("$.email").value(empDTO.getEmail()))
                .andExpect(jsonPath("$.contact").value(empDTO.getContact()));;
	}

}
