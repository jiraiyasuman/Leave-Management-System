package com.AxisBank.LeaveManagementSystem.dao;
import java.sql.*;

import com.AxisBank.LeaveManagement.repository.ProjectDaoRepo;
import com.AxisBank.LeaveManagementSystem.databaseConnection.DbConnect;
import com.AxisBank.LeaveManagementSystem.entity.Project;

public class ProjectDao implements ProjectDaoRepo{
Connection conn=null;
Project p=null;
public ProjectDao(Connection conn)
{
	this.conn=conn;
}
public boolean insert(Project p)
{
	boolean f=false;
	try {
		Connection conn=DbConnect.getConnection();
		String sql="INSERT INTO `leavemanagementsystem`.`project` (`Name of the Project`, `From Date`, `To Date`, `Description`) VALUES (?,?,?,?);";
		PreparedStatement ps=conn.prepareStatement(sql);
		ps.setString(1, p.getName());
		ps.setString(2,p.getFromDate());
		ps.setString(3, p.getToDate());
		ps.setString(4, p.getDescription());
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
