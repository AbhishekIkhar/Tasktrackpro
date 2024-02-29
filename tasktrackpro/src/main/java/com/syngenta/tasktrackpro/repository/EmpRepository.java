package com.syngenta.tasktrackpro.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.syngenta.tasktrackpro.entity.Employee;

@Repository
public interface EmpRepository extends JpaRepository<Employee, Integer> {

	// TODO: Using JPA
	// TODO: Write api which accepts 2 query param either can be use
	// TODO: u will get list of Number u have to return info about res emp. using
	// jpa
	// and streamAPI
	// 1. First do manually
	// 2. DO using stream

	// TODO: Learn about @JsonIgnore.
	public List<Employee> findByName(String name);

	public List<Employee> findByNameOrId(String name, Integer id);

	public Optional<Employee> findByNameAndId(String name, Integer id);

	public Optional<Employee> findByContact(Long Contact);

}
