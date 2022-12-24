package com.AxisBank.LeaveManagement.repository;

import com.AxisBank.LeaveManagementSystem.entity.AddNewEmployee;

public interface NewEmployeeDaoRepo {

	public boolean insert(AddNewEmployee a)throws Exception;
	public boolean update(String id);
}
