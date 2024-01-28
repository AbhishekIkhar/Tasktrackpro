package com.syngenta.tasktrackpro.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.syngenta.tasktrackpro.entity.Employee;


public interface EmployeeRepository extends JpaRepository<Employee, Integer>{

}
