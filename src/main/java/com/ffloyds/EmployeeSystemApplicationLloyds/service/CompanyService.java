package com.ffloyds.EmployeeSystemApplicationLloyds.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ffloyds.EmployeeSystemApplicationLloyds.models.Company;
import com.ffloyds.EmployeeSystemApplicationLloyds.repository.CompanyRepository;

@Service
public class CompanyService {
	
	@Autowired
	private CompanyRepository companyRepo;
	
	public Company saveCompany(Company company) {
		return companyRepo.save(company);
	}
	
	public Company createCompany(Company company) {
		if(!companyRepo.existsById(company.getCompanyID())) {
			return companyRepo.save(company);
		}
		return null;
	}
	
	
	public boolean updateCompany(Company company) {
		if(!companyRepo.existsById(company.getCompanyID())) {
			 companyRepo.save(company);
			 return true;
		}
		return false;
	}
	
	
	public List<Company> fetchCompanies(){
		return companyRepo.findAll();
	}
	
	public List<Company> findByCompanyName(String companyName){
		return companyRepo.findByCompanyNameIgnoreCase(companyName);
	}
	
	public List<Company> findByCompanyAddress(String companyAddress){
		return companyRepo.findByCompanyAddressIgnoreCase(companyAddress);
	}
	
	public List<Company> findByCountry(String country){
		return companyRepo.findByCountryIgnoreCase(country);
	}
	
	
	public List<Company> findByStatus(int status){
		return companyRepo.findByStatus(status);
	}
	
	public Company getCompany(int companyID) {
		Company company= companyRepo.findById(companyID);
		if(companyRepo.existsById(companyID)){
			return company;
		}
		return null;
	}
	
	
	
	
	
}
