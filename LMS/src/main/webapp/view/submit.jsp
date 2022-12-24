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
String day=request.getParameter("day");
String date=request.getParameter("date");
String name=request.getParameter("name");
String type=request.getParameter("type");
String year=request.getParameter("year");
String sql="INSERT INTO `leavemanagementsystem`.`holidaylist` (`Day`, `Date`, `Holiday name`, `Holiday type`, `Year`) VALUES (?, ?, ?, ?,?);";
try{
	Connection conn=DbConnect.getConnection();
	PreparedStatement ps=conn.prepareStatement(sql);
	ps.setString(1, day);
	ps.setString(2, date);
	ps.setString(3, name);
	ps.setString(4, type);
	ps.setString(5, year);
	int i=ps.executeUpdate();
	if(i>0)
	{
		session.setAttribute("successMessage2","New Holiday Addition is successful !");
		response.sendRedirect("holidayList.jsp");
	}
	else
	{
		session.setAttribute("errorMessage2", "New Holiday Addition is not successful !");
		response.sendRedirect("holidayList.jsp");
	}
}catch(Exception e)
{
	out.println(e);
}
%>
</body>
</html>