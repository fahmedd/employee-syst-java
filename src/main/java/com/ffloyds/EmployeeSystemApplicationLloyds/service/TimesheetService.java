package com.ffloyds.EmployeeSystemApplicationLloyds.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ffloyds.EmployeeSystemApplicationLloyds.models.Contract;
import com.ffloyds.EmployeeSystemApplicationLloyds.models.Employee;
import com.ffloyds.EmployeeSystemApplicationLloyds.models.Timesheet;
import com.ffloyds.EmployeeSystemApplicationLloyds.repository.TimesheetRepository;

@Service
public class TimesheetService {

	
	@Autowired
	private TimesheetRepository timesheetRepo;
	

	public Timesheet getTimesheet(int ID) {
		Timesheet timesheet= timesheetRepo.findById(ID);
		if(timesheetRepo.existsById(ID)){
			return timesheet;
		}
		return null;
	}
	
	public Timesheet saveTimesheet(Timesheet timesheet) {
		return timesheetRepo.save(timesheet);
	}
	
	public Timesheet createTimesheet(Timesheet timesheet) {
		if(!timesheetRepo.existsById(timesheet.getID())) {
			return timesheetRepo.save(timesheet);
		}
		return null;
	}
	
	
	public boolean updateTimesheet(Timesheet timesheet) {
		if(!timesheetRepo.existsById(timesheet.getID())) {
			timesheetRepo.save(timesheet);
			 return true;
		}
		return false;
	}
	
	public List<Timesheet> fetchTimesheet(){
		return timesheetRepo.findAll();
	}
	
	public List<Timesheet> findByContract(Contract contract){
		return timesheetRepo.findByContract(contract);
	}
	
	public List<Timesheet> findByEmployee(Employee employee){
		return timesheetRepo.findByEmployee(employee);
	}
	
	public List<Timesheet> findByNIN(String nin){
		return timesheetRepo.findByNinIgnoreCase(nin);
	}
	
	
	public List<Timesheet> findByDate(Date date){
		return timesheetRepo.findByDate(date);
	}
	
	public List<Timesheet> findBySubmission(int submission){
		return timesheetRepo.findBySubmission(submission);
	}
	
	
	public List<Timesheet> findByHours(double hours){
		return timesheetRepo.findByHours(hours);
	}
	
	
	
	
	
	
	
	
	
	
	
	
}
