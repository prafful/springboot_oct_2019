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
				<th>Id</th>
				<th>Name</th>
				<th>Location</th>
				<th>Years</th>
				<th colspan="2">Actions</th>
			</tr>
		</thead>
		<tbody>
			<d:forEach var="frn" items="${friends}">
				<!-- setup a variable and map it with route/url -->
				<d:url var="delete" value="deletefriend">
					<d:param name="id" value="${frn.id}"></d:param>
				</d:url>
				<d:url var="update" value="updatefriend">
					<d:param name="id" value="${frn.id}"></d:param>
				</d:url>
				<tr>
					<td>${frn.id}</td>
					<td>${frn.name}</td>
					<td>${frn.location}</td>
					<td>${frn.years}</td>
					<td><a href="${delete}">Delete</a></td>
					<td><a href="${update}">Update</a></td>
				</tr>
			</d:forEach>
		</tbody>
	
	</table>
	
</body>
</html>