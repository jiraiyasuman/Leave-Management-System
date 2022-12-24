package com.AxisBank.LeaveManagement.util;


import com.AxisBank.LeaveManagement.repository.SmLoginDaoRepo;
import com.AxisBank.LeaveManagementSystem.dao.SmLoginDao;
import com.AxisBank.LeaveManagementSystem.databaseConnection.DbConnect;

public class SmLoginDaoRepoUtil {
	public static SmLoginDaoRepo getObject()
	{
		try {
			return new SmLoginDao(DbConnect.getConnection());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
}
