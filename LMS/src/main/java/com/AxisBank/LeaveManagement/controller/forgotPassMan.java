package com.AxisBank.LeaveManagement.controller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.AxisBank.LeaveManagementSystem.databaseConnection.*;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@SuppressWarnings("serial")
@WebServlet("/forgotm")
public class forgotPassMan extends HttpServlet{
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String email=req.getParameter("email");
		HttpSession session=req.getSession();
		String p="";
		try {
			Connection conn=DbConnect.getConnection();
			String sql="SELECT Password FROM leavemanagementsystem.loginmanager WHERE Email=?";
			PreparedStatement ps=conn.prepareStatement(sql);
			ps.setString(1, email);
			ResultSet rs=ps.executeQuery();
			while(rs.next())
			{
				p=rs.getString(1);
			}
			String password1=Cipher.decryption(p);
			String message="Your password is "+password1;
			String sub="Password";
			Emails.sendEmail(message, sub, email, "suman.talukdar53@gmail.com");
		} catch (Exception e) {
		 e.printStackTrace();
		}
	}
}
