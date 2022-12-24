package com.AxisBank.LeaveManagement.controller;
import java.io.IOException;

import com.AxisBank.LeaveManagement.repository.HrDaoLoginRepo;
import com.AxisBank.LeaveManagement.util.HrDaoLoginRepoUtil;
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
@WebServlet("/loginHR")
public class hrLoginServlet extends HttpServlet{
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String email=req.getParameter("email");
	       String password=req.getParameter("password");
	      String password1=Cipher.encryption(password);
	       try {
	    	HttpSession session=req.getSession();
	    	HrDaoLoginRepo h=HrDaoLoginRepoUtil.getObject();
			HrLogin hr=h.display(email,password1);
			if(hr!=null)
			{	
				boolean f=true;
				 if(f==true) {
					 session.setAttribute("hrObj", new HrLogin());
					 req.setAttribute("user",email);
					 session.setAttribute("successMessage","Login is successful !");
				resp.sendRedirect("view/homeHR.jsp");
				 }
			}
			else
			{
				session.setAttribute("errorMessage", "Invalid email and password !");
				 resp.sendRedirect("view/login.jsp");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	    		  
	}
  }
