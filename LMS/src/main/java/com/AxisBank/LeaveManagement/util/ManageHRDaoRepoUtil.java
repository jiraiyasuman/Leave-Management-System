package com.AxisBank.LeaveManagement.util;

import com.AxisBank.LeaveManagement.repository.ManageHRDaoRepo;
import com.AxisBank.LeaveManagementSystem.dao.ManageHRDao;
import com.AxisBank.LeaveManagementSystem.databaseConnection.DbConnect;

public class ManageHRDaoRepoUtil {

	public static ManageHRDaoRepo getObject()
	{
		try {
			return new ManageHRDao(DbConnect.getConnection());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
}
