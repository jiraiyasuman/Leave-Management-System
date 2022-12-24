package com.AxisBank.LeaveManagementSystem.dao;
import java.sql.*;

import com.AxisBank.LeaveManagement.repository.ApplyLeaveSMRepo;
import com.AxisBank.LeaveManagementSystem.databaseConnection.DbConnect;
import com.AxisBank.LeaveManagementSystem.entity.ApplyLeaveSM;


public class ApplyLeaveSMDao implements ApplyLeaveSMRepo {
public Connection conn=null;
public ApplyLeaveSM ah=null;
public ApplyLeaveSMDao(Connection conn)
{
	this.conn=conn;
}
public boolean insert(ApplyLeaveSM m) {
	boolean f=false;
	try {
		String sql="INSERT INTO `leavemanagementsystem`.`finalleaverecordseniormanager` (`EMPLOYEE_ID`, `NAME`, `FROM_DATE`, `TO_DATE`, `LEAVE_TYPE`, `NO_OF_DAYS`, `LEAVE_REASON`,`LEAVE_BALANCE`,`STATUS`) VALUES (?,?,?,?,?,?,?,?,?);";
		Connection conn=DbConnect.getConnection();
		PreparedStatement ps=conn.prepareStatement(sql);
		ps.setString(1, m.getId());
		ps.setString(2,m.getName());
		ps.setString(3,m.getFromDate());
		ps.setString(4,m.getToDate());
		ps.setString(5,m.getLeaveType());
		ps.setInt(6,m.getNoOfDays());
		ps.setString(7,m.getLeaveReason());
		ps.setInt(8,m.getBalance());
		ps.setString(9,m.getStatus());
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
