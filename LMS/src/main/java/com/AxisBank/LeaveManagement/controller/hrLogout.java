package com.AxisBank.LeaveManagement.controller;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@SuppressWarnings("serial")
@WebServlet("/hrLogout")
public class hrLogout extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		@SuppressWarnings("unused")
		HttpSession session=req.getSession();
		session.removeAttribute("hrObj");
		session.setAttribute("successMessage", "Logout successful");
		resp.sendRedirect("view/login.jsp");
		session.invalidate();
	}

}
