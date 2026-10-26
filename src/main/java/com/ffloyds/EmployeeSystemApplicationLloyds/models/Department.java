package com.ffloyds.EmployeeSystemApplicationLloyds.models;

import java.util.List;
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
import jakarta.persistence.Transient;

@Entity
@Table(name="Department",schema="dbc")
@Embeddable
public class Department {

	@Id
	@Column(name="Dep_id",nullable=false,unique=true)
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int depID;
	
	@ManyToOne(fetch= FetchType.LAZY, cascade=CascadeType.MERGE)
	@JoinColumn(name="Company_id",referencedColumnName="Company_id",nullable=false)
	private Company company;
	
	@Column(name="Department_name",nullable=false)
	private String departmentName;
		
	@Column(name="Region",nullable=false)
	private String region;
	
	@Column(name="Status",nullable=false)
	private int status;
	

	public int getDepID() {
		return depID;
	}

	public Company getCompany() {
		return company;
	}

	public void setCompany(Company company) {
		this.company = company;
	}

	public String getDepartmentName() {
		return departmentName;
	}

	public void setDepartmentName(String departmentName) {
		this.departmentName = departmentName;
	}

	public String getRegion() {
		return region;
	}

	public void setRegion(String region) {
		this.region = region;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	@Override
	public int hashCode() {
		return Objects.hash(company, depID, departmentName, region, status);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Department other = (Department) obj;
		return Objects.equals(company, other.company) && depID == other.depID
				&& Objects.equals(departmentName, other.departmentName) && Objects.equals(region, other.region)
				&& status == other.status;
	}


	
	
	

}
