package com.ffloyds.EmployeeSystemApplicationLloyds.models;

import java.sql.Date;
import java.util.Objects;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;

@Entity
@Embeddable
@Table(name="Contract", schema="dbc")
public class Contract {
		
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="Contract_id",unique=true)
	private int contractID;
	
	@ManyToOne(fetch= FetchType.LAZY, cascade=CascadeType.MERGE)
	@JoinColumn(name="Dep_id",referencedColumnName="Dep_id",nullable=false)
	private Department department;
		
	@Column(name="Contract_StartDate",nullable=false)
	@Temporal(TemporalType.DATE)
	private Date contractStartDate;
	
	@Column(name="Contract_EndDate", nullable=false)
	@Temporal(TemporalType.DATE)
	private Date contractEndDate;
	
	@Column(name="Status", nullable=false)
	private int status;
	
	@Column(name="Contract_Type", nullable=false)
	private String contractType;
	
	
	public String getContractType() {
		return contractType;
	}

	public void setContractType(String contractType) {
		this.contractType = contractType;
	}

	public Department getDepartment() {
		return department;
	}

	public void setDepartment(Department department) {
		this.department = department;
	}

	public Date getContractStartDate() {
		return contractStartDate;
	}

	public void setContractStartDate(Date contractStartDate) {
		this.contractStartDate = contractStartDate;
	}

	public Date getContractEndDate() {
		return contractEndDate;
	}

	public void setContractEndDate(Date contractEndDate) {
		this.contractEndDate = contractEndDate;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public int getContractID() {
		return contractID;
	}

	@Override
	public int hashCode() {
		return Objects.hash(contractEndDate, contractID, contractStartDate, contractType, department, status);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Contract other = (Contract) obj;
		return Objects.equals(contractEndDate, other.contractEndDate) && contractID == other.contractID
				&& Objects.equals(contractStartDate, other.contractStartDate)
				&& Objects.equals(contractType, other.contractType) && Objects.equals(department, other.department)
				&& status == other.status;
	}

	
	
	

	
}