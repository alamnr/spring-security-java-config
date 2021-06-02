<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet" type="text/css"
	href="<c:url value="/static/css/style.css" /> ">
<title>Users</title>
</head>
<body>
<jsp:include page="./layout.jsp"></jsp:include>
<p><span>Name</span></p>
	<c:forEach items="${users}" var="user">
		<p><span>${user.username}</span>&nbsp;&nbsp;&nbsp;<span>${user.password }</span></p><br>
	</c:forEach>
</body>
</html>