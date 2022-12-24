package com.AxisBank.LeaveManagement.repository;

import com.AxisBank.LeaveManagementSystem.entity.LoginManager;

public interface ManagerLoginDaoRepo {
	public boolean insert(LoginManager l)throws Exception;
	public LoginManager display(String email, String password)throws Exception;
	public boolean update(String user,String password);
}
