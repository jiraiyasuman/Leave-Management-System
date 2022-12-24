package com.AxisBank.LeaveManagementSystem.databaseConnection;
import java.sql.*;
import java.util.Properties;
import java.io.*;
public class DbConnect {
@SuppressWarnings("static-access")
public static void main(String args[])throws Exception
{
	DbConnect ob=new DbConnect();
	ob.getConnection();
}
public static Connection getConnection()throws Exception
{
	try {
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/leavemanagementsystem","root","12345");
		System.out.println("Connection is successful");
		 return conn;
	} catch (Exception e) {
		System.out.println(e);
	}
	return null;
}
}
