package com.AxisBank.LeaveManagementSystem.dao;
import java.sql.*;

import com.AxisBank.LeaveManagement.repository.ManageSMDaoRepo;
import com.AxisBank.LeaveManagementSystem.databaseConnection.DbConnect;
import com.AxisBank.LeaveManagementSystem.entity.ManageLeavesSM;

public class ManageSMDao implements ManageSMDaoRepo{
public static Connection conn=null;
public static ManageLeavesSM m=null;
public ManageSMDao(Connection conn)
{
	this.conn=conn;
}
public boolean insert(ManageLeavesSM m) throws Exception
{
	boolean f=false;
	String sql="UPDATE `leavemanagementsystem`.`finalleaverecordhigherups` SET NAME=?,FROM_DATE=?,TO_DATE=?,LEAVE_TYPE=?,NO_OF_DAYS=?,LEAVE_REASON=?,LEAVE_BALANCE=?,STATUS=? WHERE EMPLOYEE_ID=?;";
	try {
		Connection conn=DbConnect.getConnection();
		PreparedStatement ps=conn.prepareStatement(sql);
		
		ps.setString(1,m.getName());
		ps.setString(2,m.getFromDate());
		ps.setString(3,m.getToDate());
		ps.setString(4,m.getLeaveType());
		ps.setInt(5,m.getNoOfDays());
		ps.setString(6,m.getLeaveReason());
		ps.setInt(7,m.getBalance());
		ps.setString(8,m.getStatus());
		ps.setString(9, m.getId());
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
