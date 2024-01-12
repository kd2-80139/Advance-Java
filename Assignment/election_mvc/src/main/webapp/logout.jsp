<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>SignOut</title>
</head>
<body>
	<h1>Thank You</h1>
	<a href="ctl?to=index">Login Again</a>
	${session.invalidate()}
</body>
</html>