package com.AxisBank.LeaveManagement.util;

import com.AxisBank.LeaveManagement.repository.ApplyLeaveSMRepo;
import com.AxisBank.LeaveManagementSystem.dao.ApplyLeaveSMDao;
import com.AxisBank.LeaveManagementSystem.databaseConnection.DbConnect;

public class ApplyLeaveSMRepoUtil {
	public static ApplyLeaveSMRepo getObject()
	{
		try {
			return new ApplyLeaveSMDao(DbConnect.getConnection());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
}
