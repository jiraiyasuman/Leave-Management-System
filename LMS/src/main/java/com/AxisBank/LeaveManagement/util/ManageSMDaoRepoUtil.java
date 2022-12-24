package com.AxisBank.LeaveManagement.util;


import com.AxisBank.LeaveManagement.repository.ManageSMDaoRepo;
import com.AxisBank.LeaveManagementSystem.dao.ManageSMDao;
import com.AxisBank.LeaveManagementSystem.databaseConnection.DbConnect;

public class ManageSMDaoRepoUtil {
	public static ManageSMDaoRepo getObject()
	{
		try {
			return new ManageSMDao(DbConnect.getConnection());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
}
