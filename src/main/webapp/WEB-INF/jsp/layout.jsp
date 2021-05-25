<%@ taglib uri="http://www.springframework.org/security/tags" prefix="sec" %>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>

<div>
	<ul class="menu">
		<li><a href="./">home</a></li>
		<li><a href="./about">about</a></li>
		<li><a href="./secure">secure</a></li>
		
		<sec:authorize access="isAuthenticated()">
  			<li>	<p>Welcome <sec:authentication property="name"/> </p>
  			<c:url var="logoutUrl" value="/logout" />
			<form class="form-inline" action="${logoutUrl}" method="post">
				<input type="submit" value="Log out" />				 
				<sec:csrfInput/>
			</form>  
			</li>
		</sec:authorize>
		<sec:authorize access="!isAuthenticated()">
  			<li><a href='<c:url value="/login"></c:url>'>Sign in</a></li>
  			<li><a href='<c:url value="/register"></c:url>'>Register</a></li>
		</sec:authorize>
		
		
	</ul>
</div>