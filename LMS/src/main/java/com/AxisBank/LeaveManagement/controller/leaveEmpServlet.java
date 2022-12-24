package com.AxisBank.LeaveManagement.controller;

import java.io.IOException;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.AxisBank.LeaveManagement.repository.EmpLeaveDaoRepo;
import com.AxisBank.LeaveManagement.util.EmpLeaveDaoRepoUtil;
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
@WebServlet("/empLeave")
public class leaveEmpServlet extends HttpServlet{

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String id=req.getParameter("id");
		String name=req.getParameter("name");
		String fromDate=req.getParameter("fromDate");
		String toDate=req.getParameter("toDate");
		String leaveType=req.getParameter("leaveType");
		String noOfDays=req.getParameter("noOfDays");
		String leaveReason=req.getParameter("leaveReason");
		String status="Pending";int b=0;String reciever="";
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
		int i=Integer.parseInt(noOfDays);
		int balance=0;
		try {
			String s=req.getParameter("leaveType");
            if(s.equalsIgnoreCase("Sick Leave")||s.equalsIgnoreCase("Casual Leave")||s.equalsIgnoreCase("Personal Leave")||s.equalsIgnoreCase("Marriage Leave"))
            {
            	
            		balance=b;
            	if(i<=15){
            		ApplyLeaveEmployee a=new ApplyLeaveEmployee( id, name, fromDate, toDate, leaveType, i,
            			leaveReason, balance, status);
            		EmpLeaveDaoRepo h=EmpLeaveDaoRepoUtil.getObject();
        			boolean f=h.insert(a);
        			if(f==true)
        			{
        				String message="An Employee has applied for a leave application. You are to make a decision on the applied leave application";
        				String subject="Leave Application";
        				Emails.sendEmail(message, subject,reciever, "suman.talukdar53@gmail.com");
        				session.setAttribute("successMessage1","Leave is submitted successfully !");
        				resp.sendRedirect("view/applyleave.jsp");
        			}
        			else
        			{
        				session.setAttribute("errorMessage1", "Leave is not submitted successfully !");
        				 resp.sendRedirect("view/applyleave.jsp");
        			}
            	 }
            	else
            	{
            	 session.setAttribute("errorMessage1", " Number of days is greater than the allotted category !");
   				 resp.sendRedirect("view/applyleave.jsp");
            	}
            }
            else if(s.equalsIgnoreCase("Paternity Leave")||s.equalsIgnoreCase("Adoption Leave"))
            {
            	
            		balance=b;
            	if(i<=30)
            	{
            		ApplyLeaveEmployee a=new ApplyLeaveEmployee(id, name, fromDate, toDate, leaveType, i,
                			leaveReason, balance, status);
            		EmpLeaveDaoRepo h=EmpLeaveDaoRepoUtil.getObject();
        			boolean f=h.insert(a);
        			if(f==true)
        			{
        				String message="An Employee has applied for a leave application. You are to make a decision on the applied leave application";
        				String subject="Leave Application";
        				Emails.sendEmail(message, subject,reciever, "suman.talukdar53@gmail.com");
        				session.setAttribute("successMessage1","Leave is submitted successfully !");
        				resp.sendRedirect("view/applyleave.jsp");
        			}
        			else
        			{
        				session.setAttribute("errorMessage1", "Leave is not submitted successfully !");
        				 resp.sendRedirect("view/applyleave.jsp");
        			}	
            	}
            	else{
            		session.setAttribute("errorMessage1", " Number of days is greater than the allotted category !");
      				 resp.sendRedirect("view/applyleave.jsp");
            	}
            }
            else
            {
            	
            		balance=b;
            	ApplyLeaveEmployee a=new ApplyLeaveEmployee(id, name, fromDate, toDate, leaveType, i,
            			leaveReason, balance, status);
            	EmpLeaveDaoRepo h=EmpLeaveDaoRepoUtil.getObject();
    			boolean f=h.insert(a);
    			if(f==true)
    			{
    				String message="An Employee has applied for a leave application. You are to make a decision on the applied leave application";
    				String subject="Leave Application";
    				Emails.sendEmail(message, subject,reciever, "suman.talukdar53@gmail.com");
    				session.setAttribute("successMessage1","Leave is submitted successfully !");
    				resp.sendRedirect("view/applyleave.jsp");
    			}
    			else
    			{
    				session.setAttribute("errorMessage1", "Leave is not submitted successfully !");
    				 resp.sendRedirect("view/applyleave.jsp");
    			}
            }
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
