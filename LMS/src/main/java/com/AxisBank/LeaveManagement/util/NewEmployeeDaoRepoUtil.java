package com.AxisBank.LeaveManagement.util;


import com.AxisBank.LeaveManagement.repository.NewEmployeeDaoRepo;
import com.AxisBank.LeaveManagementSystem.dao.NewEmployeeDao;
import com.AxisBank.LeaveManagementSystem.databaseConnection.DbConnect;

public class NewEmployeeDaoRepoUtil {
	public static NewEmployeeDaoRepo getObject()
	{
		try {
			return new NewEmployeeDao(DbConnect.getConnection());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
}
