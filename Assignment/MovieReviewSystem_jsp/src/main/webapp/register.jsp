<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Register</title>
</head>
<body>
<h1>Register</h1>
<form method="post" action="userregistration.jsp">
	fname:<input type="text" name="fname"/><br/>
	lname:<input type="text" name="lname"/><br/>
	email:<input type="text" name="email"/><br/>
	password:<input type="password" name="password"/><br/>
	mobile:<input type="text" name="mobile"/><br/>
	birth:<input type="text" name="birth" placeholder="dd-mm-yyyy"/><br/>
	<input type="submit" value="Add"/><br/>
	</form>
</body>
</html>