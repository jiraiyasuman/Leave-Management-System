package com.AxisBank.LeaveManagement.controller;

import java.io.IOException;
import com.AxisBank.LeaveManagementSystem.dao.*;

import com.AxisBank.LeaveManagementSystem.databaseConnection.*;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@SuppressWarnings("serial")
@WebServlet("/changeEmp")
public class passwordUpdateEmployeeServlet extends HttpServlet{

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String email=req.getParameter("email");
		String newpassword=req.getParameter("newpassword");
		String confirmpassword=req.getParameter("confirmpassword");
		String password1=Cipher.encryption(newpassword);
		try {
			HttpSession session=req.getSession();
			EmployeeLoginDao h=new EmployeeLoginDao(DbConnect.getConnection());
			boolean hr=h.update(email,password1);
			if(hr==true)
			{
				session.setAttribute("successMessage7","Password is successfully updated !");
				resp.sendRedirect("view/pcEmp.jsp");
			}
			else
			{
				session.setAttribute("errorMessage7", "Password is not updated successfully !");
				 resp.sendRedirect("view/pcEmp.jsp");
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}	
	}
}
