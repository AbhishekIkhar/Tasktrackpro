package com.syngenta.tasktrackpro.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.AssertFalse;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Table(name = "employee")
@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Employee {


	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	@Column(name = "id", nullable = false)
	private Integer id;

	@Column(name = "name", nullable = false)
	private String name;

	@Column(name = "email", nullable = true)
	private String email;

	@Column(name = "contactNumber", nullable = false)
	private long contactNumber;

	@Column(name = "password", nullable = false)
	private String password;
}
