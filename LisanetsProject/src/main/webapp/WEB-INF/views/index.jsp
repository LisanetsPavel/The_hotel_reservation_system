<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>Sign in | The Last Asylum</title>

<link media="all" rel="stylesheet" type="text/css"
	href="<c:url value='/resources/css/all.css'/>" />
<script src="<c:url value='/resources/js/main.js'/>"></script>
</head>
<body>
	<div id="wrapper">
		<!--header-->
		<div id="header">
			<h1>The Last Asylum Hotel</h1>
			<p class="header">&quot;Abandon all hope, ye who enter here&quot;</p>
		</div>
		<!--main-->
		<div id="main">
			<div id="content">
				<!--login form for previously registered user-->
				<form action="http://localhost:8080/LisanetsProject/login.do" class="date-select-form" method="POST">
					<fieldset>
						<div class="date-select-heading">
							<p>Sign in to continue</p>
						</div>
						<!--email input field-->
						<div class="row-input">
							<label for="email-signin-field">E-mail:</label> <input
								name="login" id="email-signin-field" type="email"></input>
						</div>
						<!--password input field-->
						<div class="row-input">
							<label for="password-signin-field">Password:</label> <input
							  name=password	id="password-signin-field" type="password"></input>
						</div>
						<em><c:out value="${text}"/> 	</em>					
						<!--password remember link-->
						<div class="password-remember-link">
							<a href="javascript:void(0)"
								onclick="document.getElementById('light2').style.display='block';document.getElementById('fade2').style.display='block'">Forgot
								your password?</a>
						</div>
						<!--submit button-->
						<div class="row-button">
							<input id="sign-in-button" type="submit" onclick=""
								value="Sign in" />
						</div>
					</fieldset>
				</form>
				<!--links for new user account creation and express booking-->
				<div class="links">
					
						<button class="new-account" type="button"
								onclick="document.getElementById('light').style.display='block';document.getElementById('fade').style.display='block'">Create
								an account</button>
						
				</div>
			</div>
		</div>
		<!--registration lightbox-->
		<div id="light" class="white_content">
			<!--registration form for new user-->
			<form action="http://localhost:8080/LisanetsProject/registration.do"
			 onSubmit="return checkPw(this)"	class="registration-form" method="POST">
				<fieldset>
					<div class="registration-form-heading">
						<p>Create your account</p>
					</div>
					<!--first name input field-->
					<div class="row-input">
						<label for="first-name-field">First name:</label> <input required
							id="first-name-field" name="FirstName" type="text"></input>
					</div>
					<!--last name input field-->
					<div class="row-input">
						<label for="last-name-field">Last name:</label> <input required
							id="last-name-field" name="LastName" type="text"></input>
					</div>
					<!--phone input field-->
					<div class="row-input">
						<label for="phone-field">Phone:</label> <input required id="phone-field"
							name="Phone" type="tel"></input>
					</div>
					<!--email input field-->
					<div class="row-input">
						<label for="email-field">E-mail:</label> <input required id="email-field"
							name="Email" type="email"></input>
					</div>
					<!--password input field-->
					<div class="row-input">
						<label for="password-field">Password:</label> <input required
							name="Password" id="password-field" type="password"></input>
					</div>
					<!--confirm password input field-->
					<div class="row-input">
						<label for="confirm-password-field">Repeat password:</label> <input required
						name="RepeatPassword"	id="confirm-password-field" type="password"></input>
					</div>
					<!--register submit button-->
					<div class="row-button">
						<ul>
							<li><button class="close-button" type="button"
									onclick="document.getElementById('light').style.display='none';document.getElementById('fade').style.display='none'">Close</button></li>
							<li><input id="sign-up-button" type="submit" value="Sign up" /></li>
						</ul>
					</div>
				</fieldset>
			</form>
		</div>
		<div id="fade" class="black_overlay"></div>

		<!--password remember lightbox-->
		<div id="light2" class="white_content">
			<!--registration form for new user-->
			<form action="#" class="registration-form">
				<fieldset>
					<div class="registration-form-heading">
						<p>Please enter your email address</p>
					</div>
					<!--email input field-->
					<div class="row-input">
						<label for="email-remind-field">E-mail:</label> <input
							id="email-remind-field" type="email"></input>
					</div>

					<!--register submit button-->
					<div class="row-button">
						<ul>
							<li><button class="close-button"
									onclick="document.getElementById('light2').style.display='none';document.getElementById('fade2').style.display='none'">Close</button></li>
							<li><input id="remind-button" type="button" value="Remind" /></li>
						</ul>
					</div>
				</fieldset>
			</form>
		</div>
		<div id="fade2" class="black_overlay"></div>
		<!--footer-->
		<div id="footer">
			<p>Copyright &copy; 2014 The Last Asylum Ltd. All rights reserved</p>
		</div>
	</div>
</body>
</html>