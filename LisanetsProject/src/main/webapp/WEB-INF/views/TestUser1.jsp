<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:useBean id="hello" class="com.sourceit.lisanets.servlet.ServletTest" />
<html>
<head>
<meta charset="utf-8">
<title>
Привет
</title>
</head>
<body>
<form method="POST">
<label for="first-name-field">First name:</label>
<input type="text " name="firstname"  >
<label for="last-name-field">Last name:</label>
<input type="text " name="lastname"  >
<label for="phone-field">Phone:</label>
<input type="tel " name="phone"  >
<label for="email-field">E-mail:</label>
<input type="email " name="email"  >
<label for="password-field">Password:</label>
<input type="password " name="password"  >
<input type="submit" value="Ok">
</form>


</body>

</html>