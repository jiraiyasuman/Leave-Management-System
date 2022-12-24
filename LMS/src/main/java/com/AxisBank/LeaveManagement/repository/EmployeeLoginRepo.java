package com.AxisBank.LeaveManagement.repository;

import com.AxisBank.LeaveManagementSystem.entity.EmployeeLogin;

public interface EmployeeLoginRepo {
	public boolean insert(EmployeeLogin h)throws Exception;
	public EmployeeLogin display(String email,String password)throws Exception;
	public  boolean update(String user,String password);
}
