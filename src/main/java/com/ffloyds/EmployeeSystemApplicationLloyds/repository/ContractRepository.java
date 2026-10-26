package com.ffloyds.EmployeeSystemApplicationLloyds.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ffloyds.EmployeeSystemApplicationLloyds.models.Contract;
import com.ffloyds.EmployeeSystemApplicationLloyds.models.Department;



public interface ContractRepository extends JpaRepository <Contract, Integer> {
	
	List<Contract> findByDepartment(Department department);
	
	List<Contract>findByStatus(int status);
	
	List<Contract>findByContractStartDate(Date contractStartDate);
	
	List<Contract>findByContractEndDate(Date contractEndDate);
	
	List<Contract>findByContractStartDateBefore(Date contractStartDate);
	
	List<Contract>findByContractEndDateBefore(Date contractEndDate);
	
	List<Contract>findByContractStartDateAfter(Date contractStartDate);
	
	List<Contract>findByContractEndDateAfter(Date contractEndDate);
	
	List<Contract>findByContractType(String contractType);
	
	Contract findById(int contractID);
	
	
	
	

}
