package com.AxisBank.LeaveManagementSystem.entity;
import java.io.*;
import java.sql.*;

import com.AxisBank.LeaveManagementSystem.databaseConnection.DbConnect;

public class AllottedHolidays {
private static String hName;
private static int days;
public static void main(String args[])throws Exception
{
	BufferedReader BR=new BufferedReader(new InputStreamReader(System.in));
	try {
		System.out.println("Please enter the name of the holiday");
		hName=BR.readLine();
		System.out.println("Please enter the number of days allotted for that type of holidays");
		days=Integer.parseInt(BR.readLine());
		Connection conn=DbConnect.getConnection();
		String sql="INSERT INTO `leavemanagementsystem`.`allottedholidays` (`Holiday_Name`, `No_of_Days`) VALUES (?,?);";
		PreparedStatement ps=conn.prepareStatement(sql);
		ps.setString(1,hName);
		ps.setInt(2, days);
		int z=ps.executeUpdate();
		if(z!=0)
		{
			System.out.println("A record has been inserted successfully");
		}
		else
		{
			System.out.println("A record has not been inserted successfully");
		}
	} catch (Exception e) {
		e.printStackTrace();
	}
}
}
