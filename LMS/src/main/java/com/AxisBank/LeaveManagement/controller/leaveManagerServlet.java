package com.AxisBank.LeaveManagement.controller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.AxisBank.LeaveManagement.repository.ManagerLeaveDaoRepo;
import com.AxisBank.LeaveManagement.util.ManagerLeaveDaoRepoUtil;
import com.AxisBank.LeaveManagementSystem.dao.*;

import com.AxisBank.LeaveManagementSystem.databaseConnection.*;

import com.AxisBank.LeaveManagementSystem.entity.*;


import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@SuppressWarnings("serial")
@WebServlet("/applyManager")
public class leaveManagerServlet extends HttpServlet{

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String id=req.getParameter("id");
		String name=req.getParameter("name");
		String leaveType=req.getParameter("leaveType");
		String fromDate=req.getParameter("fromDate");
		String toDate=req.getParameter("toDate");
		String noOfDays=req.getParameter("noOfDays");
		String leaveReason=req.getParameter("leaveReason");
		int i=Integer.parseInt(noOfDays);
		int balance=0;int b=0;
		String status="Pending";String reciever="";
		HttpSession session=req.getSession();
		try {
			Connection conn=DbConnect.getConnection();
			String sql="SELECT LEAVE_BALANCE FROM leavemanagementsystem.leavebalance WHERE EMPLOYEE_ID=?;";
			PreparedStatement ps=conn.prepareStatement(sql);
			ps.setString(1, id);
			ResultSet rs=ps.executeQuery();
			while(rs.next())
			{
				b=rs.getInt(1);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			Connection conn=DbConnect.getConnection();
			String sql="SELECT Reporting_Email FROM leavemanagementsystem.employeedetails WHERE EMPLOYEE_ID=?;";
			PreparedStatement ps=conn.prepareStatement(sql);
			ps.setString(1, id);
			ResultSet rs=ps.executeQuery();
			while(rs.next())
			{
				reciever=rs.getString(1);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			String s=req.getParameter("leaveType");
            if(s.equalsIgnoreCase("Sick Leave")||s.equalsIgnoreCase("Casual Leave")||s.equalsIgnoreCase("Personal Leave")||s.equalsIgnoreCase("Marriage Leave"))
            {
            	balance=b;
            	if(i<=15){
            		ApplyLeaveManager a=new ApplyLeaveManager(id,name, leaveType, fromDate, toDate, i,
            				leaveReason, balance,status);
            		ManagerLeaveDaoRepo h=ManagerLeaveDaoRepoUtil.getObject();
        			boolean f=h.insert(a);
        			if(f==true)
        			{
        				String message="A manager has applied for a leave application. You are to make a decision on the applied leave application";
        				String subject="Leave Application";
        				Emails.sendEmail(message, subject,reciever, "suman.talukdar53@gmail.com");
        				session.setAttribute("successMessage2","Leave is submitted successfully !");
        				resp.sendRedirect("view/applyLeaveManager.jsp");
        			}
        			else
        			{
        				session.setAttribute("errorMessage2", "Leave is not submitted successfully !");
        				 resp.sendRedirect("view/applyLeaveManager.jsp");
        			}
            	 }
            	else
            	{
            	 session.setAttribute("errorMessage2", " Number of days is greater than the allotted category !");
   				 resp.sendRedirect("view/applyLeaveManager.jsp");
            	}
            }
            else if(s.equalsIgnoreCase("Paternity Leave")||s.equalsIgnoreCase("Adoption Leave"))
            {
            	balance=b;
            	if(i<=30)
            	{
            		String message="A manager has applied for a leave application. You are to make a decision on the applied leave application";
    				String subject="Leave Application";
    				Emails.sendEmail(message, subject,reciever, "suman.talukdar53@gmail.com");
    				ApplyLeaveManager a=new ApplyLeaveManager(id,name, leaveType, fromDate, toDate, i,
            				leaveReason, balance,status);
            		ManagerLeaveDaoRepo h=ManagerLeaveDaoRepoUtil.getObject();
        			boolean f=h.insert(a);
        			if(f==true)
        			{
        				session.setAttribute("successMessage2","Leave is submitted successfully !");
        				resp.sendRedirect("view/applyLeaveManager.jsp");
        			}
        			else
        			{
        				session.setAttribute("errorMessage2", "Leave is not submitted successfully !");
        				 resp.sendRedirect("view/applyLeaveManager.jsp");
        			}	
            	}
            	else{
            		session.setAttribute("errorMessage2", " Number of days is greater than the allotted category !");
      				 resp.sendRedirect("view/applyLeaveManager.jsp");
            	}
            }
            else
            {
            	balance=b;
            	ApplyLeaveManager a=new ApplyLeaveManager(id,name, leaveType, fromDate, toDate, i,
        				leaveReason, balance,status);
        		ManagerLeaveDaoRepo h=ManagerLeaveDaoRepoUtil.getObject();
    			boolean f=h.insert(a);
    			if(f==true)
    			{
    				String message="A manager has applied for a leave application. You are to make a decision on the applied leave application";
    				String subject="Leave Application";
    				Emails.sendEmail(message, subject,reciever, "suman.talukdar53@gmail.com");
    				session.setAttribute("successMessage2","Leave is submitted successfully !");
    				resp.sendRedirect("view/applyLeaveManager.jsp");
    			}
    			else
    			{
    				session.setAttribute("errorMessage2", "Leave is not submitted successfully !");
    				 resp.sendRedirect("view/applyLeaveManager.jsp");
    			}
            }
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
