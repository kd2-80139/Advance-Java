<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Candidate Edit</title>
</head>
<body>
	<jsp:useBean id="fcb" class="com.sunbeam.beans.FindCandidateBean"/>
	<jsp:setProperty property="candid" name="fcb" param="id"/>
	${fcb.findCandidate()}
	<form method="post" action="updatecand.jsp">
		<input type="hidden" name="id" value="${fcb.candidate.id}"/>
		Name:<input type="text" name="candname" value="${fcb.candidate.name}"/>
		Party:<input type="text" name="party" value="${fcb.candidate.party}"/>
		Votes:<input type="text" name="Votes" readonly value="${fcb.candidate.votes}"/>
		<input type="submit" value="Update"/>
	</form>
</body>
</html>