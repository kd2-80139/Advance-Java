<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Registration</title>
</head>
<body>
	<form method="post" action="ctl?to=registration">
	fname:<input type="text" name="fName"/><br/>
	lname:<input type="text" name="lName"/><br/>
	email:<input type="text" name="email"/><br/>
	password:<input type="password" name="password"/><br/>
	birth:<input type="text" name="birth" placeholder="dd-mm-yyyy"/><br/>
	<input type="submit" value="Register"/><br/>
	</form>
</body>
</html>