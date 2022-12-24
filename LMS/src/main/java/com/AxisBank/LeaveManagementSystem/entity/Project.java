package com.AxisBank.LeaveManagementSystem.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name="project")
@Getter@Setter
public class Project {
	@Id
private String name;
	@Column(name="From Date",nullable=false)
private String fromDate;
	@Column(name="To Date",nullable=false)
private String toDate;
	@Column(name="Description",nullable=false)
private String description;
public Project(String name, String fromDate, String toDate, String description) {
	super();
	this.name = name;
	this.fromDate = fromDate;
	this.toDate = toDate;
	this.description = description;
}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public String getFromDate() {
	return fromDate;
}
public void setFromDate(String fromDate) {
	this.fromDate = fromDate;
}
public String getToDate() {
	return toDate;
}
public void setToDate(String toDate) {
	this.toDate = toDate;
}
public String getDescription() {
	return description;
}
public void setDescription(String description) {
	this.description = description;
}
public Project() {
	super();
	// TODO Auto-generated constructor stub
}

}
