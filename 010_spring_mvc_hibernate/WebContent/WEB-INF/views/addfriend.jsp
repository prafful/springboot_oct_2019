<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="d"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="f"%>
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
	<f:form method="post" action="addnewfriend">
		<table>
		<tr>
			<td>Id: </td>
			<td>
				<f:input path="id"  readonly="true"/>
			</td>
		</tr>
			<tr>
				<td><label>Name: </label></td>
				<td>
					<!-- name is class variable in friend instance which is received -->
					<f:input path="name" />
				</td>
			</tr>
			<tr>
				<td><label>Location: </label></td>
				<td>
					<!-- location is class variable in friend instance which is received -->
					<f:input path="location" />
				</td>
			</tr>
			<tr>
				<td><label>Duration: </label></td>
				<td>
					<!-- years is class variable in friend instance which is received -->
					<f:input path="years" />
				</td>
			</tr>
			<tr>
				<td><input type="submit" value="Add"> <!-- on submit, name, location and years 
			(friend instance with values) will be sent along
				with post request --></td>
			</tr>
		</table>

	</f:form>

</body>
</html>