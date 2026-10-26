package com.ffloyds.employeesyst.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ffloyds.employeesyst.models.Company;
import com.ffloyds.employeesyst.models.Department;
import com.ffloyds.employeesyst.repository.CompanyRepository;
import com.ffloyds.employeesyst.repository.DepartmentRepository;

@Service
public class DepartmentService {
	
	@Autowired
	private DepartmentRepository departmentRepo;
	
	@Autowired
	private CompanyRepository companyRepo;
	
	
	
	public Department getDepartment(int depID) {
		Department department= departmentRepo.findById(depID);
		if(departmentRepo.existsById(depID)){
			return department;
		}
		return null;
	}
	
	public Department saveDepartment(Department department) {
		return departmentRepo.save(department);
	}
	
	public Department createDepartment(Department department) {
		if(!departmentRepo.existsById(department.getDepID())){
			return departmentRepo.save(department);
		}
		return null;
	}
	
	
	public boolean updateDepartment(Department department) {
		if(!departmentRepo.existsById(department.getDepID())) {
			departmentRepo.save(department);
			 return true;
		}
		return false;
	}
	
	
	public List<Department> fetchDepartments(){
		return departmentRepo.findAll();
	}
	
	public List<Department> findByStatus(int status){
		return departmentRepo.findByStatus(status);
	}

	public List<Department> findByCompany(Company company){
		return departmentRepo.findByCompany(company);
	}
	
	public List<Department> findByRegion(String region){
		return departmentRepo.findByRegionIgnoreCase(region);
	}
	
	public List<Department> findByDepName(String departmentName){
		return departmentRepo.findByDepartmentNameIgnoreCase(departmentName);
	}
	
	
	

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
