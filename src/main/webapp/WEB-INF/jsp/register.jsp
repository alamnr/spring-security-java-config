<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="sp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Register</title>
<link rel="stylesheet" type="text/css"
	href="<c:url value="/static/css/style.css" /> ">
</head>
<body>
<jsp:include page="./layout.jsp"></jsp:include>
	<h1>Register</h1>
	<c:url value="/register" var="registerUrl"/>
	<sp:form action="${registerUrl}" method="post">
		<div>
			<label for="username">User name:</label>
			<input type="text" name="username" >
		</div>
		<div>
			<label for="firstName">First Name:</label>
			<input name="firstName" type="text">
		</div>
		<div>
			<label for="lastName">Last Name:</label>
			<input name="lastName" type="text">
		</div>
		<div>
			<label for="email">Email</label>
			<input name="email" type="email">
		</div>
		<div>
			<label for="password">Password</label>
			<input type="password" name="password">
		</div>
		<div>
			<input type="submit" >
		</div>
	</sp:form>
</body>
</html>