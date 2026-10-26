package com.ffloyds.EmployeeSystemApplicationLloyds.controllers;

import java.net.URI;
import java.util.Date;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.ffloyds.EmployeeSystemApplicationLloyds.models.Company;
import com.ffloyds.EmployeeSystemApplicationLloyds.models.Employee;
import com.ffloyds.EmployeeSystemApplicationLloyds.service.EmployeeService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/employee")
@CrossOrigin("*")
public class EmployeeController {
	
	private static Logger logger = LogManager.getLogger(EmployeeController.class);
	
	@Autowired
	private EmployeeService employeeService;
	
	
	@GetMapping
	public List<Employee> getEmployee() {
		logger.trace("fetch Employee method called");
		return employeeService.fetchEmployees();
	}

	@GetMapping("/{employeeID}")
	public ResponseEntity<Employee> getEmployee(@PathVariable int employeeID) {
		logger.trace("Get Employee by ID Method called");
		Employee employee = employeeService.getEmployee(employeeID);

		if (employee != null) {
			logger.info("Employee received");
//			System.out.println(employee.getFirstName());
			return ResponseEntity.status(HttpStatus.OK).body(employee);
		}
		logger.debug("Unable to get Employee");
		return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
	}
	
	@PostMapping
	public ResponseEntity<Employee> createEmployee(@Valid @RequestBody Employee employee) {
		logger.trace("Create Employee object attempted");
		Employee createdEmployee = employeeService.saveEmployee(employee);

			if (createdEmployee!= null) {
				logger.info("Employee created");
				URI location = ServletUriComponentsBuilder
						.fromCurrentRequest()
						.path("/{employeeID}")
						.buildAndExpand(createdEmployee.getEmployeeID())
						.toUri();
				return ResponseEntity
						.created(location)
						.body(createdEmployee);
			}
			logger.debug("Unable to create Employee");
			return ResponseEntity.status(HttpStatus.CONFLICT).build();


	}

	@PutMapping("/{employeeID}")
	public ResponseEntity<Employee> updateEmployee(@PathVariable int employeeID, @RequestBody Employee employee) {
		logger.trace("Update Employee method called");
		if (employeeService.updateEmployee(employeeID,employee) !=null) {
			logger.info("Updated Employee");
			return ResponseEntity.ok(employee);
		}
		logger.debug("Unable to update employee");
		return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
	}
	
//	@GetMapping("/api/search")
//	public int getSearchedEmployeeByName(@RequestParam("firstName")String firstName){
//		List<Employee> returnedEmployees=employeeService.findByFirstName(firstName);
//		List<Employee> listEmployees= new ArrayList<>();
//		for(Employee eachEmployee:returnedEmployees) {
//			listEmployees.add(eachEmployee);
//		}
//		return listEmployees.size();
//	}

	@GetMapping("/api/search")
	public List<Employee> getSearchedEmployeeByName(@RequestParam("firstName")String firstName){
		List<Employee> returnedEmployees=employeeService.findByFirstName(firstName);
		return returnedEmployees;
	}
	
//	@GetMapping("employees/{keyword}")
//	public List<Employee> searchEmployees(@PathVariable("keyword")String keyword){
//		logger.trace("fetchSearched employees method called");
//		return employeeService.fetchSearchedEmployees(keyword);
//	
//}

////	
//	@GetMapping("NIN")
//	public ResponseEntity<Employee> getEmployeeByNIN(@RequestBody String NIN) {
//		logger.trace("Get Employee by NIN Method called");
//		Employee employee = employeeService.findByNIN(NIN);
//
//		if (employee != null) {
//			logger.info("Employee received");
//			return ResponseEntity.status(HttpStatus.OK).body(employee);
//		}
//		logger.debug("Unable to get Employee");
//		return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
//	}
	
//	@GetMapping("email")
//	public ResponseEntity<Employee> getEmployeeByEmail(@RequestBody String email) {
//		logger.trace("Get Employee by email Method called");
//		Employee employee = employeeService.findByEmail(email);
//
//		if (employee != null) {
//			logger.info("Employee received");
//			return ResponseEntity.status(HttpStatus.OK).body(employee);
//		}
//		logger.debug("Unable to get Employee");
//		return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
//	}
//	
//	
//	
//
//	@GetMapping("status")
//	public List<Employee> getEmployeeByStatus(@RequestBody int status){
//		logger.trace("find Employee by status method called");
//		return employeeService.findByStatus(status);
//	}
//	
//	@GetMapping("firstName")
//	public List<Employee> getEmployeeByfirstName(@RequestBody String firstName){
//		logger.trace("find Employee by firstName method called");
//		return employeeService.findByFirstName(firstName);
//	}
//	
//	@GetMapping("lastName")
//	public List<Employee> getEmployeeByLastName(@RequestBody String lastName){
//		logger.trace("find Employee by lastName method called");
//		return employeeService.findByLastName(lastName);
//	}
//	
//	@GetMapping("DOB")
//	public List<Employee> getEmployeeByDOB(@RequestBody Date DOB){
//		logger.trace("find Employee by DOB method called");
//		return employeeService.findByDOB(DOB);
//	}
//	
//	@GetMapping("startDate")
//	public List<Employee> getEmployeeByStartDate(@RequestBody Date startDate){
//		logger.trace("find Employee by startDate method called");
//		return employeeService.findByStartDate(startDate);
//	}
//	
//	@GetMapping("endDate")
//	public List<Employee> getEmployeeByEndDate(@RequestBody Date endDate){
//		logger.trace("find Employee by endDate method called");
//		return employeeService.findByEndDate(endDate);
//	}
//	
//	
//	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
