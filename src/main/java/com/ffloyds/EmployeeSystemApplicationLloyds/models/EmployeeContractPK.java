package com.ffloyds.EmployeeSystemApplicationLloyds.models;

import java.io.Serializable;
import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Embeddable;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;

@Embeddable
public class EmployeeContractPK implements Serializable{
 

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@ManyToOne(fetch = FetchType.LAZY,cascade=CascadeType.MERGE)
	@JoinColumn(name = "Employee_id",referencedColumnName="Employee_id")
	@JsonProperty("Employee_id")
	private Employee employee;

	@OneToOne(fetch = FetchType.LAZY,cascade=CascadeType.MERGE)
	@JoinColumn(name = "Contract_id",referencedColumnName="Contract_id")
	@JsonProperty("Contract_id")
	private Contract contract;

	public EmployeeContractPK() {
	}

	public EmployeeContractPK(Employee employee, Contract contract) {
		this.employee = employee;
		this.contract = contract;
	}

	public Employee getEmployee() {
		return employee;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}

	public Contract getContract() {
		return contract;
	}

	public void setContract(Contract contract) {
		this.contract = contract;
	}

	@Override
	public int hashCode() {
		return Objects.hash(contract, employee);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		EmployeeContractPK other = (EmployeeContractPK) obj;
		return Objects.equals(contract, other.contract) && Objects.equals(employee, other.employee);
	}
	

	
}