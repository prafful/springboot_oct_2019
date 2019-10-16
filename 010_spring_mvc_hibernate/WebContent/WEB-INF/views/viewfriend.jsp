<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="d" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="f" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>View Friend</title>
</head>
<body>
	<h1>View Friends!</h1>
	Raw friends data as received: ${friends}
	<br>
	<ol>
		<d:forEach var="frn" items="${friends}">
			<li>${frn.name} from ${frn.location} since ${frn.years}</li>
		</d:forEach>
	</ol>
	<table border="1">
		<thead>
			<tr>
				<th>Name</th>
				<th>Location</th>
				<th>Years</th>
			</tr>
		</thead>
		<tbody>
			<d:forEach var="frn" items="${friends}">
				<tr>
					<td>${frn.name} </td>
					<td>${frn.location} </td>
					<td>${frn.years}</td>
				</tr>
			</d:forEach>
		</tbody>
	
	</table>
	
</body>
</html>