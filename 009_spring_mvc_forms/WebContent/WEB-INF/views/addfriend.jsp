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
	<!-- This page will receive instance of type Friend class
			when it opens, from the controller! -->
	<f:form method="post" action="addnewfriend.spring">
		<label>Name: </label>
		<!-- name is class variable in friend instance which is received -->
		<f:input path="name"/>
		<br>
		<label>Location: </label>
		<!-- location is class variable in friend instance which is received -->
		<f:input path="location"/>
		<br>
		<label>Duration: </label>
		<!-- years is class variable in friend instance which is received -->
		<f:input path="years"/>
		<br>
		<input type="submit" value="Add">
		<!-- on submit, name, location and years 
			(friend instance with values) will be sent along
				with post request -->
	</f:form>
	
</body>
</html>