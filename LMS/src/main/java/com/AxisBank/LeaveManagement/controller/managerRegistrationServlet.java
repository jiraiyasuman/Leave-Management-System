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
@WebServlet("/managerRegister")
public class managerRegistrationServlet extends HttpServlet{

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String name=req.getParameter("name");
		String user=req.getParameter("email");
		String password=req.getParameter("password");
		 String password1=Cipher.encryption(password);
		try {
			HttpSession session=req.getSession();
			LoginManager lm=new LoginManager(name,user,password1);
			ManagerLoginDao m=new ManagerLoginDao(DbConnect.getConnection());
			boolean f=m.insert(lm);
			if(lm!=null)
			{
				session.setAttribute("regObj", new LoginManager());
				if(f==true)
				{
					session.setAttribute("successMessage1","Registration is successful !");
					resp.sendRedirect("view/regManager.jsp");
				}
				else
				{
					session.setAttribute("errorMessage1", "Registration is not successful !");
					 resp.sendRedirect("view/regManager.jsp");
				}
			}
			else
			{
				session.setAttribute("errorMessage1", "Registration is not successful !");
				 resp.sendRedirect("view/regManager.jsp");
			}
			} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
