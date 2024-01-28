package com.syngenta.tasktrackpro.entity;

import java.sql.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Employee {

	@Id
	private int id;
	private String name;
	private String email;
	private String dept;
	private long contact;
		
	public Employee(int id, String name, String email, String dept, long contact) {
		super();
		this.id = id;
		this.name = name;
		this.email = email;
		this.dept = dept;
		this.contact = contact;
		
	}
	


	public int getId() {
		return id;
	}
	public void setId(int id) {
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
	public String getDept() {
		return dept;
	}
	public void setDept(String dept) {
		this.dept = dept;
	}
	public long getContact() {
		return contact;
	}
	public void setContact(long contact) {
		this.contact = contact;
	}
	public Employee() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "Employee [id=" + id + ", name=" + name + ", email=" + email + ", dept=" + dept + ", contact=" + contact
				;
	}
	
	
}
