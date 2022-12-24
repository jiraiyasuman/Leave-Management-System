package com.AxisBank.LeaveManagement.util;

import com.AxisBank.LeaveManagement.repository.EmployeeLoginRepo;
import com.AxisBank.LeaveManagementSystem.dao.EmployeeLoginDao;
import com.AxisBank.LeaveManagementSystem.databaseConnection.DbConnect;

public class EmployeeLoginRepoUtil {
	public static EmployeeLoginRepo getObject()
	{
		try {
			return new EmployeeLoginDao(DbConnect.getConnection());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
}
