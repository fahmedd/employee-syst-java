package com.ffloyds.employeesyst.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ffloyds.employeesyst.models.Contract;
import com.ffloyds.employeesyst.models.Employee;
import com.ffloyds.employeesyst.models.Timesheet;


public interface TimesheetRepository extends JpaRepository <Timesheet,Integer> {

	List<Timesheet> findByEmployee(Employee employee);

	List<Timesheet> findByContract(Contract contract);
	
	List<Timesheet> findByNinIgnoreCase(String nin);
	
	List<Timesheet>findByDate(Date date);
	
	List<Timesheet>findBySubmission(int submission);
	
	List<Timesheet>findByHours(double hours);
	
	Timesheet findById(int ID);
	
	
}
