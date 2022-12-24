<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<style>
p {
      color: blue;
      text-indent: 40px;
      font-weight:600;
    }
  </style>
    <style>
ul {
  list-style-type: none;
  margin: 0;
  padding: 0;
  overflow: hidden;
  background-color: #333;
}

li {
  float: left;
}

li a {
  display: block;
  color: white;
  text-align: center;
  padding: 14px 16px;
  text-decoration: none;
}

li a:hover {
  background-color: #111;
}
</style>
    <style>
    /* Add a black background color to the top navigation */
.topnav {
  background-color: #333;
  overflow: hidden;
}

/* Style the links inside the navigation bar */
.topnav a {
  float: left;
  color: #f2f2f2;
  text-align: center;
  padding: 14px 16px;
  text-decoration: none;
  font-size: 17px;
}

/* Change the color of links on hover */
.topnav a:hover {
  background-color: #ddd;
  color: black;
}

/* Add a color to the active/current link */
.topnav a.active {
  background-color: #04AA6D;
  color: white;
}  
    </style>
<style>
.header {
  padding: 60px;
  text-align: center;
  background: #1abc9c;
  color: white;
  font-size: 30px;
}
</style>
<style>

div.third {
  background: rgba(0, 128, 0, 0.3);
}
</style>
<style>
body {
  font-family: Arial, Helvetica, sans-serif;
  margin: 0;
}

html {
  box-sizing: border-box;
}

*, *:before, *:after {
  box-sizing: inherit;
}

.column {
  float: left;
  width: 33.3%;
  margin-bottom: 16px;
  padding: 0 8px;
}

.card {
  box-shadow: 0 4px 8px 0 rgba(0, 0, 0, 0.2);
  margin: 8px;
}

.about-section {
  padding: 50px;
  text-align: center;
  background-color: #474e5d;
  color: white;
}

.container {
  padding: 0 16px;
}

.container::after, .row::after {
  content: "";
  clear: both;
  display: table;
}

.title {
  color: grey;
}

.button {
  border: none;
  outline: 0;
  display: inline-block;
  padding: 8px;
  color: white;
  background-color: #000;
  text-align: center;
  cursor: pointer;
  width: 100%;
}

.button:hover {
  background-color: #555;
}

@media screen and (max-width: 650px) {
  .column {
    width: 100%;
    display: block;
  }
}
</style>

<style>
body {
	background-image: url(images/bank.webp);
	background-size: cover;
	background-repeat: no-repeat;
	font-family: 'Arimo', sans-serif;
	margin: 0;
	padding: 0;
	height: 100%;
	box-sizing: border-box;
}

.container {
	width: 80%;
	height: 100%;
	margin: 0 auto;
}
.box, .regbox {
	width: 320px;
	height: 420px;
	background: #2f3542;
	margin: 0;
	padding: 30px;
	top: 55%;
	left: 50%;
	color: #fff;
	border-radius: 15px;
	position: absolute;
	transform: translate(-50%, -50%);
	box-sizing: border-box;
}

.avatar {
	margin: 0;
	padding: 0;
	width: 150px;
	height: 150px;
	top: -22%;
	position: absolute;
	left: calc(50% - 75px);
	border-radius: 50%;
}

.box h1 {
	margin: 0;
	padding: 30px;
	text-align: center;
	font-size: 30px;
}

.box p {
	margin: 0;
	padding: 0;
	font-weight: bold;
}

.box input {
	width: 100%;
	margin-bottom: 15px;
	border-radius: 5px;
}

.box input[type="text"], .box input[type="password"] {
	border: none;
	background: transparent;
	border-bottom: 1px solid #fff;
	outline: none;
	height: 35px;
	color: #fff;
	font-size: 15px;
}

.box input[type="submit"] {
	display: block;
	border: none;
	outline: none;
	height: 35px;
	background: #eccc68;
	color: #000;
	font-size: 20px;
	border-radius: 20px;
}

.box input[type="submit"]:hover {
	border: none;
	outline: none;
	height: 35px;
	background: #ff6348;
	color: #fff;
	font-size: 20px;
	border-radius: 20px;
	cursor: pointer;
	transition: .3s ease-out;
}

.box a {
	text-decoration: none;
	color: #fff;
	font-size: 16px;
	line-height: 20px;
}

.box a:hover {
	color: #eccc68;
}

.regbox .avatar {
	margin: 0;
	padding: 0;
	width: 150px;
	height: 150px;
	top: -19%;
	position: absolute;
	left: calc(50% - 75px);
	border-radius: 50%;
}

.regbox h1 {
	margin-top: 30px;
	padding: 20px 0;
	text-align: center;
	font-size: 30px;
}

.regbox p {
	margin: 0;
	padding: 0;
	font-weight: bold;
}

.regbox input {
	width: 100%;
	margin-bottom: 15px;
	border-radius: 5px;
}

.regbox input[type="text"], .regbox input[type="password"] {
	border: none;
	background: transparent;
	border-bottom: 1px solid #fff;
	outline: none;
	height: 35px;
	color: #fff;
	font-size: 15px;
}

.regbox input[type="submit"] {
	display: block;
	border: none;
	outline: none;
	height: 35px;
	background: #eccc68;
	color: #000;
	font-size: 20px;
	border-radius: 20px;
}

.regbox input[type="submit"]:hover {
	border: none;
	outline: none;
	height: 35px;
	background: #ff6348;
	color: #fff;
	font-size: 20px;
	border-radius: 20px;
	cursor: pointer;
	transition: .3s ease-out;
}

.regbox a {
	text-decoration: none;
	color: #fff;
	font-size: 16px;
	line-height: 20px;
}

.regbox a:hover {
	color: #eccc68;
}
</style>
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

body{
 height: 100%;
 width: 100%;
background: linear-gradient(135deg, #71b7e6, #9b59b6);
}

input[type="email"] {
    border: none;
    background: transparent;
    border-bottom: 1px solid #fff;
    outline: none;
    height: 35px;
    color: #fff;
    font-size: 15px;
}
</style>
<meta charset="UTF-8">
<title>Forgot password</title>
</head>
<body>
<form action="../forgotSM" method="post">
                    
                    <input type="email" placeholder="Username" name="email" required>
                    <input type="submit" value="Login">
                    <a href="loginSeniorManager.jsp">Back</a>
                </form>
                <section id="footer" style="background: linear-gradient(135deg, #71b7e6, #9b59b6);">
        <p>Privacy Policy <span>|</span> Privacy & Security <span>|</span> Bank Lynxshares,inc. <span>|</span> Member FDIC. Equal Housing Lender </p>
        <p>© 2022 Bank Lynx. All rights reserved</p>
        </section>	
</body>
</html>