package com.ffloyds.employeesyst.models;

import java.sql.Date;

import com.fasterxml.jackson.annotation.JsonProperty;

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
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;

@Entity
@Table(name="Timesheet", schema="dbc")
@Embeddable
public class Timesheet {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="ID", nullable=false,unique=true)
	private int ID;
	
	@ManyToOne(fetch = FetchType.LAZY,cascade=CascadeType.MERGE)
	@JoinColumn(name="Employee_id",referencedColumnName="Employee_id",nullable=false)
	private Employee employee;
	
	
	@ManyToOne(fetch = FetchType.LAZY,cascade=CascadeType.MERGE)
	@JoinColumn(name="Contract_id",referencedColumnName="Contract_id",nullable=false)
	private Contract contract;
	
	@Column(name="NIN",length=9)
	@JsonProperty("NIN")
	private String nin;
	
	@Column(name="Date")
	@Temporal(TemporalType.DATE)
	private Date date;
	
	@Column(name="Hours")
	private Double hours;
	
	@Column(name="Submission")
	private int submission;

	
	public int getID() {
		return ID;
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

	public String getNin() {
		return nin;
	}

	public void setNin(String nin) {
		this.nin = nin;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public Double getHours() {
		return hours;
	}

	public void setHours(Double hours) {
		this.hours = hours;
	}

	public int getSubmission() {
		return submission;
	}

	public void setSubmission(int submission) {
		this.submission = submission;
	}

	
	
	
}
