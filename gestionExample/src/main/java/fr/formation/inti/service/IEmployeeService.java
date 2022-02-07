package fr.formation.inti.service;

import java.util.List;

import fr.formation.inti.entity.Employee;

public interface IEmployeeService {
	
	Integer save(Employee e);
	
	void update(Employee e);
	
	void delete(Integer i);
	
	Employee findById(Integer i);
	
	List<Employee> findAll();
	

}
