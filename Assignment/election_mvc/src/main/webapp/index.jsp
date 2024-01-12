<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Login</title>
</head>
<body>
	<form method="post" action="ctl?to=login">
		Email:<input type="text" name="email"/>
		Password:<input type="text" name="passwd"/>
		<input type="submit" value="Login"/>
	</form>
	<a href="ctl?to=register">SignUp</a>
</body>
</html>