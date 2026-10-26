package com.ffloyds.employeesyst.controllers;

import java.net.URI;
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

import com.ffloyds.employeesyst.models.Contract;
import com.ffloyds.employeesyst.models.Department;
import com.ffloyds.employeesyst.service.ContractService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/contract")
public class ContractController {

	private static Logger logger = LogManager.getLogger(ContractController.class);
	
	@Autowired
	private ContractService contractService;
	
	
	@GetMapping
	public List<Contract> getContract() {
		logger.trace("fetch Contract method called");
		return contractService.fetchContracts();
	}

	@GetMapping("/{contractID}")
	public ResponseEntity<Contract> getContract(@PathVariable int contractID) {
		logger.trace("Get Contract by ID Method called");
		Contract contract = contractService.getContract(contractID);

		if (contract != null) {
			logger.info("Contract received");
			return ResponseEntity.status(HttpStatus.OK).body(contract);
		}
		logger.debug("Unable to get Contract");
		return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
	}
	
	@PostMapping
	public ResponseEntity<Contract> createContract(@Valid @RequestBody Contract contract) {
		logger.trace("Create Contract object attempted");
		Department department= contract.getDepartment();
		contract.setDepartment(department);
		Contract createdContract = contractService.createContract(contract);

			if (createdContract!= null) {
				logger.info("Contract created");
				URI location = ServletUriComponentsBuilder
						.fromCurrentRequest()
						.path("/{contractID}")
						.buildAndExpand(createdContract.getContractID())
						.toUri();
				return ResponseEntity
						.created(location)
						.body(createdContract);
			}
			logger.debug("Unable to create Contract");
			return ResponseEntity.status(HttpStatus.CONFLICT).build();


	}
	

	@PutMapping
	public ResponseEntity<Contract> updateContract(@RequestBody Contract contract) {
		logger.trace("Update Contract method called");
		if (contractService.updateContract(contract)) {
			logger.info("Updated Company");
			return ResponseEntity.ok(contract);
		}
		logger.debug("Unable to update Contract");
		return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
	}
	
	
//
//	@GetMapping("/department/{department}")
//	public List<Contract> getContractByDepartment(@RequestBody Department department){
//		logger.trace("find Contract by Department method called");
//		return contractService.findByDepartment(department);
//	}
//	
//	
//	@GetMapping("/contractType/{contractType")
//	public List<Contract> getContractByType(@RequestBody String contractType){
//		logger.trace("find Contract by type method called");
//		return contractService.findByContractType(contractType);
//	}
//
//	@GetMapping("/status/{status}")
//	public List<Contract> getContractByStatus(@RequestBody int status){
//		logger.trace("find Contract by Status method called");
//		return contractService.findByStatus(status);
//	}
//	
//
//	@GetMapping("/contractStartDate/{contractStartDate}")
//	public List<Contract> getContractByContractStartDate(@RequestBody Date contractStartDate){
//		logger.trace("find Contract by contractStartDate method called");
//		return contractService.findByContractStartDate(contractStartDate);
//	}
//	
//
//	@GetMapping("/contractEndDate/{contractEndDate}")
//	public List<Contract> getContractByContractEndDate(@RequestBody Date contractEndDate){
//		logger.trace("find Contract by contractEndDate method called");
//		return contractService.findByContractEndDate(contractEndDate);
//	}
//	
//
//	@GetMapping("/contractEndDate/{contractEndDate}")
//	public List<Contract> getContractContractEndDateBefore(@Pathvariable Date contractEndDate){
//		logger.trace("find Contract before contractEndDate method called");
//		return contractService.findByContractEndDateBefore(contractEndDate);
//	}
//	
//
//	@GetMapping("/contractEndDate/{contractEndDate}")
//	public List<Contract> getContractContractEndDateAfter(@RequestBody Date contractEndDate){
//		logger.trace("find Contract after end date method called");
//		return contractService.findByContractEndDateAfter(contractEndDate);
//	}
//	
//
//	@GetMapping("/contractStartDate/{contractStartDate}")
//	public List<Contract> getContractContractStartDateAfter(@RequestBody Date contractStartDate){
//		logger.trace("find Contract after contractStartDate method called");
//		return contractService.findByContractStartDateAfter(contractStartDate);
//	}
//	
//	@GetMapping("/contractStartDate/{contractStartDate}")
//	public List<Contract> getContractContractStartDateBefore(@RequestBody Date contractStartDate){
//		logger.trace("find Contract before contractStartDate method called");
//		return contractService.findByContractStartDateBefore(contractStartDate);
//	}
//	
	
	
	
	
}
