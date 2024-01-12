<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Vote</title>
</head>
<body>
	<jsp:useBean id="vb" class="com.sunbeam.beans.VoteBean"/>
	<jsp:setProperty name="vb" property="candidate" param="candidate"/>
	<jsp:setProperty name="vb" property="userid" value="${lb.user.id}"/>
	${vb.addVote()}
	<h1>Hello ${lb.user.firstName}</h1>
	${vb.message}
	<a href="logout.jsp">SignOut</a>
</body>
</html>