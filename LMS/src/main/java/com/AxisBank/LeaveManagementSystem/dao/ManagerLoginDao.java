package com.AxisBank.LeaveManagementSystem.dao;
import java.sql.*;

import com.AxisBank.LeaveManagement.repository.ManagerLoginDaoRepo;
import com.AxisBank.LeaveManagementSystem.databaseConnection.DbConnect;
import com.AxisBank.LeaveManagementSystem.entity.LoginManager;
public class ManagerLoginDao implements ManagerLoginDaoRepo{
public static Connection conn=null;
public static LoginManager l=null;
public ManagerLoginDao(Connection conn)
{
	this.conn=conn;
}
public boolean insert(LoginManager l)throws Exception
{
	boolean f=false;
	try {
		String sql="INSERT INTO `leavemanagementsystem`.`loginmanager` (`Name`, `Email`, `Password`) VALUES (?,?,?);";
		Connection conn=DbConnect.getConnection();
		PreparedStatement ps=conn.prepareStatement(sql);
		ps.setString(1, l.getName());
		ps.setString(2, l.getEmail());
		ps.setString(3, l.getPassword());
		int z=ps.executeUpdate();
		if(z>0)
		{
			f=true;
		}else {
			f=false;
		}
	} catch (Exception e) {
		e.printStackTrace();
	}
	
	return f;
}
public LoginManager display(String email, String password)throws Exception
{
	try {
		String sql="SELECT * FROM leavemanagementsystem.loginmanager WHERE Email=? AND Password=?";
		conn=DbConnect.getConnection();
		PreparedStatement ps=conn.prepareStatement(sql);
		ps.setString(1, email);
		ps.setString(2, password);
		ResultSet rs=ps.executeQuery();
		while(rs.next())
		{
			l=new LoginManager();
			l.setName(rs.getString(1));
			l.setEmail(rs.getString(2));
			l.setPassword(rs.getString(3));
		}
		
	} catch (Exception e) {
		e.printStackTrace();
	}
	return l;
}
public boolean update(String user,String password)
{
	boolean f=false;
	try {
		String sql="UPDATE leavemanagementsystem.loginmanager SET Password='"+password+"' WHERE Email='"+user+"'";
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
