package com.ffloyds.employeesyst.models;


import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.persistence.Column;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name="EmployeeContract",schema="dbc")
public class EmployeeContractEntity {
	
	@EmbeddedId
    private EmployeeContractPK id;
		
	@Column(name="NIN")
	@JsonProperty("NIN")
	private String nin;
	
	@JsonProperty("contractHours")
	@Column(name="Contract_Hours")
	private int contractHours;
	
	@JsonProperty("hourlyRate")
	@Column(name="Hourly_Rate")
	private double hourlyRate;
	
	
	
	public EmployeeContractPK getId() {
		return id;
	}

	public void setId(EmployeeContractPK id) {
		this.id = id;
	}

	public String getNin() {
		return nin;
	}

	public void setNin(String nin) {
		this.nin =nin;
	}

	public int getContractHours() {
		return contractHours;
	}

	public void setContractHours(int contractHours) {
		this.contractHours = contractHours;
	}

	public double getHourlyRate() {
		return hourlyRate;
	}

	public void setHourlyRate(double hourlyRate) {
		this.hourlyRate = hourlyRate;
	}

//	@Override
//	public int hashCode() {
//		return Objects.hash(nin, contractHours, hourlyRate, id);
//	}
//
//	@Override
//	public boolean equals(Object obj) {
//		if (this == obj)
//			return true;
//		if (obj == null)
//			return false;
//		if (getClass() != obj.getClass())
//			return false;
//		EmployeeContract other = (EmployeeContract) obj;
//		return Objects.equals(nin, other.nin) && contractHours == other.contractHours
//				&& Double.doubleToLongBits(hourlyRate) == Double.doubleToLongBits(other.hourlyRate)
//				&& Objects.equals(id, other.id);
//	}

	
	
}
