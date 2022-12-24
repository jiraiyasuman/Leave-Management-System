<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE HTML>
<html>
<head>
<title>Apply Leave</title>
<% response.setHeader("Cache-Control","no-cache,no-store,must-revalidate"); %>
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<script src="http://ajax.googleapis.com/ajax/libs/jquery/1.6/jquery.min.js" type="text/javascript"></script>
<script src="http://ajax.googleapis.com/ajax/libs/jqueryui/1.8/jquery-ui.min.js"
type="text/javascript"></script>
<link href="http://ajax.googleapis.com/ajax/libs/jqueryui/1.8/themes/base/jquery-ui.css"
rel="Stylesheet"type="text/css"/>
<script type="application/x-javascript"> addEventListener("load", function() { setTimeout(hideURLbar, 0); }, false); function hideURLbar(){ window.scrollTo(0,1); } </script>
<link href="css/newCss.css" rel="stylesheet" type="text/css" />
  <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.1/dist/css/bootstrap.min.css" rel="stylesheet"
  integrity="sha384-+0n0xVW2eSR5OomGNYDnhzAbDsOXxcvSN1TPprVMTNDbiYZCxYbOOl7+AMvyTG2x" crossorigin="anonymous">
<!-- JavaScript Bundle with Popper -->
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.1/dist/js/bootstrap.bundle.min.js"
  integrity="sha384-gtEjrD/SeCtmISkJkNUaaKMoLD0//ElJ19smozuHV6z3Iehds+3Ulb9Bn9Plx0x4"
  crossorigin="anonymous"></script>
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
<style>
#footer{
    background-color: teal;
    padding-top: 30px;
    padding-bottom: 30px;
	 margin-top:78rem;
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
          src="images/NBGad.webp"
          height="28"
          alt=""
          style="height: 3rem; width: 13rem"
        />
      </a>
      <div class="collapse navbar-collapse" id="navbarCollapse">
        <div class="navbar-nav">
        </div>
        </div>
        <link href="https://fonts.googleapis.com/icon?family=Material+Icons"
      rel="stylesheet">
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
<div class="page-container" align="center">
   <!--/content-inner-->
	<div class="left-content" align="center">
	   <div class="mother-grid-inner" align="center">
             <!--header start here-->
				<div class="header-main" align="center">
					</div>
