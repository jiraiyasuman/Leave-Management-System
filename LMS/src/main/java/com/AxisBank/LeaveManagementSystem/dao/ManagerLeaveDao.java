package com.AxisBank.LeaveManagementSystem.dao;
import java.sql.*;

import com.AxisBank.LeaveManagement.repository.ManagerLeaveDaoRepo;
import com.AxisBank.LeaveManagementSystem.databaseConnection.DbConnect;
import com.AxisBank.LeaveManagementSystem.entity.ApplyLeaveManager;
public class ManagerLeaveDao implements ManagerLeaveDaoRepo{
Connection conn=null;
ApplyLeaveManager a=null;
public ManagerLeaveDao(Connection conn)
{
	this.conn=conn;
}
public boolean insert(ApplyLeaveManager ah)throws Exception
{
	boolean f=false;
	try {
		Connection conn=DbConnect.getConnection();
		String sql="INSERT INTO `leavemanagementsystem`.`finalleaverecordhigherups` (`EMPLOYEE_ID`, `NAME`, `FROM_DATE`, `TO_DATE`,`LEAVE_TYPE`,`NO_OF_DAYS`, `LEAVE_REASON`,`LEAVE_BALANCE`,`STATUS`) VALUES (?, ?, ?, ?, ?, ?, ?,?,?);";
		PreparedStatement ps=conn.prepareStatement(sql);
		ps.setString(1,ah.getId());
		ps.setString(2, ah.getName());
		ps.setString(3,ah.getFromDate());
		ps.setString(4,ah.getToDate());
		
		ps.setString(5,ah.getLeaveType());
		ps.setInt(6,ah.getNoOfDays());
		ps.setString(7, ah.getLeaveReason());
		ps.setInt(8, ah.getBalance());
		ps.setString(9,ah.getStatus());
		int i=ps.executeUpdate();
		if(i>0)
		{
			f=true;
		}
		else
		{
			f=false;
		}
	} catch (Exception e) {
		e.printStackTrace();
	}
	return f;
}
}
