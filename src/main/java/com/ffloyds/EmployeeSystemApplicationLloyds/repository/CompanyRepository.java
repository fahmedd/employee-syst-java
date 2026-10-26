package com.ffloyds.EmployeeSystemApplicationLloyds.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ffloyds.EmployeeSystemApplicationLloyds.models.Company;


public interface CompanyRepository extends JpaRepository<Company,Integer>{
	
	List<Company> findByCompanyNameIgnoreCase(String companyName);
	
	List<Company> findByCompanyAddressIgnoreCase(String companyAddress);
	
	List<Company> findByCountryIgnoreCase(String country);
	
	List<Company> findByStatus(int status);
	
	Company findById(int companyID);
}
