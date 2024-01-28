package com.syngenta.tasktrackpro.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.syngenta.tasktrackpro.entity.Employee;

public interface EmpRepository extends JpaRepository<Employee, Integer>{

}
