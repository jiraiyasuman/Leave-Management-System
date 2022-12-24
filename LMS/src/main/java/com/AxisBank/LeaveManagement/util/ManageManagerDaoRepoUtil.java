package com.AxisBank.LeaveManagement.util;


import com.AxisBank.LeaveManagement.repository.ManageManagerDaoRepo;
import com.AxisBank.LeaveManagementSystem.dao.ManageManagerDao;
import com.AxisBank.LeaveManagementSystem.databaseConnection.DbConnect;

public class ManageManagerDaoRepoUtil {
	public static ManageManagerDaoRepo getObject()
	{
		try {
			return new ManageManagerDao(DbConnect.getConnection());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
}
