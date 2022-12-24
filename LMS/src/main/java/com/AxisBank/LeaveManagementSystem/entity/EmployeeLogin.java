package com.AxisBank.LeaveManagementSystem.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
@Entity
@Table(name="loginemployee")
@Getter@Setter
public class EmployeeLogin {
	@Column(name="Name", nullable=false)
private String name;
@Id
private String email;
@Column(name="Password", nullable=false)
private String password;

public EmployeeLogin() {
	super();
	// TODO Auto-generated constructor stub
}

public String getName() {
	return name;
}

public void setName(String name) {
	this.name = name;
}

public String getEmail() {
	return email;
}

public void setEmail(String email) {
	this.email = email;
}

public String getPassword() {
	return password;
}

public void setPassword(String password) {
	this.password = password;
}

public EmployeeLogin(String name, String email, String password) {
	super();
	this.name = name;
	this.email = email;
	this.password = password;
}
}