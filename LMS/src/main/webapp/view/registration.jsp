<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE HTML>
<html>
<head>
<title>Introduction Form</title>
<% response.setHeader("Cache-Control","no-cache,no-store,must-revalidate"); %>
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<link href="https://fonts.googleapis.com/icon?family=Material+Icons"
      rel="stylesheet">
<script type="application/x-javascript"> addEventListener("load", function() { setTimeout(hideURLbar, 0); }, false); function hideURLbar(){ window.scrollTo(0,1); } </script>

<link href="../css/newCss.css" rel="stylesheet" type="text/css" />
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
<style type="text/css">

.filterStatus {
    position: relative;
    top: 2px;
}

</style>
 <link
      rel="stylesheet"
      href="https://cdnjs.cloudflare.com/ajax/libs/intl-tel-input/17.0.8/css/intlTelInput.css"
    />
   
 <link
      rel="stylesheet"
      href="https://cdnjs.cloudflare.com/ajax/libs/intl-tel-input/17.0.8/css/intlTelInput.css"
    />
    <script src="https://cdnjs.cloudflare.com/ajax/libs/intl-tel-input/17.0.8/js/intlTelInput.min.js"></script>
	 <style>
#footer{
    background-color: teal;
    padding-top: 30px;
    padding-bottom: 30px;
	 margin-top:70rem;
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
		<div class="sidebar" style="margin-top: -5.5rem;">
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
   <div class="page-container" align="center" style="margin-top: 12rem;">
   <!--/content-inner-->
	<div class="left-content" align="center" >
	   <div class="mother-grid-inner" align="center" >
             <!--header start here-->
				<div class="header-main" align="center" >
<!--heder end here-->
<c:if test="${not empty succMsg }">
							<p class="text-center text-success fs-3" align="center">${successMessage4}</p>
							<c:remove var="succMsg" scope="session" />
						</c:if>

						<c:if test="${not empty errorMsg }">
							<p class="text-center text-danger fs-5" align="center">${errorMessage4}</p>
							<c:remove var="errorMsg" scope="session" />
						</c:if>
		<div class="container" align="center" style="margin-top: 12rem;">
    <div class="title" align="center" style="margin-left:10rem;"><strong><font size="+2">Add New Employee</font></strong></div><br>  
    
      <form action="../employeeAdd" object="userInfo" method="post" >
          <div class="input-box">
            <span class="details"><strong>Full Name</strong></span><br>
            <input type="text" name="fullName" placeholder="Enter your name" required><br><br>
          </div>
          <div class="input-box">
            <label for="gender"><strong>Gender :</strong></label><br>
              <select name="gender" id="gender" required>
              <option value="">Select</option>
              <option value="male">Male</option>
              <option value="female">Female</option>
              <option value="transgender">Transgender</option>
              <br><br>
          </select>
          </div>
          <div class="input-box">
           <br> <span class="details"><strong>Email</strong></span><br>
            <input type="email" name="email" placeholder="Enter your email" required><br><br>
          </div>
          <div class="input-box">
          
            <span class="details"><strong>Phone Number</strong></span><br>
            <input type="tel" name="phoneNumber" id="phone" placeholder="" pattern="[6-9]{1}[0-9]{9}" required  /><br><br>
            
            <div class="alert alert-info" style="display: none"></div>
      <div class="alert alert-error" style="display: none"></div>
          </div>
          
          <div class="input-box">
            <label for="role"><strong>Role :</strong></label><br>
  <select name="role" id="role" required>
  <option value="">Role</option>
    <option value="employee">Employee</option>
    <option value="hr">Human Resource</option>
    <option value="manager">Manager</option>
    <option value="manager">Senior Manager</option>
  </select>
          </div>
          <div class="input-box">
            <label for="reporting"><strong>Reporting Person :</strong></label><br>
  <select name="reporting" id="reporting" required>
  <option value="">Reporting Person</option>
    <option value="HR">Human Resource</option>
    <option value="Manager">Manager</option>
    <option value="SeniorManager">Senior Manager</option>
  </select>
          </div>
          <label><strong>Reporting Person Name:</strong></label><br>
          <input type="text" name="reportingName" required/><br>
          <label><strong>Reporting Person Email:</strong></label><br>
          <input type="email" name="reportingEmail" required/>
        <div class="button">
         <br><input type="submit" onsubmit="process(event)" value="Submit">
        </div>
       <br>
       <c:if test="${not empty succMsg }">
							<p class="text-center text-success fs-3" align="center">${successMessage17}</p>
							<c:remove var="succMsg" scope="session" />
						</c:if>

						<c:if test="${not empty errorMsg }">
							<p class="text-center text-danger fs-5" align="center">${errorMessage17}</p>
							<c:remove var="errorMsg" scope="session" />
						</c:if>
      </form>
      <div class="content" align="center">
      <h1><strong><font size="+2">Delete Employee</font></strong></h1>
      <form action="updateStatus" method="post">
      <label><strong>Employee ID:</strong></label><br>
      <input type="text" name="id" required/><br>
          <button type="submit" class="button" onclick="return deleteContent()"  value="delete">Delete</button>
      </form>
      <br>
      <br><br><br>
      <script>
