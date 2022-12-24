package com.AxisBank.LeaveManagement.util;

import com.AxisBank.LeaveManagement.repository.LeaveBalanceRepo;
import com.AxisBank.LeaveManagementSystem.dao.LeaveBalance;
import com.AxisBank.LeaveManagementSystem.databaseConnection.DbConnect;

public class LeaveBalanceRepoUtil {
	public static LeaveBalanceRepo getObject()
	{
		try {
			return new LeaveBalance(DbConnect.getConnection());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
}
