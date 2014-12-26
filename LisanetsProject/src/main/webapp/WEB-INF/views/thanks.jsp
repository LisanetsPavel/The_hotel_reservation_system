<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
		<title>Thanks | The Last Asylum</title>
		<link media="all" rel="stylesheet" type="text/css"
	href="<c:url value='/resources/css/all.css'/>" />
		<script type="text/javascript" src="js/main.js"></script>
	</head>
	<body>
		<div id="wrapper">
			<!--header-->
			<div id="header">
				<h1>The Last Asylum Hotel</h1>
				<p class="header">&quot;Abandon all hope, ye who enter here&quot;</p>
			</div>
			<!--main-->
			<form action="http://localhost:8080/LisanetsProject/select.do">
			<div id="main">
				<div id="content">
					<p>Thank you for your order! Please check your email address.</p>
					<button class="new-order-button" type="submit"  onclick="">New order</button>
				</div>
			</div>
		</form>
			<!--footer-->
			<div id="footer">
				<p>Copyright &copy; 2014 Hotel Ltd. All rights reserved</p>
			</div>
		</div>
	</body>
</html>