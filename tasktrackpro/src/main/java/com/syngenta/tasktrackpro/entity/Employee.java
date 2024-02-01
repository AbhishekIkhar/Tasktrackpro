package com.syngenta.tasktrackpro.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "employee_details")
@Builder
public class Employee {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private int id;
	@Column(name = "emp_name", nullable = false)
	private String name;
	@Column(name = "emp_email", nullable = false)
	private String email;
	@Column(name = "emp_dept")
	private String dept;
	@Column(name = "emp_contact", nullable = false)
	private long contact;

	public Employee(String name, String email, String dept, long contact) {
		super();
		this.name = name;
		this.email = email;
		this.dept = dept;
		this.contact = contact;
	}

}

/*
 * TODO FOR MY TrackTrackPro Project: 1. entity obj should not be exposes make
 * dto class 2. Use constructor injection instead of field in autowire 3. In DB
 * all column , table and everything in lower case. 4. Make interface for the
 * controller 5. return type should not be entity it should be dto. Either [Can
 * return in response entity ] 6. Use try-catch, customize exception and default
 * where there is possibility of error 7. Profile --> [ how to use , what is ,
 * why to use ] --[ it use to provide enivornment]
 * https://docs.spring.io/spring-boot/docs/1.2.0.M1/reference/html/boot-features
 * -profiles.html 8. Junit for this project 9. SONAR is remaining
 */
