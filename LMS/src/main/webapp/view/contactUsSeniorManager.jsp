<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@page import="com.AxisBank.LeaveManagementSystem.databaseConnection.*" %>
    <%@page import="java.sql.*" %>
<!DOCTYPE HTML>
<html>
<head>
<title>Contact Us</title>
<% response.setHeader("Cache-Control","no-cache,no-store,must-revalidate"); %>
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />

<script type="application/x-javascript"> addEventListener("load", function() { setTimeout(hideURLbar, 0); }, false); function hideURLbar(){ window.scrollTo(0,1); } </script>
  <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.1/dist/css/bootstrap.min.css" rel="stylesheet"
  integrity="sha384-+0n0xVW2eSR5OomGNYDnhzAbDsOXxcvSN1TPprVMTNDbiYZCxYbOOl7+AMvyTG2x" crossorigin="anonymous">
<!-- JavaScript Bundle with Popper -->
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.1/dist/js/bootstrap.bundle.min.js"
  integrity="sha384-gtEjrD/SeCtmISkJkNUaaKMoLD0//ElJ19smozuHV6z3Iehds+3Ulb9Bn9Plx0x4"
  crossorigin="anonymous"></script>
<link href="../css/newCss.css" rel="stylesheet" type="text/css" />
<link href="//fonts.googleapis.com/css?family=Roboto:700,500,300,100italic,100,400" rel="stylesheet" type="text/css"/>
<link href="//fonts.googleapis.com/css?family=Montserrat:400,700" rel="stylesheet" type="text/css">
<style>
#footer{
    background-color: teal;
    padding-top: 30px;
    padding-bottom: 30px;
	 margin-top:40rem;
  }
  #footer p{
    text-align: center;
    color: white;
}
</style>
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
<link href="https://fonts.googleapis.com/icon?family=Material+Icons"
      rel="stylesheet">
</head> 
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
</span>
</i></button>
  <div class="dropdown-content">
    <a href="pcSM.jsp">Change Password</a>
    <a href="../SMLogout">Logout</a>
  </div>
</div>
    </div>
  </nav>
</div>
<div class="sidebar" style="margin-top: -8.5rem;">
  <a href="homeSeniorManager.jsp"><span>Home</span></a>
  <a href="holidayListSeniorManager.jsp"><span>Holiday List</span></a>
  <a href="projectSeniorManager.jsp"> <span>Company Project Details</span></a>
  <a href="manageSeniorManager.jsp"> <span>Apply Leave</span></a>
  <a href="leaveRecordSeniorManager.jsp"> <span>HR/Manager Leave Details</span></a>
  <a href="myLeaveSeniorManager.jsp"> <span>Manage Leave</span></a>
  <a href="contactUsSeniorManager.jsp"> <span>Contact US</span></a>
</div>
<div class="page-container" align="center">
   <!--/content-inner-->
	<div class="left-content" align="center">
	   <div class="mother-grid-inner" align="center">
             <!--header start here-->
				<div class="header-main" align="center">
					<div class="clearfix"> </div>	
				</div>
				<!--heder end here-->
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
		<!-- /script-for sticky-nav -->
<!--inner block start here-->
<div class="inner-block" align="center"  style="margin-top: 15rem;">
<p class="text-big"><strong><font size="+2">Contact Us</font></strong></p>

				<p class="text-small">
					<strong>You can Contact Us if you want to change your password or if you face any issues in the portal.</strong>
				</p>

				
				<p class="center"
				style="text-decoration:none;
						color:black;">
					<strong>Contact email Id: suman.talukdar53@gmail.com</strong>
				</p>
				<p class="center"
				style="text-decoration:none;
						color:black;">
					<strong><font size="+2">Notice to all the employees</font></strong>
				</p>
				<p class="center"
				style="text-decoration:none;
						color:black;">
					<strong>No employees should have a negative leave balance, else their monthly salaries will get deducted.<br>
					The employees should always make a note of their leave balance </strong>
				</p>
				
</div>
<div class="content" align="center" >
<h1><strong>Allotted Holidays</strong></h1>
<table class="table">
  <thead bgcolor="orange">
    <tr>
      <th >Holiday_Name</th>
      <th >No_of_Days</th>
    </tr>
  </thead>
  <tbody>
  <%
	try{
		Connection conn=DbConnect.getConnection();
		String sql="SELECT * FROM leavemanagementsystem.allottedholidays;";
		PreparedStatement ps=conn.prepareStatement(sql);
		ResultSet rs=ps.executeQuery();
		while(rs.next())
		{ %>
    <tr>
      <th><%=rs.getString(1) %></th>
      <td><%=rs.getString(2) %></td>
    </tr>
     <% 	}
	}catch(Exception e)
	{
		System.out.println(e);
	}
	%>
  </tbody>
</table>
</div>
<!--inner block end here-->
<!--copy rights start here-->

</div>
</div>
  <!--//content-inner-->
			<div class="clearfix"></div>		
</div>  
<section id="footer" style="background: linear-gradient(135deg, #71b7e6, #9b59b6);">
        <p>Privacy Policy <span>|</span> Privacy & Security <span>|</span> National Bank Of Gotham Ltd. <span>|</span> Member FDIC. Equal Housing Lender </p>
        <p>© 2022 National Bank Of Gotham. All rights reserved</p>
        </section>	
<!--COPY rights end here-->
</body>
</html>