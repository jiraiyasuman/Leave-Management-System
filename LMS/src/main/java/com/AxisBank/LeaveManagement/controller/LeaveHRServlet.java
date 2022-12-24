package com.AxisBank.LeaveManagement.controller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.AxisBank.LeaveManagement.repository.HrLeaveDaoRepo;
import com.AxisBank.LeaveManagement.util.HrLeaveDaoRepoUtil;
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
@WebServlet("/leaveHR")
public class LeaveHRServlet extends HttpServlet{

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
            		ApplyLeaveHR a=new ApplyLeaveHR(id, name, fromDate, toDate,  leaveType,i,
            				leaveReason, balance, status);
            		HrLeaveDaoRepo h=HrLeaveDaoRepoUtil.getObject();
        			boolean f=h.insert(a);
        			if(f==true)
        			{
        				String message="An HR has applied for a leave application. You are to make a decision on the applied leave application";
        				String subject="Leave Application";
        				Emails.sendEmail(message, subject,reciever, "suman.talukdar53@gmail.com");
        				session.setAttribute("successMessage1","Leave is submitted successfully !");
        				resp.sendRedirect("view/applyLeaveHR.jsp");
        			}
        			else
        			{
        				session.setAttribute("errorMessage1", "Leave is not submitted successfully !");
        				 resp.sendRedirect("view/applyLeaveHR.jsp");
        			}
            	 }
            	else
            	{
            	 session.setAttribute("errorMessage1", " Number of days is greater than the allotted category !");
   				 resp.sendRedirect("view/applyLeaveHR.jsp");
            	}
            }
            else if(s.equalsIgnoreCase("Paternity Leave")||s.equalsIgnoreCase("Adoption Leave"))
            {
            	balance=b;
            	if(i<=30)
            	{
            		ApplyLeaveHR a=new ApplyLeaveHR(id, name, fromDate, toDate,  leaveType, i,
            				leaveReason, balance, status);
            		HrLeaveDaoRepo h=HrLeaveDaoRepoUtil.getObject();
        			boolean f=h.insert(a);
        			if(f==true)
        			{
        				String message="An HR has applied for a leave application. You are to make a decision on the applied leave application";
        				String subject="Leave Application";
        				Emails.sendEmail(message, subject,reciever, "suman.talukdar53@gmail.com");
        				session.setAttribute("successMessage1","Leave is submitted successfully !");
        				resp.sendRedirect("view/applyLeaveHR.jsp");
        			}
        			else
        			{
        				session.setAttribute("errorMessage1", "Leave is not submitted successfully !");
        				 resp.sendRedirect("view/applyLeaveHR.jsp");
        			}	
            	}
            	else{
            		session.setAttribute("errorMessage1", " Number of days is greater than the allotted category !");
      				 resp.sendRedirect("view/applyLeaveHR.jsp");
            	}
            }
            else
            {
            	balance=b;
            	ApplyLeaveHR a=new ApplyLeaveHR(id, name, fromDate, toDate,  leaveType, i,
        				leaveReason, balance, status);
            	HrLeaveDaoRepo h=HrLeaveDaoRepoUtil.getObject();
    			boolean f=h.insert(a);
    			if(f==true)
    			{
    				String message="An HR has applied for a leave application. You are to make a decision on the applied leave application";
    				String subject="Leave Application";
    				Emails.sendEmail(message, subject,reciever, "suman.talukdar53@gmail.com");
    				session.setAttribute("successMessage1","Leave is submitted successfully !");
    				resp.sendRedirect("view/applyLeaveHR.jsp");
    			}
    			else
    			{
    				session.setAttribute("errorMessage1", "Leave is not submitted successfully !");
    				 resp.sendRedirect("view/applyLeaveHR.jsp");
    			}
            }
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
