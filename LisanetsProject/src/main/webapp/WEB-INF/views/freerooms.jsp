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
<h1><c:out value="${param['welcome']}"/> 
</h1>
<c:set var="counts" value="${list}"/>
<c:forEach items="${counts}" var="count" >
<h1>
<c:out value="${count}"/>
</h1>
</c:forEach>
</body>

</html>