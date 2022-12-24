<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@page import="java.sql.*" %>
    <%@page import="com.AxisBank.LeaveManagementSystem.databaseConnection.*" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>New Employee Details</title>
</head>
<% response.setHeader("Cache-Control","no-cache,no-store,must-revalidate"); %>
<link href="https://fonts.googleapis.com/icon?family=Material+Icons"
      rel="stylesheet">
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<script type="application/x-javascript"> addEventListener("load", function() { setTimeout(hideURLbar, 0); }, false); function hideURLbar(){ window.scrollTo(0,1); } </script>
  <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.1/dist/css/bootstrap.min.css" rel="stylesheet"
  integrity="sha384-+0n0xVW2eSR5OomGNYDnhzAbDsOXxcvSN1TPprVMTNDbiYZCxYbOOl7+AMvyTG2x" crossorigin="anonymous">
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.1/dist/js/bootstrap.bundle.min.js"
  integrity="sha384-gtEjrD/SeCtmISkJkNUaaKMoLD0//ElJ19smozuHV6z3Iehds+3Ulb9Bn9Plx0x4"
  crossorigin="anonymous"></script>
<!-- Custom CSS -->
<link href="../css/newCss.css" rel="stylesheet" type="text/css" />
<link href="//fonts.googleapis.com/css?family=Roboto:700,500,300,100italic,100,400" rel="stylesheet" type="text/css"/>
<link href="//fonts.googleapis.com/css?family=Montserrat:400,700" rel="stylesheet" type="text/css">
<link rel="shortcut icon" href="images/favicon.png">
<style>
.dropbtn {
  background-color: orange;
  color: white;
  padding: 16px;
  font-size: 16px;
  border: none;
}

.dropdown {
  position: relative;
  display: inline-block;
}

.dropdown-content {
  display: none;
  position: absolute;
  background-color: #f1f1f1;
  min-width: 160px;
  box-shadow: 0px 8px 16px 0px rgba(0,0,0,0.2);
  z-index: 1;
}

.dropdown-content a {
  color: black;
  padding: 12px 16px;
  text-decoration: none;
  display: block;
}

.dropdown-content a:hover {background-color: #ddd;}

.dropdown:hover .dropdown-content {display: block;}

.dropdown:hover .dropbtn {background-color: orange;}
</style>
<style type="text/css">

.filterStatus {
    position: relative;
    top: 2px;
}

</style>
	 <style>
#footer{
    background-color: teal;
    padding-top: 30px;
    padding-bottom: 30px;
	 margin-top:30rem;
  }
  #footer p{
    text-align: center;
    color: white;
}
</style>
</head> 
<body>
 <div class="m-4">
  <nav
    class="navbar fixed-top navbar-expand-lg navbar-light bg-light p-4"
    style="background-color: #00abb3"
  >
    <div class="container-fluid">
      <a href="#" class="navbar-brand">
        <img
          src="../images/NBGad.webp"
          height="28"
          alt=""
          style="height: 3rem; width: 13rem"
        />
      </a>
      <div class="collapse navbar-collapse" id="navbarCollapse">
        <div class="navbar-nav">
          </div>
          </div>
          <div class="dropdown">
  <button class="dropbtn"><i class="fa-solid fa-circle-user"><span class="material-icons">
account_circle
</span></i></button>
  <div class="dropdown-content">
    <a href="pcHR.jsp">Change Password</a>
    <a href="../hrLogout">Logout</a>
  </div>
</div>
    </div>
  </nav>
</div>
<div class="sidebar" style="margin-top: -3.5rem;">
		<a href="homeHR.jsp"><span>Home</span></a>
  <a href="holidayList.jsp"><span>Holiday List</span></a>
  <a href="displayHoliday.jsp"><span>Display Holiday List</span></a>
  <a href="project.jsp"><span>Add Project Details</span></a>
  <a href="projectDisplay.jsp"><span>Display Project Details</span></a>
  <a href="registration.jsp"><span>Add/Delete Employee</span></a>										
  <a href="registrationValidate.jsp"><span>New Employee Profile</span></a>
  <a href="leaverecordHR.jsp"><span>Manager Leave Records</span></a>										
  <a href="applyLeaveHR.jsp"><span>Apply Leave</span></a>
  <a href="myLeavesHR.jsp"><span>Manage Leaves</span></a>																				
  <a href="contactUs.jsp"><span>Contact US</span></a>
		</div>
<div class="page-container" align="center">
   <!--/content-inner-->
	<div class="left-content" align="center">
	   <div class="mother-grid-inner">
             <!--header start here-->
		<style>
strong { 
  font-weight: bold;
}
</style>
        <div class="" style="float:center; margin-top: 6rem;">
        </div>	
        </div>
				<div class="container" align="center" style="margin-top: 10rem;">
				<div class="title" align="center" style="margin-left:12rem;"><strong>New Employee Details</strong></div><br>
				<div class="content" align="center">
				<table class="table" align="center">
  <thead class="thead-dark" bgcolor="orange">
    <tr>
      <th ><strong>EmployeeId</strong></th>
      <th ><strong>Full Name</strong></th>
      <th ><strong>Gender</strong></th>
      <th ><strong>Email</strong></th>
      <th ><strong>Phone Number</strong></th>
      <th ><strong>Role</strong></th>
    </tr>
  </thead>
  <tbody>
    <tr>
    <% try{
       Connection conn=DbConnect.getConnection();
       PreparedStatement ps=conn.prepareStatement(" SELECT * FROM leavemanagementsystem.employeedetails;");
       ResultSet rs=ps.executeQuery();
       while(rs.next())
       {
    	   %><td><%=rs.getString(1) %></td>
    	   <td><%=rs.getString(2) %></td>
    	   <td><%=rs.getString(3) %></td>
    	   <td> <%=rs.getString(4) %></td>
    	   <td><%=rs.getString(5) %></td>
    	   <td><%=rs.getString(6) %></td>
    	   </tr>
       <% }
       }catch(Exception e)
       {
       e.printStackTrace();
       }%>
    
  </tbody>
</table>
				</div>
				</div>
<!--header end here-->
		<!-- script-for sticky-nav -->
		<script>
		$(document).ready(function() {
			 var navoffeset=$(".header-main").offset().top;
			 $(window).scroll(function(){
				var scrollpos=$(window).scrollTop(); 
				if(scrollpos >=navoffeset){
					$(".header-main").addClass("fixed");
				}else{
					$(".header-main").removeClass("fixed");
				}
			 });
		});
		</script>
		</div></div></div>
		<!-- /script-for sticky-nav -->
<section id="footer" style="background: linear-gradient(135deg, #71b7e6, #9b59b6);">
        <p>Privacy Policy <span>|</span> Privacy & Security <span>|</span> National Bank Of Gotham Ltd. <span>|</span> Member FDIC. Equal Housing Lender </p>
        <p>© 2022 National Bank Of Gotham. All rights reserved</p>
        </section>
<!--COPY rights end here-->
</div>
</body>
</html>