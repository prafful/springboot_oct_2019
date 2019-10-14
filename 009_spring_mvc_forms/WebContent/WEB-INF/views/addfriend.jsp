<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
 <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="d" %>
 <%@ taglib uri="http://www.springframework.org/tags/form" prefix="f" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">

<title>Add Friend</title>
</head>
<body>
	<h1>Add Friend</h1>
	<f:form method="post" action="addnewfriend">
		<label>Name: </label>
		<f:input path="name"/>
		<br>
		<label>Location: </label>
		<f:input path="location"/>
		<br>
		<label>Duration: </label>
		<f:input path="years"/>
		<br>
		<input type="submit" value="Add">
	
	</f:form>
	
</body>
</html>