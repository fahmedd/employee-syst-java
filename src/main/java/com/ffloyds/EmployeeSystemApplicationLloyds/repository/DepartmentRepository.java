package com.ffloyds.EmployeeSystemApplicationLloyds.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;


import com.ffloyds.EmployeeSystemApplicationLloyds.models.Company;
import com.ffloyds.EmployeeSystemApplicationLloyds.models.Department;

public interface DepartmentRepository extends JpaRepository<Department,Integer> {
	
	
	List<Department> findByDepartmentNameIgnoreCase(String departmentName);
	
	List<Department>findByCompany(Company company);
	
	List<Department> findByRegionIgnoreCase(String region);
	
	List<Department>findByStatus(int status);
	
	Department findById(int depID);

}
