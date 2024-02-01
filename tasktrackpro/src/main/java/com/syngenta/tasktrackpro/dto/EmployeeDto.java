package com.syngenta.tasktrackpro.dto;

import lombok.Data;


/*
  1. @Jsonignore field -> why ,what and how ?
  2. Never use void --> return ResponseEntity/ something
  3. 
 */


@Data
public class EmployeeDto {
	
	private Integer id;
	private String name;
    private String email;
    private long contactNumber;
    private String password;
}
