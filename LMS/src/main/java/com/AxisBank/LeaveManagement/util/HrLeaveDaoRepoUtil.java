package com.AxisBank.LeaveManagement.util;

import com.AxisBank.LeaveManagement.repository.HrLeaveDaoRepo;
import com.AxisBank.LeaveManagementSystem.dao.HrLeaveDao;
import com.AxisBank.LeaveManagementSystem.databaseConnection.DbConnect;

public class HrLeaveDaoRepoUtil {

	public static HrLeaveDaoRepo getObject()
	{
		try {
			return new HrLeaveDao(DbConnect.getConnection());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
}
