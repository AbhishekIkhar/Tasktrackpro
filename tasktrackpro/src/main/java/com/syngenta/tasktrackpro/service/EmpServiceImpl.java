package com.syngenta.tasktrackpro.service;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.syngenta.tasktrackpro.dto.EmpDTO;
import com.syngenta.tasktrackpro.entity.Employee;
import com.syngenta.tasktrackpro.exception.EmployeeNotFound;
import com.syngenta.tasktrackpro.repository.EmpRepository;

@Service
public class EmpServiceImpl implements EmpService {

	private EmpRepository empRepository;
	// private Map<Long, Employee> numtoEntity;

	private ModelMapper modelMapper;

	@Autowired
	public EmpServiceImpl(ModelMapper modelMapper, EmpRepository empRepository) {
		// numtoEntity=new HashMap<>();
		this.empRepository = empRepository;
		this.modelMapper = modelMapper;

	}

	@Override
	public List<EmpDTO> getEmployees() {
		// TODO Auto-generated method stub
		return empRepository.findAll().stream().map(employee -> convertEmpToDTO(employee)).collect(Collectors.toList());
	}

	@Override
	public EmpDTO getEmployeeById(int id) {
		// TODO Auto-generated method stub
		Employee employee = empRepository.findById(id)
				.orElseThrow(() -> new EmployeeNotFound("Employee with id " + id + " does not exist"));

		// Convert the Employee entity to EmpDTO and return
		// return convertEmpToDTO(employee);
		return EmpDTO.builder().contact(employee.getContact()).dept(employee.getDept()).name(employee.getName())
				.email(employee.getEmail()).build();
	}

	public List<EmpDTO> getEmployeesByName(String name) {
		List<Employee> employees = empRepository.findByName(name);
		return employees.stream().map(emp -> convertEmpToDTO(emp)).collect(Collectors.toList());
	}

	@Override
	public EmpDTO addEmployee(EmpDTO e) {
		// TODO Auto-generated method stub

		// empRepository.save(convertDTOToEmp(e));
		// numtoEntity.put(e.getContact(), e);
//		numtoEntity.put(e.getContact(), e);

		return convertEmpToDTO(empRepository.save(convertDTOToEmp(e)));

	}

	@Override
	public void deleteEmp(int id) {
		// TODO Auto-generated method stub
		Employee employee = empRepository.findById(id)
				.orElseThrow(() -> new EmployeeNotFound("Employee with id " + id + " does not exist"));

		empRepository.delete(employee);

	}

	private Employee convertDTOToEmp(EmpDTO dto) {
//       return numtoEntity.getOrDefault(dto.getContact(), null);

//		Employee employee = new Employee();
//		employee.setContact(dto.getContact());
//		employee.setDept(dto.getDept());
//		employee.setEmail(dto.getEmail());
//		employee.setName(dto.getName());
//		// numtoEntity.put(dto.getContact(), employee);
//		return employee;

		return Employee.builder().name(dto.getName()).dept(dto.getDept()).contact(dto.getContact())
				.email(dto.getEmail()).build();
	}

	@Override
	public EmpDTO updateEmployee(int id, EmpDTO e) {
		// TODO Auto-generated method stub
		Employee employee = empRepository.findById(id)
				.orElseThrow(() -> new EmployeeNotFound("Employee with id " + id + " does not exist"));
		employee.setContact(e.getContact());
		employee.setDept(e.getDept());
		employee.setName(e.getName());
		employee.setEmail(e.getEmail());
		empRepository.save(employee);

		return convertEmpToDTO(employee);
	}

	private EmpDTO convertEmpToDTO(Employee emp) {
//		EmpDTO empDTO = new EmpDTO();
//		empDTO.setContact(emp.getContact());
//		empDTO.setDept(emp.getDept());
//		empDTO.setEmail(emp.getEmail());
//		empDTO.setName(emp.getName());
//		return empDTO;
		return EmpDTO.builder().contact(emp.getContact()).dept(emp.getDept()).name(emp.getName()).email(emp.getEmail())
				.build();
	}
//	private EmpDTO convertEmpToDTO(Employee emp)
//	{
//		
//		EmpDTO empDTO=new EmpDTO();
//		empDTO=modelMapper.map(emp, EmpDTO.class);
//		
//		return empDTO;
//	}

	@Override
	public EmpDTO updateEmployee(EmpDTO e) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<EmpDTO> getEmployeesByNameOrId(String name, int id) {
		// TODO Auto-generated method stub
		List<Employee> employees = empRepository.findByNameOrId(name, id);
		return employees.stream().map(emp -> convertEmpToDTO(emp)).collect(Collectors.toList());
	}

}