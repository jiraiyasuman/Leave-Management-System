package com.AxisBank.LeaveManagementSystem.dao;
import java.sql.*;

import com.AxisBank.LeaveManagement.repository.HrDaoLoginRepo;
import com.AxisBank.LeaveManagementSystem.dao.*;
import com.AxisBank.LeaveManagementSystem.databaseConnection.DbConnect;
import com.AxisBank.LeaveManagementSystem.entity.HrLogin;
@SuppressWarnings("unused")
public class HrDaoLogin implements HrDaoLoginRepo{
	private static Connection conn=null;
	private static HrLogin h=null;
	public HrDaoLogin(Connection conn)
	{
		this.conn=conn;
	}
	public boolean insert(HrLogin h)throws Exception
	{
		boolean f=false;
		try {
			String sql="INSERT INTO `leavemanagementsystem`.`loginhr` (`Name`, `Email`, `Password`) VALUES (?, ?, ?);";
	        conn=DbConnect.getConnection();
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
	public HrLogin display(String email,String password)throws Exception
	{
		try {
			String sql="SELECT * FROM leavemanagementsystem.loginhr WHERE Email=? AND Password=?";
			conn=DbConnect.getConnection();
			PreparedStatement ps=conn.prepareStatement(sql);
			ps.setString(1, email);
			ps.setString(2, password);
			ResultSet rs=ps.executeQuery();
			while(rs.next())
			{
				h=new HrLogin();
				h.setName(rs.getString(1));
				h.setEmail(rs.getString(2));
				h.setPassword(rs.getString(3));
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return h;
	}
	public boolean update(String user,String password)
	{
		boolean f=false;
		try {
			String sql="UPDATE leavemanagementsystem.loginhr SET Password='"+password+"' WHERE Email='"+user+"'";
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
