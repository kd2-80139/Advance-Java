<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Registration</title>
</head>
<body>
	<jsp:useBean id="rgb" class="com.sunbeam.beans.RegisterBean"/>
	<jsp:setProperty property="*" name="rgb"/>
	${rgb.addUser()}
	<h1>Register Successfull</h1>
	<a href="index.jsp">SignIn</a>
</body>
</html>