package com.AxisBank.LeaveManagement.util;


import com.AxisBank.LeaveManagement.repository.ManagerLoginDaoRepo;
import com.AxisBank.LeaveManagementSystem.dao.ManagerLoginDao;
import com.AxisBank.LeaveManagementSystem.databaseConnection.DbConnect;

public class ManagerLoginDaoRepoUtil {
	public static ManagerLoginDaoRepo getObject()
	{
		try {
			return new ManagerLoginDao(DbConnect.getConnection());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
}
