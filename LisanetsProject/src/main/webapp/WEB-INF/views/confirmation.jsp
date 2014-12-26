<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
		<title>Confirmation | The Last Asylum</title>
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
			<form action="http://localhost:8080/LisanetsProject/thanks.do">
			<div id="main">
				<div id="content">
					<div class="content-heading">
						<h2>Order information</h2>			
					<p>	<c:out value="${order}"/> </p>
					<p>	<c:out value="${firstname}"/></p>
					<p>	<c:out value="${lastname}"/></p>
					<p>	<c:out value="${in}"/></p>
					<p>	<c:out value="${out}"/></p>
					<h2>Booked rooms:</h2>
					<c:set var="counts" value="${listRoom}"/>
                    <c:forEach items="${counts}" var="count" >
                     <p>
                     <c:out value="${count}"/>
                       </p>
                     </c:forEach>
					
					</div>
					<div class="row-input">
						<textarea id="textarea-field" rows='10', cols='58'>Leave your comments here...</textarea>
					</div>
				
					<div class="links">
						<ul>
							<li><button class="new-account" type="button" onclick="">Cancel</button></li>
							<li><button class="express-booking" type="submit" onclick="">Confirm</button></li>
						</ul>
					</div>
				
				
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