package com.AxisBank.LeaveManagement.controller;

import java.io.IOException;

import com.AxisBank.LeaveManagement.repository.EmployeeLoginRepo;
import com.AxisBank.LeaveManagementSystem.dao.EmployeeLoginDao;
import com.AxisBank.LeaveManagementSystem.databaseConnection.Cipher;
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
@WebServlet("/empLogin")
public class employeeLoginServlet extends HttpServlet{

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String email=req.getParameter("email");
		String password=req.getParameter("password");
		 String password1=Cipher.encryption(password);
		HttpSession session=req.getSession();
		try {
			EmployeeLoginRepo h=new EmployeeLoginDao(DbConnect.getConnection());
			EmployeeLogin hr=h.display(email,password1);
			if(hr!=null)
			{
				
				boolean f=true;
				 if(f==true) {
					 session.setAttribute("empObj", new HrLogin());
					 req.setAttribute("user",email);
					 session.setAttribute("successMessage","Login is successful !");
				resp.sendRedirect("view/homeemployee.jsp");
				 }
			}
			else
			{
				session.setAttribute("errorMessage", "Invalid email and password !");
				 resp.sendRedirect("view/loginemployee.jsp");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
