package com.AxisBank.LeaveManagementSystem.dao;
import java.sql.*;

import com.AxisBank.LeaveManagement.repository.EmployeeLoginRepo;
import com.AxisBank.LeaveManagementSystem.databaseConnection.DbConnect;
import com.AxisBank.LeaveManagementSystem.entity.EmployeeLogin;
public class EmployeeLoginDao implements EmployeeLoginRepo{
public static Connection conn=null;
public static EmployeeLogin h=null;
@SuppressWarnings("static-access")
public EmployeeLoginDao(Connection conn)
{
	this.conn=conn;
}
public boolean insert(EmployeeLogin h)throws Exception
{
	boolean f=false;
	try {
		String sql="INSERT INTO `leavemanagementsystem`.`loginemployee` (`Name`, `Email`, `Password`) VALUES (?, ?, ?);";
		PreparedStatement ps=conn.prepareStatement(sql);
		ps.setString(1,h.getName());
		ps.setString(2,h.getEmail());
		ps.setString(3,h.getPassword());
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
public EmployeeLogin display(String email,String password)throws Exception
{
	try {
		String sql="SELECT * FROM leavemanagementsystem.loginemployee WHERE Email=? AND Password=?";
		conn=DbConnect.getConnection();
		PreparedStatement ps=conn.prepareStatement(sql);
		ps.setString(1, email);
		ps.setString(2, password);
		ResultSet rs=ps.executeQuery();
		while(rs.next())
		{
			h=new EmployeeLogin();
			h.setName(rs.getString(1));
			h.setEmail(rs.getString(2));
			h.setPassword(rs.getString(3));
		}
		
	} catch (Exception e) {
		e.printStackTrace();
	}
	return h;
}
public  boolean update(String user,String password)
{
	boolean f=false;
	try {
		String sql="UPDATE leavemanagementsystem.loginemployee SET Password='"+password+"' WHERE Email='"+user+"'";
		Connection conn=DbConnect.getConnection();
		PreparedStatement ps=conn.prepareStatement(sql);
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