<!--heder end here-->
		<div class="sidebar" style="margin-top: -4.0rem;">
		<a href="homeHR.jsp"><span>Home</span></a>
  <a href="holidayList.jsp"><span>Holiday List</span></a>
  <a href="displayHoliday.jsp"><span>Display Holiday List</span></a>
  <a href="project.jsp"><span>Add Project Details</span></a>
  <a href="projectDisplay.jsp"><span>Display Project Details</span></a>
  <a href="registration.jsp"><span>Add/Delete Employee</span></a>										
  <a href="registrationValidate.jsp"><span>New Employee Profile</span></a>
  <a href="leaverecordHR.jsp"><span>S.Manager Leave Records</span></a>										
  <a href="applyLeaveHR.jsp"><span>Apply Leave</span></a>
  <a href="myLeavesHR.jsp"><span>Manage Leaves</span></a>																				
  <a href="contactUs.jsp"><span>Contact US</span></a>
		</div>
        <!--//content-inner-->
			<!--/sidebar-menu-->
        <div class="grid-form1" align="center" style="margin-top: 10rem;">
            <h3>Human Resource Request For Leave</h3>
            <div class="tab-content tab-pane active" id="horizontal-form" align="center">
                <c:if test="${not empty succMsg }">
							<p class="text-center text-success fs-10">${successMessage1}</p>
							<c:remove var="succMsg" scope="session" />
						</c:if>

						<c:if test="${not empty errorMsg }">
							<p class="text-center text-danger fs-10">${errorMessage1}</p>
							<c:remove var="errorMsg" scope="session" />
						</c:if>
                <form class="form-horizontal" action="../leaveHR" method="post">
                <div class="form-group">
						<label class="col-sm-4 control-label"><strong>Employee ID :</strong></label>
						<div class="col-sm-6">
							<input type="text" id="id" field="id" name="id" placeholder="Employee ID"  required/>
						</div>
						 
						<div class="form-group">
						<label class="col-sm-4 control-label"><strong>Name :</strong></label>
						<div class="col-sm-6">
							<input type="text" id="name" field="name" name="name" placeholder="name"  required/>
						</div>
						
						
                	<div class="form-group">
						<label for="col-sm-4 control-label"><strong>Leave Types :</strong></label><br>
                        <select name="leaveType" id="leave" required>
                        <option value="">Leave Types</option>
                        <option value="Sick Leave">Sick Leave</option>
                        <option value="Casual Leave">Casual Leave</option>
                        <option value="Personal Leave">Personal Leave</option>
                        <option value="Maternity Leave">Maternity Leave</option>
                        <option value="Paternity Leave">Paternity Leave</option>
                        <option value="Marriage Leave">Marriage Leave</option>
                        <option value="Adoption Leave">Adoption Leave</option>
                        </select>
                        </div>
					<div class="form-group">
						<label class="col-sm-4 control-label"><strong>From Date :</strong></label>
						<div class="col-sm-6">
							<input type="text" id="txtFrom" field="fromDate" name="fromDate" placeholder="From Date"  required/>
						</div>
						
						<label class="alert-danger col-sm-6 col-sm-offset-4" if="fields.hasErrors('fromDate')" errors="fromDate" ></label> 
					</div>
					<div class="form-group">
						<label class="col-sm-4 control-label"><strong>To Date :</strong></label>
						<div class="col-sm-6">
							<input type="text" id="txtTo" field="toDate" name="toDate" placeholder="To Date"  required/>
						</div>
						</div>
						<div class="form-group">
						<label class="col-sm-4 control-label"><strong>No. of Days :</strong></label>
						<div class="col-sm-6">
							<input type="number" min="1" max="180" field="leavetype" name="noOfDays" placeholder="Number of Days" required/>
						</div>
						<label class="alert-danger col-sm-6 col-sm-offset-4" if="fields.hasErrors('toDate')" errors="toDate"></label> 
					</div>
					<div class="form-group">
						<label class="col-sm-4 control-label"><strong>Leave Reason :</strong></label>
						<div class="col-sm-6">
							<textarea field="reason" placeholder="Leave Reason" name="leaveReason"  style="height: 100px;" required></textarea>
						</div>
						 
						<label class="alert-danger col-sm-6 col-sm-offset-4" if="fields.hasErrors('reason')" errors="reason" ></label>
					</div>
					<div class="row" align="right">
						<div class="col-sm-8 col-sm-offset-4">
							<button type="submit" class="btn btn-primary">Apply Leave</button>
							<a href="homeHR.jsp"><button type="button" class="btn btn-default">Cancel</button></a>
						</div>
					</div>
                </form>              
                
            </div>
         </div>
         <div class="container" align="center" style="margin-top:10rem;">
         <div class="content" align="center" >
<h2><strong>My applied Leaves</strong></h2>
<form action="displayHR.jsp" method="post">
		<div class="content" align="center">
		<label><strong>Please enter the Employee Id</strong></label>
		<input type="text" name="id" required/>
		<input type="submit" value="submit">
</div>
</form>
         </div>
         </div>
<script type="text/javascript">
$(function () {
    $("#txtFrom").datepicker({
        numberOfMonths: 2,
        onSelect: function (selected) {
            var dt = new Date(selected);
            dt.setDate(dt.getDate());
            $("#txtTo").datepicker("option", "minDate", dt);
        }
    });
    $("#txtTo").datepicker({
        numberOfMonths: 2,
        onSelect: function (selected) {
            var dt = new Date(selected);
            dt.setDate(dt.getDate());
            $("#txtFrom").datepicker("option", "maxDate", dt);
        }
    });
});
</script>
<script type="text/javascript">
$(function(){
	$('.leave-date').datepicker();
});
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
</div>
</div>
				<div class="clearfix"></div>		
</div>  
<section id="footer" style="background: linear-gradient(135deg, #71b7e6, #9b59b6);">
        <p>Privacy Policy <span>|</span> Privacy & Security <span>|</span> National Bank Of Gotham Ltd. <span>|</span> Member FDIC. Equal Housing Lender </p>
        <p>© 2022 National Bank Of Gotham. All rights reserved</p>
        </section>
</body>
</html>