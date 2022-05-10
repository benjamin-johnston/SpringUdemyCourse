<%@ taglib prefix="f" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>

<!DOCTYPE html>

<head>
	<title>Company Home Page</title>
</head>

<body>
	<h2>Company Home Page.</h2>
	
	<p>
	Welcome to company home page.
	</p>
	
	<!-- Display user name and role -->
	
	<hr>
	
	<p>
		User: <security:authentication property="principal.username"/>
		<br><br>
		Role(s): <security:authentication property="principal.authorities" />
	</p>
	
	<security:authorize access="hasRole('MANAGER')">
	<!-- Add a link to point to /leaders ... this is for the managers -->
	<p>
		<a href="${pageContext.request.contextPath}/leaders">Leadership Meeting</a>
		(Only for Manager peoples)
	</p>
	</security:authorize>
	

	
	<security:authorize access="hasRole('ADMIN')">
		<!-- Add a link to point to /leaders ... this is for the managers -->
	<p>
		<a href="${pageContext.request.contextPath}/systems">IT Systems Meeting</a>
		(Only for Wizards)
	</p>
	</security:authorize>

	<hr>
	
	<!-- Add a logout button -->
	<f:form action="${pageContext.request.contextPath}/logout" method="POST">
		<input type="submit" value="Logout" />
	</f:form>
</body>

</html>