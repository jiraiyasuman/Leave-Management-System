package com.AxisBank.LeaveManagement.controller;

import java.io.IOException;
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
@WebServlet("/SMRegister")
public class smRegistrationServlet extends HttpServlet{

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String name=req.getParameter("name");
		String email=req.getParameter("email");
		String password=req.getParameter("password");
		 String password1=Cipher.encryption(password);
		HttpSession session=req.getSession();
		try {
			SmLogin s=new SmLogin(name,email,password1);
			SmLoginDao s1=new SmLoginDao(DbConnect.getConnection());
			boolean f=s1.insert(s);
			if(f==true)
			{
				session.setAttribute("successMessage1","Registration is successful !");
				resp.sendRedirect("view/regSeniorManager.jsp");
			}
			else
			{
				session.setAttribute("errorMessage1", "Registration is not successful !");
				 resp.sendRedirect("view/regSeniorManager.jsp");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