function deleteContent()
{
	
	return confirm('Are you sure you want to delete this record ?');
	}
</script>
     
      <c:if test="${not empty succMsg }">
							<p class="text-center text-success fs-3" align="center">${successMessage18}</p>
							<c:remove var="succMsg" scope="session" />
						</c:if>

						<c:if test="${not empty errorMsg }">
							<p class="text-center text-danger fs-5" align="center">${errorMessage18}</p>
							<c:remove var="errorMsg" scope="session" />
						</c:if>
      <h1><strong>Leave balance</strong></h1>
     
      <form action="leave.jsp" method="post">
      <label><strong>EMPLOYEE_ID</strong></label><br>
      <input type="text" name="id" required><br>
      <label><strong>SICK_LEAVE</strong></label><br>
      <input type="number" name="sick" min="1" max="15" required><br>
      <label><strong>CASUAL_LEAVE</strong></label><br>
      <input type="number" name="casual" min="1" max="15" required><br>
      <label><strong>PERSONAL_LEAVE</strong></label><br>
      <input type="number" name="personal" min="1" max="15" required><br>
      <label><strong>MATERNITY_LEAVE</strong></label><br>
      <input type="number" name="maternity" min="1" max="180" required><br>
      <label><strong>PATERNITY_LEAVE</strong></label><br>
      <input type="number" name="paternity" min="1" max="30" required><br>
      <label><strong>ADOPTION_LEAVE</strong></label><br>
      <input type="number" name="adoption" min="1" max="30" required><br>
      <label><strong>MARRIAGE_LEAVE</strong></label><br>
      <input type="number" name="marriage" min="1" max="15" required><br>
      <input type="submit" value="submit" required>
      </form>
       </div>
    
  </div>
<!-- script-for sticky-nav -->
<script>
const phoneInputField = document.querySelector("#phone");
const phoneInput = window.intlTelInput(phoneInputField, {
  utilsScript:
    "https://cdnjs.cloudflare.com/ajax/libs/intl-tel-input/17.0.8/js/utils.js",
});

const info = document.querySelector(".alert-info");
const error = document.querySelector(".alert-error");

function process(event) {
  event.preventDefault();

  const phoneNumber = phoneInput.getNumber();
  
  info.style.display = "";
  info.innerHTML = `Phone number in E.164 format: <strong>${phoneNumber}</strong>`;
}
  </script>
  <script >
  function phonenumber("#phone")
  {
    var phoneno = /^\d{10}$/;
    if(inputtxt.value.match(phoneno))
    {
        return true;
    }
    else
    {
       alert("Not a valid Phone Number");
       return false;
    }
    }
  </script>
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
<section id="footer" style="background: linear-gradient(135deg, #71b7e6, #9b59b6);">
        <p>Privacy Policy <span>|</span> Privacy & Security <span>|</span> National Bank Of Gotham Ltd. <span>|</span> Member FDIC. Equal Housing Lender </p>
        <p>© 2022 National Bank Of Gotham. All rights reserved</p>
        </section>
<!--COPY rights end here-->
</div>
   </body>
   </html>