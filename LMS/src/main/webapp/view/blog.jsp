<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@page import="com.AxisBank.LeaveManagementSystem.databaseConnection.*" %>
    <%@page import="java.sql.*" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
String date=request.getParameter("date");
String about=request.getParameter("about");
String sql="INSERT INTO `leavemanagementsystem`.`blog` (`POST_DATE`, `ABOUT`) VALUES (?,?);";
try{
	Connection conn=DbConnect.getConnection();
	PreparedStatement ps=conn.prepareStatement(sql);
	ps.setString(1, date);
	ps.setString(2, about);
	int i=ps.executeUpdate();
	if(i>0)
	{
		session.setAttribute("successMessage8","New Blog Addition is successful !");
		response.sendRedirect("homeHR.jsp");
	}
	else
	{
		session.setAttribute("errorMessage8", "New Blog Addition is not successful !");
		response.sendRedirect("homeHR.jsp");
	}
}catch(Exception e)
{
	e.printStackTrace();
}
%>
</body>
</html>