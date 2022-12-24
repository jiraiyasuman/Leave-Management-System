package com.AxisBank.LeaveManagementSystem.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
@NoArgsConstructor
@Getter@Setter
@Entity
@Table(name="finalleaverecordseniormanager")
public class ManageHR {
	@Id
private String id;
	@Column(name="NAME",nullable=false)
private String name;
	@Column(name="LEAVE_TYPE",nullable=false)
private String leaveType;
@Column(name="FROM_DATE",nullable=false)
private String fromDate;
@Column(name="TO_DATE",nullable=false)
private String toDate;
@Column(name="NO_OF_DAYS",nullable=false)
private int noOfDays;
@Column(name="LEAVE_REASON",nullable=false)
private String leaveReason;
@Column(name="BALANCE")
private int balance;
@Column(name="STATUS")
private String status;
public String getId() {
	return id;
}

public void setId(String id) {
	this.id = id;
}

public String getName() {
	return name;
}

public void setName(String name) {
	this.name = name;
}

public String getLeaveType() {
	return leaveType;
}

public void setLeaveType(String leaveType) {
	this.leaveType = leaveType;
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

public int getNoOfDays() {
	return noOfDays;
}

public void setNoOfDays(int noOfDays) {
	this.noOfDays = noOfDays;
}

public String getLeaveReason() {
	return leaveReason;
}

public void setLeaveReason(String leaveReason) {
	this.leaveReason = leaveReason;
}

public int getBalance() {
	return balance;
}

public void setBalance(int balance) {
	this.balance = balance;
}

public String getStatus() {
	return status;
}

public void setStatus(String status) {
	this.status = status;
}

public ManageHR(String id, String name, String leaveType, String fromDate, String toDate, int noOfDays,
		String leaveReason, int balance, String status) {
	super();
	this.id = id;
	this.name = name;
	this.leaveType = leaveType;
	this.fromDate = fromDate;
	this.toDate = toDate;
	this.noOfDays = noOfDays;
	this.leaveReason = leaveReason;
	this.balance = balance;
	this.status = status;
}

}
