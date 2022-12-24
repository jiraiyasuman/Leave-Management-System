package com.AxisBank.LeaveManagement.controller;
import java.io.IOException;
import com.AxisBank.LeaveManagementSystem.databaseConnection.*;
import com.AxisBank.LeaveManagementSystem.entity.*;
import com.AxisBank.LeaveManagementSystem.dao.*;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@SuppressWarnings("serial")
@WebServlet("/hrRegister")
public class hrRegistrationServlet extends HttpServlet{
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String name=req.getParameter("name");
		String email=req.getParameter("email");
		String password=req.getParameter("password");
		 String password1=Cipher.encryption(password);
		try {
			HttpSession session=req.getSession();
			HrLogin hr=new HrLogin(name,email,password1);
			HrDaoLogin h=new HrDaoLogin(DbConnect.getConnection());
			boolean f=h.insert(hr);
			if(hr!=null)
			{
				session.setAttribute("hrObj", new HrLogin());
				
				 if(f==true) {
					 session.setAttribute("successMessage5","Registration is successful !");
				resp.sendRedirect("view/regHR.jsp");
				 }
			}
			else
			{
				session.setAttribute("errorMessage5", "Registration is not successful !");
				 resp.sendRedirect("view/regHR.jsp");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}