package com.AxisBank.LeaveManagement.util;


import com.AxisBank.LeaveManagement.repository.ProjectDaoRepo;
import com.AxisBank.LeaveManagementSystem.dao.ProjectDao;
import com.AxisBank.LeaveManagementSystem.databaseConnection.DbConnect;

public class ProjectDaoRepoUtil {
	public static ProjectDaoRepo getObject()
	{
		try {
			return new ProjectDao(DbConnect.getConnection());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
}
