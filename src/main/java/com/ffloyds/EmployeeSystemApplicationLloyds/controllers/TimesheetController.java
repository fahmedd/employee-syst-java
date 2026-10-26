package com.ffloyds.EmployeeSystemApplicationLloyds.controllers;

import java.net.URI;
import java.util.Date;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.ffloyds.EmployeeSystemApplicationLloyds.models.Contract;
import com.ffloyds.EmployeeSystemApplicationLloyds.models.Employee;
import com.ffloyds.EmployeeSystemApplicationLloyds.models.Timesheet;
import com.ffloyds.EmployeeSystemApplicationLloyds.service.TimesheetService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/timesheet")
public class TimesheetController {
	
	private static Logger logger = LogManager.getLogger(TimesheetController.class);
	
	
	@Autowired
	private TimesheetService timesheetService;
	
	@GetMapping
	public List<Timesheet> getTimesheets() {
		logger.trace("fetch Timesheet method called");
		return timesheetService.fetchTimesheet();
	}

	@GetMapping("/{ID}")
	public ResponseEntity<Timesheet> getTimesheet(@PathVariable int ID) {
		logger.trace("Get Timesheet by ID Method called");
		Timesheet timesheet = timesheetService.getTimesheet(ID);

		if (timesheet != null) {
			logger.info("Timesheet received");
			return ResponseEntity.status(HttpStatus.OK).body(timesheet);
		}
		logger.debug("Unable to get Timesheet");
		return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
	}
	
	@PostMapping
	public ResponseEntity<Timesheet> createTimesheet(@Valid @RequestBody Timesheet timesheet) {
		logger.trace("Create Timesheet object attempted");
		Employee employee= timesheet.getEmployee();
		Contract contract= timesheet.getContract();
		Timesheet createdTimesheet = timesheetService.createTimesheet(timesheet);
			if (createdTimesheet!= null) {
				logger.info("Timesheet created");
				URI location = ServletUriComponentsBuilder
						.fromCurrentRequest()
						.path("/{ID}")
						.buildAndExpand(createdTimesheet.getID())
						.toUri();
				return ResponseEntity
						.created(location)
						.body(createdTimesheet);
			}
			logger.debug("Unable to create Timesheet");
			return ResponseEntity.status(HttpStatus.CONFLICT).build();


	}

	@PutMapping
	public ResponseEntity<Timesheet> updateTimesheet(@RequestBody Timesheet timesheet) {
		logger.trace("Update Timesheet method called");
		if (timesheetService.updateTimesheet(timesheet)) {
			logger.info("Updated Timesheet");
			return ResponseEntity.ok(timesheet);
		}
		return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
	}
	


//	@GetMapping("employee")
//	public List<Timesheet> getTimesheetByEmployee(@RequestBody Employee employee){
//		logger.trace("find timesheet by employee method called");
//		return timesheetService.findByEmployee(employee);
//	}
//	
//	@GetMapping("contract")
//	public List<Timesheet> getTimesheetByEmployee(@RequestBody Contract contract){
//		logger.trace("find timesheet by contract method called");
//		return timesheetService.findByContract(contract);
//	}
//	
//	@GetMapping("NIN")
//	public List<Timesheet> getTimesheetByNIN(@RequestBody String NIN){
//		logger.trace("find timesheet by NIN method called");
//		return timesheetService.findByNIN(NIN);
//	}
//	
//	@GetMapping("date")
//	public List<Timesheet> getTimesheetByDate(@RequestBody Date date){
//		logger.trace("find timesheet by Date method called");
//		return timesheetService.findByDate(date);
//	}
//	
//	@GetMapping("submission")
//	public List<Timesheet> getTimesheetBySubmission(@RequestBody int submission){
//		logger.trace("find timesheet by submission method called");
//		return timesheetService.findBySubmission(submission);
//	}
//	
//	@GetMapping("hours")
//	public List<Timesheet> getTimesheetByHours(@RequestBody double hours){
//		logger.trace("find timesheet by Hours method called");
//		return timesheetService.findByHours(hours);
//	}
//	
	
}
