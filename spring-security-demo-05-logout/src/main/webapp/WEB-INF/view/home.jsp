<%@ taglib prefix="f" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE html>

<head>
	<title>Company Home Page</title>
</head>

<body>
	<h2>Company Home Page.</h2>
	
	<p>
	Welcome to company home page.
	</p>
	
	<!-- Add a logout button -->
	<f:form action="${pageContext.request.contextPath}/logout" method="POST">
		<input type="submit" value="Logout" />
	</f:form>
</body>

</html>