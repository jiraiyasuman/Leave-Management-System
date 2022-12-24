package com.AxisBank.LeaveManagement.controller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.AxisBank.LeaveManagement.repository.ApplyLeaveSMRepo;
import com.AxisBank.LeaveManagement.util.ApplyLeaveSMRepoUtil;
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
@WebServlet("/applyLeaveSM")
public class leaveSMServlet extends HttpServlet{

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String id=req.getParameter("id");
		String name=req.getParameter("name");
		String fromDate=req.getParameter("fromDate");
		String toDate=req.getParameter("toDate");
		String leaveType=req.getParameter("leaveType");
		String leaveReason=req.getParameter("leaveReason");
		String noOfDays=req.getParameter("noOfDays");
		HttpSession session=req.getSession();
		int i=Integer.parseInt(noOfDays);
		int balance=0;int b=0;
		String status="pending";String reciever="";
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
            		ApplyLeaveSM a=new ApplyLeaveSM(id, name, fromDate, toDate,leaveType, i,
            				leaveReason, balance, status);
            		ApplyLeaveSMRepo h=ApplyLeaveSMRepoUtil.getObject();
        			boolean f=h.insert(a);
        			if(f==true)
        			{
        				String message="A senior Manager has applied for a leave application. You are to make a decision on the applied leave application";
        				String subject="Leave Application";
        				Emails.sendEmail(message, subject,reciever, "suman.talukdar53@gmail.com");
        				session.setAttribute("successMessage2","Leave is submitted successfully !");
        				resp.sendRedirect("view/manageSeniorManager.jsp");
        			}
        			else
        			{
        				session.setAttribute("errorMessage2", "Leave is not submitted successfully !");
        				 resp.sendRedirect("view/manageSeniorManager.jsp");
        			}
            	 }
            	else
            	{
            	 session.setAttribute("errorMessage2", " Number of days is greater than the allotted category !");
   				 resp.sendRedirect("view/manageSeniorManager.jsp");
            	}
            }
            else if(s.equalsIgnoreCase("Paternity Leave")||s.equalsIgnoreCase("Adoption Leave"))
            {
            	balance=b;
            	if(i<=30)
            	{
            		ApplyLeaveSM a=new ApplyLeaveSM(id, name, fromDate, toDate,leaveType, i,
            				leaveReason, balance, status);
            		ApplyLeaveSMRepo h=ApplyLeaveSMRepoUtil.getObject();
        			boolean f=h.insert(a);
        			if(f==true)
        			{
        				String message="A senior Manager has applied for a leave application. You are to make a decision on the applied leave application";
        				String subject="Leave Application";
        				Emails.sendEmail(message, subject,reciever, "suman.talukdar53@gmail.com");
        				session.setAttribute("successMessage2","Leave is submitted successfully !");
        				resp.sendRedirect("view/manageSeniorManager.jsp");
        			}
        			else
        			{
        				session.setAttribute("errorMessage2", "Leave is not submitted successfully !");
        				 resp.sendRedirect("view/manageSeniorManager.jsp");
        			}	
            	}
            	else{
            		session.setAttribute("errorMessage2", " Number of days is greater than the allotted category !");
      				 resp.sendRedirect("view/manageSeniorManager.jsp");
            	}
            }
            else
            {
            	balance=b;
            	ApplyLeaveSM a=new ApplyLeaveSM(id, name, fromDate, toDate,leaveType, i,
        				leaveReason, balance, status);
            	ApplyLeaveSMRepo h=ApplyLeaveSMRepoUtil.getObject();
    			boolean f=h.insert(a);
    			if(f==true)
    			{
    				String message="A senior Manager has applied for a leave application. You are to make a decision on the applied leave application";
    				String subject="Leave Application";
    				Emails.sendEmail(message, subject,reciever, "suman.talukdar53@gmail.com");
    				session.setAttribute("successMessage2","Leave is submitted successfully !");
    				resp.sendRedirect("view/manageSeniorManager.jsp");
    			}
    			else
    			{
    				session.setAttribute("errorMessage2", "Leave is not submitted successfully !");
    				 resp.sendRedirect("view/manageSeniorManager.jsp");
    			}
            }
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
