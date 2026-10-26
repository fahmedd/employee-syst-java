package com.ffloyds.employeesyst.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ffloyds.employeesyst.models.EmployeeContractEntity;
import com.ffloyds.employeesyst.models.EmployeeContractPK;
import com.ffloyds.employeesyst.repository.ContractRepository;
import com.ffloyds.employeesyst.repository.EmployeeContractRepository;
import com.ffloyds.employeesyst.repository.EmployeeRepository;

import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;

@Service
public class EmployeeContractService {

	@Autowired 
	private EmployeeContractRepository employeeContractRepo;
	
	@Autowired 
	private ContractRepository contractRepo;
	
	@Autowired 
	private EmployeeRepository employeeRepo;
	
	
      
	public EmployeeContractEntity saveEmployeeContract(EmployeeContractEntity employeeContractEntity) {
		return employeeContractRepo.save(employeeContractEntity);
	}
	
	@Transactional
	//public EmployeeContract createEmployeeContract(Contract contract, Employee employee) {
	public EmployeeContractEntity createEmployeeContract(EmployeeContractEntity employeeContractEntity) {
			//EmployeeContract employeeContract= new EmployeeContract();
			//EmployeeContractPK id= new EmployeeContractPK(employee,contract);
		//when using a TO gui- gives ids- this info passed to Controller - controller to service , in service you would grab the info of the object and saving to enity
			//employeeContract.setId(id);
		return employeeContractRepo.save(employeeContractEntity);
	}
	
	 
	 public EmployeeContractEntity getEmployeeContract(EmployeeContractPK pk) {
	Optional<EmployeeContractEntity> employeeContractEntity = employeeContractRepo.findById(pk);
		    
		    if (employeeContractEntity.isPresent()) {
		        return employeeContractEntity.get();
		    } else {
		        throw new EntityNotFoundException("EmployeeContract not found");
		    }
		}
	
	public List<EmployeeContractEntity> fetchEmployeeContract(){
		return employeeContractRepo.findAll();
	}
	
	
	public List<EmployeeContractEntity> findByNin(String nin){
		return employeeContractRepo.findByNinIgnoreCase(nin);
	}
	
	
	public List<EmployeeContractEntity> findByContractHours(int contractHours){
		return employeeContractRepo.findByContractHours(contractHours);
	}
	
	public List<EmployeeContractEntity> findByHourlyRate(double hourlyRate){
		return employeeContractRepo.findByHourlyRate(hourlyRate);
	}
	
	
	 @Transactional
	    public EmployeeContractEntity updateEmployeeContract(EmployeeContractEntity employeeContractEntity) {
	        
	        if (employeeContractRepo.existsById(employeeContractEntity.getId())) {
	            
	            // Save the updated contract and return it
	            return employeeContractRepo.save(employeeContractEntity);
	        } else {
	            // If the contract with the given composite primary key is not found, throw an exception
	            throw new RuntimeException("Employee contract not found with employeeId and contractId");
	        }
	        
	        
	    }
	
	
	
	
	
	
}
