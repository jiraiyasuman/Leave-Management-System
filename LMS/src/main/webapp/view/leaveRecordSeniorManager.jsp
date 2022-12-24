<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@page import="com.AxisBank.LeaveManagementSystem.databaseConnection.*" %>
    <%@page import="java.sql.*" %>
<!DOCTYPE HTML>
<html>
<head>
<title>My Leaves</title>
<% response.setHeader("Cache-Control","no-cache,no-store,must-revalidate"); %>
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<script type="application/x-javascript"> addEventListener("load", function() { setTimeout(hideURLbar, 0); }, false); function hideURLbar(){ window.scrollTo(0,1); } </script>

  <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.1/dist/css/bootstrap.min.css" rel="stylesheet"
  integrity="sha384-+0n0xVW2eSR5OomGNYDnhzAbDsOXxcvSN1TPprVMTNDbiYZCxYbOOl7+AMvyTG2x" crossorigin="anonymous">

<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.1/dist/js/bootstrap.bundle.min.js"
  integrity="sha384-gtEjrD/SeCtmISkJkNUaaKMoLD0//ElJ19smozuHV6z3Iehds+3Ulb9Bn9Plx0x4"
  crossorigin="anonymous"></script>
<link href="../css/newCss.css" rel="stylesheet" type="text/css" />
<link rel="shortcut icon" href="images/favicon.png">
<style>
table, th, td {
  border: 1px solid;
  }
  table {
  width: 100%;
}

th {
  height: 70px;
}
table {
  width: 75%;
}
th, td {
  padding-top: 10px;
  padding-bottom: 20px;
  padding-left: 30px;
  padding-right: 40px;
}
tr:hover {background-color: white;}
table, th, td {
  border: 1px solid black;
  border-radius: 10px;
}
#table-two-axis{
margin-right: 3rem;
}
table th {
    background: orange;
    color: #fff;
    text-transform: uppercase;
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
<style>
.button {
  background-color: orange;
  border: none;
  color: white;
  /*padding: 15px 32px;*/
  height: 2rem;
  width: 3rem;
  text-align: center;
  text-decoration: none;
  display: inline-block;
  font-size: 12px;
  cursor: pointer;
  transition-duration: 0.4s;
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
<div class="sidebar" style="margin-top: 4.9rem;">
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
	<div class="agile-grids" align="center">	
				<!-- tables -->
			<div class="alert alert-info" if="(param.successMessage != null)" align="center">
					<span text="param.successMessage[0]"></span>
            </div>		
			<div class="agile-tables" align="center" style="margin-top: 6rem;">
             <h3 align="center"><strong>HR/Manager Leave Record</strong></h3>
				  <table id="table-two-axis" class="two-axis" align="center">
					<thead>
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
	try{
		Connection conn=DbConnect.getConnection();
		String sql="SELECT * FROM leavemanagementsystem.finalleaverecordhigherups;";
		PreparedStatement ps=conn.prepareStatement(sql);
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

			</div>
			<!-- //table -->
			
	</div>
	<script>
	function myFunction() {
		  alert("Submitted successfully");
		}
	</script>
	<script>
// Avoid scoping issues by encapsulating code inside anonymous function
(function() {
  // variable to store our current state
  var cbstate;
  
  // bind to the onload event
  window.addEventListener('load', function() {
    // Get the current state from localstorage
    // State is stored as a JSON string
    cbstate = JSON.parse(localStorage['CBState'] || '{}');
  
    // Loop through state array and restore checked 
    // state for matching elements
    for(var i in cbstate) {
      var el = document.querySelector('input[name="' + i + '"]');
      if (el) el.checked = true;
    }
  
    // Get all checkboxes that you want to monitor state for
    var cb = document.getElementsByClassName('save-cb-state');
  
    // Loop through results and ...
    for(var i = 0; i < cb.length; i++) {
  
      //bind click event handler
      cb[i].addEventListener('click', function(evt) {
        // If checkboxe is checked then save to state
        if (this.checked) {
          cbstate[this.name] = true;
        }
    
    // Else remove from state
        else if (cbstate[this.name]) {
          delete cbstate[this.name];
        }
    
    // Persist state
        localStorage.CBState = JSON.stringify(cbstate);
      });
    }
  });
})();
</script>
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
<div class="inner-block">
</div>
<!--inner block end here-->
<!--copy rights start here-->
<!--COPY rights end here-->
</div>
</div>
  <!--//content-inner-->
		<!--/sidebar-menu-->
				<div class="clearfix"></div>		
</div>
<!--js -->   
<section id="footer" style="background: linear-gradient(135deg, #71b7e6, #9b59b6);">
        <p>Privacy Policy <span>|</span> Privacy & Security <span>|</span> National Bank Of Gotham Ltd. <span>|</span> Member FDIC. Equal Housing Lender </p>
        <p>© 2022 National Bank Of Gotham. All rights reserved</p>
        </section>
</body>
</html>