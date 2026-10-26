package com.ffloyds.employeesyst.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.ffloyds.employeesyst.models.Employee;
import com.ffloyds.employeesyst.repository.EmployeeRepository;

@Service
public class EmployeeService {

	@Autowired
	private EmployeeRepository employeeRepo;
	
	public Employee getEmployee(int employeeID) {
		Employee employee= employeeRepo.findById(employeeID);
		if(employeeRepo.existsById(employeeID)){
			return employee;
		}
		return null;
	}
	
	public Employee saveEmployee(Employee employee) {
		return employeeRepo.save(employee);
	}
	
	public Employee createEmployee(Employee employee) {
		if(!employeeRepo.existsById(employee.getEmployeeID())) {
			return employeeRepo.save(employee);
		}
		return null;
	}
	
	
	 public Employee updateEmployee(int employeeID, Employee employee) {
	        Employee updatedEmployee = employeeRepo.findById(employeeID);
	        updatedEmployee.setFirstName(employee.getFirstName());
	        updatedEmployee.setLastName(employee.getLastName());
	        updatedEmployee.setEmail(employee.getEmail());
	        updatedEmployee.setDob(employee.getDob());
	        updatedEmployee.setStartDate(employee.getStartDate());
	        updatedEmployee.setEndDate(employee.getEndDate());
	        updatedEmployee.setNin(employee.getNin());
	        updatedEmployee.setStatus(employee.getStatus());
	        return employeeRepo.save(updatedEmployee);
	    }
	
	
	public List<Employee> fetchEmployees(){
		return employeeRepo.findAll(Sort.by(Sort.Direction.DESC,"employeeID"));
	}
	
//	public List<Employee> fetchSearchedEmployees(String keyword){
//		return employeeRepo.findAll(keyword);
//	}
//	
	
//	public Employee findByNIN(String NIN){
//		return employeeRepo.findByNINIgnoreCase(NIN);
//	}
//	
	public List<Employee> findByFirstName(String firstName){
		return employeeRepo.findByFirstNameIgnoreCase(firstName);
	}
//	
//	public List<Employee> findByLastName(String lastName){
//		return employeeRepo.findByLastNameIgnoreCase(lastName);
//	}
//	
////	public List<Employee> findByDOB(Date DOB){
////		return employeeRepo.findByDOB(DOB);
////	}
////	
//	public List<Employee> findByStatus(int status){
//		return employeeRepo.findByStatus(status);
//	}
//	
//	public List<Employee> findByStartDate(Date startDate){
//		return employeeRepo.findByStartDateContaining(startDate);
//	}
//	
//	public List<Employee> findByEndDate(Date endDate){
//		return employeeRepo.findByEndDateContaining(endDate);
//	}
//	
//	public Employee findByEmail(String email){
//		return employeeRepo.findByEmailIgnoreCase(email);
//	}
	
	
	
	
	
	
	
}
