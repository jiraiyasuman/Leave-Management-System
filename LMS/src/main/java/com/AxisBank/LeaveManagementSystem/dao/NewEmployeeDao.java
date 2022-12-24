package com.AxisBank.LeaveManagementSystem.dao;
import java.sql.Connection;
import java.sql.PreparedStatement;

import com.AxisBank.LeaveManagement.repository.NewEmployeeDaoRepo;
import com.AxisBank.LeaveManagementSystem.databaseConnection.DbConnect;
import com.AxisBank.LeaveManagementSystem.entity.AddNewEmployee;

public class NewEmployeeDao implements NewEmployeeDaoRepo{
public static Connection conn=null; 
public static AddNewEmployee a=null;
public NewEmployeeDao(Connection conn)
{
	this.conn=conn;
}
public boolean insert(AddNewEmployee a)throws Exception
{
	boolean f=false;
	try {
		
		String sql="INSERT INTO `leavemanagementsystem`.`employeedetails` (`EmployeeId`, `Full Name`, `Gender`, `Email`, `Phone Number`,`Role`,`Reporting_Person`,`Reporting_Name`,`Reporting_Email`) VALUES (?,?,?,?, ?,?);";
		PreparedStatement ps=conn.prepareStatement(sql);
		ps.setString(1,a.getId());
		ps.setString(2,a.getName());
		ps.setString(3,a.getGender());
		ps.setString(4,a.getEmail());
		ps.setString(5,a.getPhNumber());
		ps.setString(6,a.getRole());
		ps.setString(7,a.getReporting());
		ps.setString(8,a.getReportingName());
		ps.setString(9,a.getReportingEmail());
		int i=ps.executeUpdate();
		if(i>0)
			f=true;
		else
			f=false;
	} catch (Exception e) {
		e.printStackTrace();
	}
	
	return f;
}
public boolean update(String id) {
	boolean f=false;
	try {
		String sql="DELETE FROM leavemanagementsystem.employeedetails WHERE EmployeeId=?;";
		Connection conn=DbConnect.getConnection();
		PreparedStatement ps=conn.prepareStatement(sql);
		ps.setString(1,id);
		int z=ps.executeUpdate();
		if(z>0)
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
