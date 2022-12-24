package com.AxisBank.LeaveManagement.util;


import com.AxisBank.LeaveManagement.repository.ManagerLeaveDaoRepo;
import com.AxisBank.LeaveManagementSystem.dao.ManagerLeaveDao;
import com.AxisBank.LeaveManagementSystem.databaseConnection.DbConnect;

public class ManagerLeaveDaoRepoUtil {
	public static ManagerLeaveDaoRepo getObject()
	{
		try {
			return new ManagerLeaveDao(DbConnect.getConnection());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
}
