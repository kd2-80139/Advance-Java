<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Result</title>
</head>
<body>
	<jsp:useBean id="rb" class="com.sunbeam.beans.ResultBeam"/>
	${rb.allCandidate()}
	<table border="1">
	<thead>
	<tr>
	<th>Id</th>
	<th>Name</th>
	<th>Party</th>
	<th>Votes</th>
	<th>Action</th>
	</tr>
	</thead>
	<tbody>
	<c:forEach var="c" items="${rb.clist}">
		<tr>
			<td>${c.id}</td>
			<td>${c.name}</td>
			<td>${c.party}</td>
			<td>${c.votes}</td>
			<td><a href="ctl?to=delcand&id=${c.id}">Delete</a>
			<a href="ctl?to=candedit&id=${c.id}">Edit</a></td>
		</tr>
	</c:forEach>
	</tbody>
	</table>
	<a href="ctl?to=announcement">Announcement</a>
	<a href="ctl?to=logout">SignOut</a>
</body>
</html>