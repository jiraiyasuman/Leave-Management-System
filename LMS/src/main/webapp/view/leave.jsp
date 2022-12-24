<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@page import="java.sql.*" %>
    <%@page import="com.AxisBank.LeaveManagementSystem.databaseConnection.*" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Leave Balance</title>
</head>
<body>
<%
String id=request.getParameter("id");
int sick=Integer.parseInt(request.getParameter("sick"));
int casual=Integer.parseInt(request.getParameter("casual"));
int personal=Integer.parseInt(request.getParameter("personal"));
int maternity=Integer.parseInt(request.getParameter("maternity"));
int paternity=Integer.parseInt(request.getParameter("paternity"));
int adoption=Integer.parseInt(request.getParameter("adoption"));
int marriage=Integer.parseInt(request.getParameter("marriage"));
Connection conn=DbConnect.getConnection();
String sql="INSERT INTO `leavemanagementsystem`.`leavebalance` (`EMPLOYEE_ID`, `SICK_LEAVE`, `CASUAL_LEAVE`, `PERSONAL_LEAVE`, `MATERNITY_LEAVE`, `PATERNITY_LEAVE`, `ADOPTION_LEAVE`, `MARRIAGE_LEAVE`) VALUES (?, ?, ?, ?, ?, ?, ?, ?);";
PreparedStatement ps=conn.prepareStatement(sql);
ps.setString(1,id);
ps.setInt(2,sick);
ps.setInt(3,casual);
ps.setInt(4,personal);
ps.setInt(5,maternity);
ps.setInt(6,paternity);
ps.setInt(7,adoption);
ps.setInt(8, marriage);
int z=ps.executeUpdate();
if(z>0)
{
	session.setAttribute("successMessage18","Leave Balance is successfully inserted !");
	response.sendRedirect("registration.jsp");
}
else
{
	session.setAttribute("errorMessage18", "Leave Balance is not successfully deleted !");
	 response.sendRedirect("registration.jsp");
}


%>
</body>
</html>