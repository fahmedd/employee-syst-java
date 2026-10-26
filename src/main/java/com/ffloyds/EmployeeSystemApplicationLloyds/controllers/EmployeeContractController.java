package com.ffloyds.EmployeeSystemApplicationLloyds.controllers;

import java.net.URI;
import java.util.List;
import java.util.Optional;

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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.ffloyds.EmployeeSystemApplicationLloyds.models.Contract;
import com.ffloyds.EmployeeSystemApplicationLloyds.models.Employee;
import com.ffloyds.EmployeeSystemApplicationLloyds.models.EmployeeContractEntity;
import com.ffloyds.EmployeeSystemApplicationLloyds.models.EmployeeContractPK;
import com.ffloyds.EmployeeSystemApplicationLloyds.service.EmployeeContractService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/v1/employeeContract")
public class EmployeeContractController {
	
	private static Logger logger = LogManager.getLogger(ContractController.class);
	
	@Autowired
	private EmployeeContractService employeeContractService;
	
	
	@GetMapping
	public List<EmployeeContractEntity> getEmployeeContracts() {
		logger.trace("fetch EmployeeContract method called");
		return employeeContractService.fetchEmployeeContract();
	}

	
	
//	@PostMapping
//	public ResponseEntity<EmployeeContract> createEmployeeContract(@Valid @RequestBody EmployeeContract employeeContract) {
//		logger.trace("Create EmployeeContract object attempted");
//		EmployeeContract createdEmployeeContract = employeeContractService.createEmployeeContract(employeeContract);
//
//			if (createdEmployeeContract!= null) {
//				logger.info("EmployeeContract created");
//				URI location = ServletUriComponentsBuilder
//						.fromCurrentRequest()
//						.path("/{EmployeeContractPK}")
//						.buildAndExpand(createdEmployeeContract)
//						.toUri();
//				return ResponseEntity
//						.created(location)
//						.body(createdEmployeeContract);
//			}
//			logger.debug("Unable to create EmployeeContract");
//			return ResponseEntity.status(HttpStatus.CONFLICT).build();
//
//
//	}
	
	@PostMapping("/employee-contracts")
	public ResponseEntity<EmployeeContractEntity> createEmployeeContract(@Valid @RequestBody EmployeeContractEntity employeeContractEntity) {
		logger.trace("Create EmployeeContract object attempted");
		
		EmployeeContractPK pk= employeeContractEntity.getId();
		Contract contract= pk.getContract();
		Employee employee= pk.getEmployee();
		EmployeeContractEntity createdEmployeeContract = employeeContractService.createEmployeeContract(employeeContractEntity);
			if (createdEmployeeContract!= null) {
				logger.info("EmployeeContract created");
				return ResponseEntity.status(HttpStatus.CREATED)
					.body(createdEmployeeContract);
			}
			logger.debug("Unable to create EmployeeContract");
			return ResponseEntity.status(HttpStatus.CONFLICT).build();


	}
	
//
//	@PostMapping
//	public ResponseEntity<EmployeeContract> createEmployeeContract(@Valid @RequestBody EmployeeContract employeeContract,@RequestParam("contractID") Contract contract,@RequestParam("employeeID")Employee employee) {
//		logger.trace("Create EmployeeContract object attempted");
//		EmployeeContract createdEmployeeContract = employeeContractService.createEmployeeContract(employeeContract, contract,employee);
//
//			if (createdEmployeeContract!= null) {
//				logger.info("EmployeeContract created");
//				URI location = ServletUriComponentsBuilder
//						.fromCurrentRequest()
//						.path("/{EmployeeContractPK}")
//						.buildAndExpand(createdEmployeeContract)
//						.toUri();
//				return ResponseEntity
//						.created(location)
//						.body(createdEmployeeContract);
//			}
//			logger.debug("Unable to create EmployeeContract");
//			return ResponseEntity.status(HttpStatus.CONFLICT).build();
//
//
//	}
//	
//	@PostMapping
//	public EmployeeContract createEmployeeContract(@Valid @RequestBody EmployeeContract employeeContract,@RequestParam("contract") Contract contract,@RequestParam("employee")Employee employee) {
//	EmployeeContract createdEmployeeContract = employeeContractService.createEmployeeContract(employeeContract, contract,employee);
//
//		return createdEmployeeContract;
//	
//	}
//	
//	@GetMapping("NIN")
//	public List<EmployeeContract> getEmployeeContractByNIN(@RequestBody String NIN){
//		logger.trace("find EmployeeContract by NIN method called");
//		return employeeContractService.findByNIN(NIN);
//	}
//
//	@GetMapping("hours")
//	public List<EmployeeContract> getEmployeeContractByHours(@RequestBody int ContractHours){
//		logger.trace("find EmployeeContract by hours method called");
//		return employeeContractService.findByContractHours(ContractHours);
//	}
//	
//	
	
	@PutMapping
	public ResponseEntity<EmployeeContractEntity> updateEmployeeContract(@RequestBody EmployeeContractEntity employeeContractEntity) {
		logger.trace("Employee Contract method called");
		if (employeeContractService.updateEmployeeContract(employeeContractEntity) != null){
			logger.info("Updated contract");
			return ResponseEntity.ok(employeeContractEntity);
		}
		logger.debug("Unable to update employeeContract");
		return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
	
	}


	







	
}
