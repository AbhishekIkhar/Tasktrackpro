package com.syngenta.tasktrackpro.dto;

import javax.persistence.Column;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class EmpDTO {
	@JsonIgnore
	private int id;
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

}
