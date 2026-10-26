package com.ffloyds.employeesyst.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ffloyds.employeesyst.models.Contract;
import com.ffloyds.employeesyst.models.Department;
import com.ffloyds.employeesyst.repository.ContractRepository;
import com.ffloyds.employeesyst.repository.DepartmentRepository;

@Service
public class ContractService {
	
	@Autowired
	private ContractRepository contractRepo;
	
	@Autowired
	private DepartmentRepository departmentRepo;
	
	public Contract getContract(int contractID) {
		Contract contract= contractRepo.findById(contractID);
		if(contractRepo.existsById(contractID)){
			return contract;
		}
		return null;
	}
	
	public Contract saveContract(Contract contract) {
		return contractRepo.save(contract);
	}
	
	public Contract createContract(Contract contract) {
		if(!contractRepo.existsById(contract.getContractID())){
			return contractRepo.save(contract);
		}
		return null;
	}

	
	
	
	public boolean updateContract(Contract contract) {
		if(!contractRepo.existsById(contract.getContractID())) {
			contractRepo.save(contract);
			 return true;
		}
		return false;
	}
	
	public List<Contract> fetchContracts(){
		return contractRepo.findAll();
	}
	
	public List<Contract> findByDepartment(Department department){
		return contractRepo.findByDepartment(department);
	}
	
	public List<Contract> findByStatus(int status){
		return contractRepo.findByStatus(status);
	}
	
	public List<Contract> findByContractStartDate(Date contractStartDate){
		return contractRepo.findByContractStartDate(contractStartDate);
	}
	
	
	public List<Contract> findByContractEndDate(Date contractEndDate){
		return contractRepo.findByContractEndDate(contractEndDate);
	}
	
	public List<Contract> findByContractType(String contractType){
		return contractRepo.findByContractType(contractType);
	}
	
	public List<Contract> findByContractEndDateBefore(Date contractEndDate){
		return contractRepo.findByContractEndDateBefore(contractEndDate);
	}
	
	public List<Contract> findByContractEndDateAfter(Date contractEndDate){
		return contractRepo.findByContractEndDateAfter(contractEndDate);
	}
	
	public List<Contract> findByContractStartDateBefore(Date contractStartDate){
		return contractRepo.findByContractStartDateBefore(contractStartDate);
	}
	
	public List<Contract> findByContractStartDateAfter(Date contractStartDate){
		return contractRepo.findByContractStartDateAfter(contractStartDate);
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
