<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib  uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib  uri="http://www.springframework.org/tags" prefix="spring" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Team Details</title>
</head>
<body>
<h1>Team Details</h1>
	<c:forEach var="p" items="${requestScope.players}">
		<input type="text" value="${p.firstName}"/>
	</c:forEach>
</body>
</html>