package com.AxisBank.LeaveManagement.controller;

import java.io.IOException;
import java.sql.*;

import com.AxisBank.LeaveManagementSystem.dao.NewEmployeeDao;
import com.AxisBank.LeaveManagementSystem.databaseConnection.DbConnect;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@SuppressWarnings("serial")
@WebServlet("/updateStatus")
public class DeleteEmployeeServlet extends HttpServlet{

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String id=req.getParameter("id");
		HttpSession session=req.getSession();
		try {
			NewEmployeeDao n=new NewEmployeeDao(DbConnect.getConnection());
			boolean hr=n.update(id);
			if(hr==true)
			{
				session.setAttribute("successMessage17","Employee Record is successfully deleted !");
				resp.sendRedirect("view/registration.jsp");
			}
			else
			{
				session.setAttribute("errorMessage17", "Employee Record is not successfully deleted !");
				 resp.sendRedirect("view/registration.jsp");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
