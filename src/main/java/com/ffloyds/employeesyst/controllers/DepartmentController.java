package com.ffloyds.employeesyst.controllers;

import java.net.URI;
import java.util.List;

import org.apache.logging.log4j.LogManager;
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

import com.ffloyds.employeesyst.models.Company;
import com.ffloyds.employeesyst.models.Department;
import com.ffloyds.employeesyst.service.DepartmentService;

import jakarta.validation.Valid;

import org.apache.logging.log4j.Logger;

@RestController
@RequestMapping("/api/department")
public class DepartmentController {

	private static Logger logger= LogManager.getLogger(DepartmentController.class);
	
	@Autowired
	private DepartmentService departmentService;
	
	@GetMapping
	public List<Department> getDepartment() {
		logger.trace("fetch Department method called");
		return departmentService.fetchDepartments();
	}

	@GetMapping("/{depID}")
	public ResponseEntity<Department> getDepartment(@PathVariable int depID) {
		logger.trace("Get Department by ID Method called");
		Department department = departmentService.getDepartment(depID);

		if (department != null) {
			logger.info("Department received");
			return ResponseEntity.status(HttpStatus.OK).body(department);
		}
		logger.debug("Unable to get Department");
		return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
	}
	
	@PostMapping
	public ResponseEntity<Department> createDepartment(@Valid @RequestBody Department department) {
		logger.trace("Create Department object attempted");
		Company company= department.getCompany();
		department.setCompany(company);
		Department createdDepartment = departmentService.createDepartment(department);

			if (createdDepartment!= null) {
				logger.info("Department created");
				URI location = ServletUriComponentsBuilder
						.fromCurrentRequest()
						.path("/{depID}")
						.buildAndExpand(createdDepartment.getDepID())
						.toUri();
				return ResponseEntity
						.created(location)
						.body(createdDepartment);
			}
			logger.debug("Unable to create Department");
			return ResponseEntity.status(HttpStatus.CONFLICT).build();


	}

	@PutMapping
	public ResponseEntity<Department> updateDepartment(@RequestBody Department department) {
		logger.trace("Update Department method called");
		if (departmentService.updateDepartment(department)) {
			logger.info("Updated Department");
			return ResponseEntity.ok(department);
		}
		logger.debug("Unable to update Department");
		return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
	}
	
	
//	@GetMapping("/departmentName/{departmentName}")
//	public List<Department> getDepartmentByName(@RequestBody String departmentName){
//		logger.trace("find Department by Name method called");
//		return departmentService.findByDepName(departmentName);
//	}
//	
//	@GetMapping("region")
//	public List<Department> getDepartmentByRegion(@RequestBody String region){
//		logger.trace("find Department by region method called");
//		return departmentService.findByRegion(region);
//	}
//	
//	@GetMapping("company")
//	public List<Department> getDepartmentByCompany(@RequestBody Company company){
//		logger.trace("find Department by company method called");
//		return departmentService.findByCompany(company);
//	}
//	
//	
//	@GetMapping("region")
//	public List<Department> getDepartmentByStatus(@RequestBody int status){
//		logger.trace("find Department by status method called");
//		return departmentService.findByStatus(status);
//	}
//	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
