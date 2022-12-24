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
@WebServlet("/changeHR")
public class passwordUpdateHRServlet extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String email=req.getParameter("email");
		String newpassword=req.getParameter("newpassword");
		String confirmpassword=req.getParameter("confirmpassword");
		String password1=Cipher.encryption(newpassword);
		try {
			HttpSession session=req.getSession();
			HrDaoLogin h=new HrDaoLogin(DbConnect.getConnection());
			boolean hr=h.update(email,password1);
			if(hr==true)
			{
				session.setAttribute("successMessage7","Password is successfully updated !");
				resp.sendRedirect("view/pcHR.jsp");
			}
			else
			{
				session.setAttribute("errorMessage7", "Password is not updated successfully !");
				 resp.sendRedirect("view/pcHR.jsp");
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
