package com.AxisBank.LeaveManagement.util;

import com.AxisBank.LeaveManagement.repository.EmpLeaveDaoRepo;
import com.AxisBank.LeaveManagementSystem.dao.EmpLeaveDao;
import com.AxisBank.LeaveManagementSystem.databaseConnection.DbConnect;

public class EmpLeaveDaoRepoUtil {
	public static EmpLeaveDaoRepo getObject()
	{
		try {
			return new EmpLeaveDao(DbConnect.getConnection());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
}
