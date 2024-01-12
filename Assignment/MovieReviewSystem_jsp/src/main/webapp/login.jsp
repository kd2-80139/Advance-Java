<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Login Status</title>
</head>
<body>
	
	<jsp:useBean id="log" class="com.sunbeam.bean.LoginBean"/>
	<jsp:setProperty property="email" param="email" name="log"/>
	<jsp:setProperty property="password" param="password" name="log"/>
	<%log.auth();%>
	<%if(log.getMessage()){
			out.println("Valid User");
		}
		else{
			out.println("InValid User");
		}%>
</body>
</html>