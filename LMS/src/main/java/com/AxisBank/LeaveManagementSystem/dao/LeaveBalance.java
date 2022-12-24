package com.AxisBank.LeaveManagementSystem.dao;
import java.sql.*;

import com.AxisBank.LeaveManagement.repository.LeaveBalanceRepo;
import com.AxisBank.LeaveManagementSystem.databaseConnection.DbConnect;

public class LeaveBalance implements LeaveBalanceRepo {
public Connection conn=null;

	public LeaveBalance() {
}

	public LeaveBalance(Connection connection) {
		this.conn=connection;
	}

	public  void update(String id, String leaveType, int balance)
	{
		if(leaveType.equalsIgnoreCase("sick leave"))
		{
			try {
				String sql="UPDATE leavemanagementsystem.leavebalance SET SICK_LEAVE=? WHERE EMPLOYEE_ID=?";
				Connection conn=DbConnect.getConnection();
				PreparedStatement ps=conn.prepareStatement(sql);
				ps.setInt(1, balance);
				ps.setString(2,id );
				ps.executeUpdate();
			} catch (Exception e) {
				e.printStackTrace();
			}
			
		}else if(leaveType.equalsIgnoreCase("casual leave"))
		{
			try {
				String sql="UPDATE leavemanagementsystem.leavebalance SET CASUAL_LEAVE=? WHERE EMPLOYEE_ID=?";
				Connection conn=DbConnect.getConnection();
				PreparedStatement ps=conn.prepareStatement(sql);
				ps.setInt(1, balance);
				ps.setString(2,id );
				ps.executeUpdate();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}else if(leaveType.equalsIgnoreCase("personal leave"))
		{
			try {
				String sql="UPDATE leavemanagementsystem.leavebalance SET PERSONAL_LEAVE=? WHERE EMPLOYEE_ID=?";
				Connection conn=DbConnect.getConnection();
				PreparedStatement ps=conn.prepareStatement(sql);
				ps.setInt(1, balance);
				ps.setString(2,id );
				ps.executeUpdate();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}else if(leaveType.equalsIgnoreCase("maternity leave"))
		{
			try {
				String sql="UPDATE leavemanagementsystem.leavebalance SET MATERNITY_LEAVE=? WHERE EMPLOYEE_ID=?";
				Connection conn=DbConnect.getConnection();
				PreparedStatement ps=conn.prepareStatement(sql);
				ps.setInt(1, balance);
				ps.setString(2,id );
				ps.executeUpdate();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}else if(leaveType.equalsIgnoreCase("paternity leave"))
		{
			try {
				String sql="UPDATE leavemanagementsystem.leavebalance SET PATERNITY_LEAVE=? WHERE EMPLOYEE_ID=?";
				Connection conn=DbConnect.getConnection();
				PreparedStatement ps=conn.prepareStatement(sql);
				ps.setInt(1, balance);
				ps.setString(2,id );
				ps.executeUpdate();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}else if(leaveType.equalsIgnoreCase("adoption leave"))
		{
			try {
				String sql="UPDATE leavemanagementsystem.leavebalance SET ADOPTION_LEAVE=? WHERE EMPLOYEE_ID=?";
				Connection conn=DbConnect.getConnection();
				PreparedStatement ps=conn.prepareStatement(sql);
				ps.setInt(1, balance);
				ps.setString(2,id );
				ps.executeUpdate();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		else
		{
			try {
				String sql="UPDATE leavemanagementsystem.leavebalance SET MARRIAGE_LEAVE=? WHERE EMPLOYEE_ID=?";
				Connection conn=DbConnect.getConnection();
				PreparedStatement ps=conn.prepareStatement(sql);
				ps.setInt(1, balance);
				ps.setString(2,id );
				ps.executeUpdate();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
}
