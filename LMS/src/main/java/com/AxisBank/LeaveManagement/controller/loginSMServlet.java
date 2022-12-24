package com.AxisBank.LeaveManagement.controller;

import java.io.IOException;

import com.AxisBank.LeaveManagement.repository.SmLoginDaoRepo;
import com.AxisBank.LeaveManagement.util.SmLoginDaoRepoUtil;
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
@WebServlet("/loginSM")
public class loginSMServlet extends HttpServlet{

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String email=req.getParameter("email");
		String password=req.getParameter("password");
		 String password1=Cipher.encryption(password);
		try {
			HttpSession session=req.getSession();
			SmLoginDaoRepo sm=SmLoginDaoRepoUtil.getObject();
			SmLogin s=sm.display(email, password1);
			if(s!=null)
			{
				boolean b=true;
				if(b==true)
				{
					 session.setAttribute("smObj", new HrLogin());
					 req.setAttribute("user",email);
					
					 session.setAttribute("successMessage","Login is successful !");
				resp.sendRedirect("view/homeSeniorManager.jsp");
				}
				else {
					session.setAttribute("errorMessage", "Invalid email and password !");
					 resp.sendRedirect("view/loginSeniorManager.jsp");
				}
			}else {
				session.setAttribute("errorMessage", "Invalid email and password !");
				 resp.sendRedirect("view/loginSeniorManager.jsp");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
