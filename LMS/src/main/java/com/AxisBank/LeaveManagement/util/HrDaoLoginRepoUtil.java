package com.AxisBank.LeaveManagement.util;

import com.AxisBank.LeaveManagement.repository.HrDaoLoginRepo;
import com.AxisBank.LeaveManagementSystem.dao.HrDaoLogin;
import com.AxisBank.LeaveManagementSystem.databaseConnection.DbConnect;

public class HrDaoLoginRepoUtil {
	public static HrDaoLoginRepo getObject()
	{
		try {
			return new HrDaoLogin(DbConnect.getConnection());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
}
