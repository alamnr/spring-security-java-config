<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet" type="text/css"
	href="<c:url value="/static/css/style.css" />">
<title>Add</title>
</head>
<body>
	<jsp:include page="./layout.jsp"></jsp:include>
	result is :
	<%=request.getAttribute("result")%>
	${result}
</body>
</html>