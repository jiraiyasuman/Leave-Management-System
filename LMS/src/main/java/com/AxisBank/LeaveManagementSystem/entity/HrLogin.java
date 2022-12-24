package com.AxisBank.LeaveManagementSystem.entity;
import java.io.*;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
@SuppressWarnings("unused")
@Getter@Setter
@Entity
@Table(name="loginhr")
public class HrLogin {
	@Column(name="Name",nullable=false)
private String name;
@Id
private String email;
@Column(name="Password",nullable=false)
private String password;
public HrLogin(String name, String email, String password) {
	super();
	this.name = name;
	this.email = email;
	this.password = password;
}
public HrLogin(String email, String password) {
	super();
	this.email = email;
	this.password = password;
}
public HrLogin() {
	super();
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

}
