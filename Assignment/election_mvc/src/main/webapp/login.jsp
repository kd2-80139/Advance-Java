<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Auth</title>
</head>
<body>
	<jsp:useBean id="lb" class="com.sunbeam.beans.LoginBean" scope="session"/>
	<jsp:setProperty name="lb" property="*" />
	${lb.auth()}
	<c:choose>
		<c:when test="${empty lb.user}">
		Invalid User 
		<a href="ctl?to=index">Login Again</a>
		</c:when>
		<c:when test="${lb.user.role=='admin'}">
			<c:redirect url="ctl?to=result"/>
		</c:when>
		<c:when test="${lb.user.role=='voter'}">
			<c:redirect url="ctl?to=candlist"/>
		</c:when>
	</c:choose>
</body>
</html>