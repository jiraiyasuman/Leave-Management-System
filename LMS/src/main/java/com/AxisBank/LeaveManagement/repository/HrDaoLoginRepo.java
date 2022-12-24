package com.AxisBank.LeaveManagement.repository;

import com.AxisBank.LeaveManagementSystem.entity.HrLogin;

public interface HrDaoLoginRepo {

	public boolean insert(HrLogin h)throws Exception;
	public HrLogin display(String email,String password)throws Exception;
	public boolean update(String user,String password);
}
