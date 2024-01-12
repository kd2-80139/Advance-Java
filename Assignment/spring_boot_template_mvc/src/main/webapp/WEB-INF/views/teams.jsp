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
	<h1>Hello</h1>
	<form action="team_details" method="post">
	<c:forEach var="t" items="${requestScope.team_detail}">
		<input type="radio" name="team_id" value="${t.id}"/>${t.name}<br>
	</c:forEach>
	<input type="submit" value="Show Team Details"/>
	</form>
</body>
</html>