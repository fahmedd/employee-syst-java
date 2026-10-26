package com.ffloyds.employeesyst.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ffloyds.employeesyst.models.Employee;


public interface EmployeeRepository extends JpaRepository<Employee,Integer>{

	Employee findByNin(String nin);
	
	List<Employee>findByFirstNameIgnoreCase(String firstName);
	
	List<Employee> findByLastNameIgnoreCase(String lastName);
	
	List<Employee> findByStatus(int Status);
	
	List<Employee> findByDob(Date dob);
	
	List<Employee> findByStartDateContaining(Date startDate);
	
	List<Employee> findByEndDateContaining(Date endDate);
	
	Employee findByEmailIgnoreCase(String email);
	
	Employee findById(int employeeID);
	
//	Employee updateEmployee(int employeeID, Employee employee);
	
//	List<Employee> findAll(@Param ("keyword")String keyword);
	
	
	
	
}
