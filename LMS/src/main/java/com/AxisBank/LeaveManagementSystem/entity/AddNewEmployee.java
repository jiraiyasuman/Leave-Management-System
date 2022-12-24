package com.AxisBank.LeaveManagementSystem.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
@Entity
@Table(name="employeedetails")
@Setter@Getter
public class AddNewEmployee {
	@Column(name="Full Name", nullable=false)
private String name;
	@Column(name="Gender", nullable=false)
private String gender;
	@Column(name="Email", nullable=false)
private String email;
	@Column(name="Phone Number", nullable=false)
private String phNumber;
	@Column(name="Role", nullable=false)
private String role;
@Id
private String id;
@Column(name="Reporting_Person", nullable=false)
private String reporting;
@Column(name="Reporting_Name", nullable=false)
private String reportingName;
@Column(name="Reporting_Email", nullable=false)
private String reportingEmail;

public AddNewEmployee() {
	super();
	// TODO Auto-generated constructor stub
}

public String getName() {
	return name;
}

public void setName(String name) {
	this.name = name;
}

public String getGender() {
	return gender;
}

public void setGender(String gender) {
	this.gender = gender;
}

public String getEmail() {
	return email;
}

public void setEmail(String email) {
	this.email = email;
}

public String getPhNumber() {
	return phNumber;
}

public void setPhNumber(String phNumber) {
	this.phNumber = phNumber;
}

public String getRole() {
	return role;
}

public void setRole(String role) {
	this.role = role;
}

public String getId() {
	return id;
}

public void setId(String id) {
	this.id = id;
}

public String getReporting() {
	return reporting;
}

public void setReporting(String reporting) {
	this.reporting = reporting;
}

public String getReportingName() {
	return reportingName;
}

public void setReportingName(String reportingName) {
	this.reportingName = reportingName;
}

public String getReportingEmail() {
	return reportingEmail;
}

public void setReportingEmail(String reportingEmail) {
	this.reportingEmail = reportingEmail;
}

public AddNewEmployee(String id,String name, String gender, String email, String phNumber, String role,String reporting,String reportingName,String reportingEmail) {
	super();
	this.id=id;
	this.name = name;
	this.gender = gender;
	this.email = email;
	this.phNumber = phNumber;
	this.role = role;
	this.reporting=reporting;
	this.reportingName=reportingName;
	this.reportingEmail=reportingEmail;
}

}
