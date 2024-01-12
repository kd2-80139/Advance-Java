<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Registration Status</title>
</head>
<body>
	<jsp:useBean id="rb" class="com.sunbeam.bean.RegisterBean"/>
	<jsp:setProperty property="*" name="rb"/>
	<%rb.addUser(); %>
	<%=rb.getStatus() %>
	<%if(rb.getStatus()){
		out.println("User Added");
		}
		else{
			out.println("User Not Added");
		}%>
</body>
</html>