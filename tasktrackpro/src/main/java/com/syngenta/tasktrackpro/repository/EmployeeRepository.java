package com.syngenta.tasktrackpro.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
//import org.springframework.data.jpa.repository.Query;
//import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.syngenta.tasktrackpro.models.Employee;




@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Integer>{
    
	@Query(value = "SELECT name FROM employee", nativeQuery = true)
	public List<String> getAllEmployee();
	

	
	// TODO: Using JPA 
	// TODO: Write api which accepts 2 query param either can be use
    // TODO: u will get list of Number u have to return info about res emp. using jpa 
	// and streamAPI 
	// 1. First do manually 
	// 2. DO using stream 
   
}
