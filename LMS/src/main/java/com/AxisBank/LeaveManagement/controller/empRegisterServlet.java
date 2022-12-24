package com.AxisBank.LeaveManagement.controller;

import java.io.IOException;

import com.AxisBank.LeaveManagementSystem.dao.EmployeeLoginDao;
import com.AxisBank.LeaveManagementSystem.databaseConnection.DbConnect;
import com.AxisBank.LeaveManagementSystem.entity.EmployeeLogin;
import com.AxisBank.LeaveManagementSystem.entity.HrLogin;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
@SuppressWarnings("serial")
@WebServlet("/EmpRegister")
public class empRegisterServlet extends HttpServlet{
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String name=req.getParameter("name");
		String email=req.getParameter("email");
		String password=req.getParameter("password");
		try {
			HttpSession session=req.getSession();
			EmployeeLogin hr=new EmployeeLogin(name,email,password);
			EmployeeLoginDao h=new EmployeeLoginDao(DbConnect.getConnection());
			boolean f=h.insert(hr);
			if(hr!=null)
			{
				session.setAttribute("userObj", new HrLogin());
				
				 if(f==true) {
					 session.setAttribute("successMessage5","Registration is successful !");
				resp.sendRedirect("view/regEmp.jsp");
				 }
			}
			else
			{
				session.setAttribute("errorMessage5", "Registration is not successful !");
				 resp.sendRedirect("view/regEmp.jsp");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
