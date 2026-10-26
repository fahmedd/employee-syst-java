package com.ffloyds.EmployeeSystemApplicationLloyds.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ffloyds.EmployeeSystemApplicationLloyds.models.Contract;
import com.ffloyds.EmployeeSystemApplicationLloyds.models.Employee;
import com.ffloyds.EmployeeSystemApplicationLloyds.models.EmployeeContractEntity;
import com.ffloyds.EmployeeSystemApplicationLloyds.models.EmployeeContractPK;

public interface EmployeeContractRepository extends JpaRepository<EmployeeContractEntity,EmployeeContractPK>{

	List<EmployeeContractEntity>findByNinIgnoreCase(String nin);
	
	List<EmployeeContractEntity>findByContractHours(int contractHours);
	
	List<EmployeeContractEntity>findByHourlyRate(double hourlyRate);
	
	Optional<EmployeeContractEntity> findById(EmployeeContractPK employeeContractPK);

	boolean existsById(EmployeeContractPK id);
	
	
}
