<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/security/tags" prefix="sec"%>
<html>
<head>
<link rel="stylesheet" type="text/css"
	href="<c:url value="/static/css/style.css" /> ">
<title>Home page</title>
</head>
<body>
	<jsp:include page="./layout.jsp"></jsp:include>
	<form action="add" method="post">
		<input type="text" name="t1"> <input type="text" name="t2">
		<input type="submit" value="Add">
		<sec:csrfInput/>
	</form>

	<h2>Home page</h2>

	<%-- <c:if test="${pageContext.request.remoteUser!=null }">
		<div class="container">
			<h1>This is secured!</h1>
			<p>
				Hello <b><c:out value="${pageContext.request.remoteUser}" /></b>
			</p>
			<c:url var="logoutUrl" value="/logout" />
			<form class="form-inline" action="${logoutUrl}" method="post">
				<input type="submit" value="Log out" />
				 
				 <sec:csrfInput/>
			</form>
		</div>
	</c:if> --%>
</body>
</html>
