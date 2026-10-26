package com.ffloyds.EmployeeSystemApplicationLloyds.controllers;


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

import com.ffloyds.EmployeeSystemApplicationLloyds.models.Company;
import com.ffloyds.EmployeeSystemApplicationLloyds.service.CompanyService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/company")
public class CompanyController {
	
	private static Logger logger = LogManager.getLogger(CompanyController.class);
	
	@Autowired
	private CompanyService companyService;
	
	@GetMapping
	public List<Company> getCompanies() {
		logger.trace("fetch Companies method called");
		return companyService.fetchCompanies();
	}

	@GetMapping("/{companyID}")
	public ResponseEntity<Company> getCompany(@PathVariable int companyID) {
		logger.trace("Get Company by ID Method called");
		Company company = companyService.getCompany(companyID);

		if (company != null) {
			logger.info("company received");
			return ResponseEntity.status(HttpStatus.OK).body(company);
		}
		logger.debug("Unable to get user");
		return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
	}
	
	@PostMapping
	public ResponseEntity<Company> createCompany(@Valid @RequestBody Company company) {
		logger.trace("Create Company object attempted");
			Company createdCompany = companyService.createCompany(company);

			if (createdCompany!= null) {
				logger.info("Company created");
				URI location = ServletUriComponentsBuilder
						.fromCurrentRequest()
						.path("/{companyID}")
						.buildAndExpand(createdCompany.getCompanyID())
						.toUri();
				return ResponseEntity
						.created(location)
						.body(createdCompany);
			}
			logger.debug("Unable to create Company");
			return ResponseEntity.status(HttpStatus.CONFLICT).build();


	}

	@PutMapping
	public ResponseEntity<Company> updateCompany(@RequestBody Company company) {
		logger.trace("Update Company method called");
		if (companyService.updateCompany(company)) {
			logger.info("Updated Company");
			return ResponseEntity.ok(company);
		}
		logger.debug("Unable to update Company");
		return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
	}
	
//	
//	@GetMapping("/companyName/{companyName}")
//	public List<Company> getCompanyByName(@RequestBody String companyName){
//		logger.trace("find companies by name method called");
//		return companyService.findByCompanyName(companyName);
//	}
//	
//	@GetMapping("/companyAddress/{companyAddress}")
//	public List<Company> getCompanyByAddress(@RequestBody String companyAddress){
//		logger.trace("find companies by Address method called");
//		return companyService.findByCompanyAddress(companyAddress);
//	}
//	
//	
//	@GetMapping("/country/{country}")
//	public List<Company> getCompanyByCountry(@RequestBody String country){
//		logger.trace("find companies by country method called");
//		return companyService.findByCountry(country);
//	}
//	
//	@GetMapping("/status/{status}")
//	public List<Company> getCompanyByStatus(@RequestBody int status){
//		logger.trace("find companies by status method called");
//		return companyService.findByStatus(status);
//	}
//	
//	
//	
//	
//	
	
	
	
	
	
	
	
	
	
	
	
	
	        
}

