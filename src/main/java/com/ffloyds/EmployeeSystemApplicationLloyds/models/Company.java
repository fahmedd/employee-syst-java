package com.ffloyds.EmployeeSystemApplicationLloyds.models;

import java.util.List;
import java.util.Objects;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import jakarta.persistence.Transient;

@Entity
@Table(name="Company",schema="dbc")
@Embeddable
public class Company {

@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
@Column(name="Company_id",nullable=false,unique=true)
private int companyID;

@Column(name="Company_Name",nullable=false)
private String companyName;

@Column(name="Company_Address",nullable=false)
private String companyAddress;

@Column(name="Country", nullable=false)
private String country;

@Column(name="Status",nullable=false)
private int status;


public String getCompanyName() {
	return companyName;
}

public void setCompanyName(String companyName) {
	this.companyName = companyName;
}

public String getCompanyAddress() {
	return companyAddress;
}

public void setCompanyAddress(String companyAddress) {
	this.companyAddress = companyAddress;
}

public String getCountry() {
	return country;
}

public void setCountry(String country) {
	this.country = country;
}

public int getStatus() {
	return status;
}

public void setStatus(int status) {
	this.status = status;
}

public int getCompanyID() {
	return companyID;
}

@Override
public int hashCode() {
	return Objects.hash(companyAddress, companyID, companyName, country, status);
}

@Override
public boolean equals(Object obj) {
	if (this == obj)
		return true;
	if (obj == null)
		return false;
	if (getClass() != obj.getClass())
		return false;
	Company other = (Company) obj;
	return Objects.equals(companyAddress, other.companyAddress) && companyID == other.companyID
			&& Objects.equals(companyName, other.companyName) && Objects.equals(country, other.country)
			&& status == other.status;
}






}
