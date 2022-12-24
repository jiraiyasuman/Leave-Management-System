package com.AxisBank.LeaveManagement.repository;

import com.AxisBank.LeaveManagementSystem.entity.SmLogin;

public interface SmLoginDaoRepo {

	public boolean insert(SmLogin h)throws Exception;
	public SmLogin display(String email,String password)throws Exception;
	public boolean update(String user,String password);
}
