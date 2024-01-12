<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Candidate List</title>
</head>
<body>
	<H1>Hello ${lb.user.firstName}</H1>
	<jsp:useBean id="clb" class="com.sunbeam.beans.CandidateListBean"/>
	${clb.candidateList()}
	<form method="post" action="vote.jsp">
		<c:forEach var="c" items="${clb.clist}" >
			<input type="radio" value="${c.id}" name="candidate"/>${c.name}-->${c.party}<br/>
		</c:forEach>
		<input type="submit" value="Vote"/>
	</form>
</body>
</html>