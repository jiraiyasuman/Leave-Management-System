<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@page import="java.sql.*" %>
    <%@page import="com.AxisBank.LeaveManagementSystem.databaseConnection.*" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link href="../css/newCss.css" rel="stylesheet" type="text/css" />
<title>Insert title here</title>
<style>
#footer {
	background-color: teal;
	padding-top: 30px;
	padding-bottom: 30px;
	margin-top: 30rem;
}

#footer p {
	text-align: center;
	color: white;
}
</style>
</head>
<body>
<div class="agile-tables" align="center" style="margin-top: 11rem;">
			<h3 align="center" >Employee Leave Record</h3>
				  <table id="table-two-axis" class="two-axis" align="center" >
					<thead style="background-color: orange;">
					  <tr>
					    <th ><strong>Employee Id</strong></th>
					    <th ><strong>Name</strong></th>
                		<th ><strong>From Date</strong></th>
                		<th ><strong>To Date</strong></th>
                		<th ><strong>Leave_Type</strong></th>
                		<th ><strong>No_of_Days</strong></th>
                		<th ><strong>Leave_Reason</strong></th>
                		<th ><strong>LEAVE_BALANCE</strong></th>
                		<th ><strong>STATUS</strong></th>
                	  </tr>
					</thead>
					<tbody>
					<%
					String id=request.getParameter("id");
	try{
		Connection conn=DbConnect.getConnection();
		String sql="SELECT * FROM leavemanagementsystem.finalleaverecordhigherups WHERE EMPLOYEE_ID=?;";
		PreparedStatement ps=conn.prepareStatement(sql);
		ps.setString(1,id);
		ResultSet rs=ps.executeQuery();
		while(rs.next())
		{ %>
					<tr>
					<td><%=rs.getString(1) %></td>
					<td><%=rs.getString(2) %></td>
					<td><%=rs.getString(3) %></td>
					<td><%=rs.getString(4) %></td>
					<td><%=rs.getString(5) %></td>
					<td><%=rs.getString(6) %></td>
					<td><%=rs.getString(7) %></td>
					<td><%=rs.getString(8) %></td>
					<td><%=rs.getString(9) %></td>
					</tr>
                	  <% 	}
	}catch(Exception e)
	{
		System.out.println(e);
	}
	%>
					</tbody>
				  </table>
				  <a href="applyLeaveManager.jsp">Back</a>
				  </div>
				  <section id="footer" style="background: linear-gradient(135deg, #71b7e6, #9b59b6);">
        <p>Privacy Policy <span>|</span> Privacy & Security <span>|</span> National Bank Of Gotham Ltd. <span>|</span> Member FDIC. Equal Housing Lender </p>
        <p>© 2022 National Bank Of Gotham. All rights reserved</p>
        </section>
</body>
</html>