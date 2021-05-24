<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib uri="http://www.springframework.org/tags"  prefix="spring"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<spring:url value="/static/css/style.css" var="cssPath"></spring:url>
<link rel="stylesheet" type="text/css" href="${cssPath}">
<title>Ooops! Something went wrong.</title>
</head>
<body>
<jsp:include page="./layout.jsp"></jsp:include>
<h1>Oops error: </h1>
<p>${message}</p>
</body>
</html>