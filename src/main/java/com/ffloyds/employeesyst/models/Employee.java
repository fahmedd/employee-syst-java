package com.ffloyds.employeesyst.models;

import java.sql.Date;

import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;

import jakarta.validation.constraints.Email;

@Entity
@Table(name="Employee", schema="dbc")
@Embeddable
public class Employee {
	
	@Id
	@Column(name="Employee_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int employeeID;

	@Column(name="NIN",unique=true)
	@JsonProperty("NIN")
	private String nin;
	
	@Column(name="First_Name")
	private String firstName;
	
	@Column(name="Last_Name")
	private String lastName;
	
	@Column(name="DOB")
	@JsonProperty("DOB")
	@Temporal(TemporalType.DATE)
	private Date dob;
	
	
	@Column(name="Email",unique=true)
	@Email
	@NotBlank(message = "Email is required. ")
	private String email;
	
	@Column(name="Start_Date")
	@Temporal(TemporalType.DATE)
	private Date startDate;
	
	
	@Column(name="End_Date")
	@Temporal(TemporalType.DATE)
	private Date endDate;
	
	
	@Column(name="Status")
	private int status;

	public String getNin() {
		return nin;
	}

	public void setNin(String nin) {
		this.nin = nin;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public Date getDob() {
		return dob;
	}

	public void setDob(Date dob) {
		this.dob = dob;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}


	public int getEmployeeID() {
		return employeeID;
	}

//	@Override
//	public int hashCode() {
//		return Objects.hash(DOB, NIN, email, employeeID, endDate, firstName, lastName, startDate, status);
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
//		Employee other = (Employee) obj;
//		return Objects.equals(DOB, other.DOB) && Objects.equals(NIN, other.NIN) && Objects.equals(email, other.email)
//				&& employeeID == other.employeeID && Objects.equals(endDate, other.endDate)
//				&& Objects.equals(firstName, other.firstName) && Objects.equals(lastName, other.lastName)
//				&& Objects.equals(startDate, other.startDate) && status == other.status;
//	}


	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}




