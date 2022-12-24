package com.AxisBank.LeaveManagement.controller;

import java.io.IOException;

import com.AxisBank.LeaveManagement.repository.NewEmployeeDaoRepo;
import com.AxisBank.LeaveManagement.util.NewEmployeeDaoRepoUtil;
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
@WebServlet("/employeeAdd")
public class NewEmployeeServlet extends HttpServlet{

	@SuppressWarnings("unused")
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String name=req.getParameter("fullName");
		String gender=req.getParameter("gender");
		String email=req.getParameter("email");
		String phNumber=req.getParameter("phoneNumber");
		String role=req.getParameter("role");
		String reporting=req.getParameter("reporting");
		String reportingName=req.getParameter("reportingName");
		String reportingEmail=req.getParameter("reportingEmail");
		try {
			HttpSession session=req.getSession();
			int z=(int)Math.floor(Math.random()*(1000000-1+1)+1);
			String id="EMP"+Integer.toString(z);
			AddNewEmployee a= new AddNewEmployee(id,name, gender, email,phNumber,role,reporting,reportingName,reportingEmail);
			NewEmployeeDaoRepo n= NewEmployeeDaoRepoUtil.getObject();
			boolean z1=n.insert(a);
			if(z1==true)
			{
				
				session.setAttribute("successMessage4","New Employee Addition is successful !");
				resp.sendRedirect("view/registration.jsp");
				
			}
			else
			{
				session.setAttribute("errorMessage4", "New Employee Addition is not successful !");
				resp.sendRedirect("view/registration.jsp");
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	
	
}
