package com.syngenta.tasktrackpro.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Employee {

//	ID, Name, mail id, contact no, department, joining date and password
	
	@Id
	private Integer id;
	
	private String name;
	private String email;
	private String contactNumber;
	private String password;
	
	
	public Employee() {
		super();
	}
	
	public Employee(Integer id, String name, String email, String contactNumber, String password) {
		this.id = id;
		this.name = name;
		this.email = email;
		this.contactNumber = contactNumber;
		this.password = password;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getContactNumber() {
		return contactNumber;
	}

	public void setContactNumber(String contactNumber) {
		this.contactNumber = contactNumber;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String toString() {
		return "Employee [id=" + id + ", name=" + name + ", email=" + email + ", contactNumber=" + contactNumber
				+ ", password=" + password + "]";
	}
}

