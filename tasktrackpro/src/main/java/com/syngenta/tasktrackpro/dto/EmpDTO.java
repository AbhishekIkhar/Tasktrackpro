package com.syngenta.tasktrackpro.dto;

import javax.persistence.Column;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class EmpDTO {
	private String name;
	private String email;
	private String dept;
	private long contact;

	public EmpDTO(String name, String email, String dept, long contact) {
		super();
		this.name = name;
		this.email = email;
		this.dept = dept;
		this.contact = contact;
	}

	public EmpDTO() {
		// TODO Auto-generated constructor stub

	}

}
