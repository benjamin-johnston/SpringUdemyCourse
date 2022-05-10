<%@ taglib prefix="f" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>

<!DOCTYPE html>

<head>
	<title>Wizards Home Page</title>
</head>

<body>
	<h2>Wizards Home Page</h2>
		
	<!-- Display user name and role -->
	<hr>
	
	<p>
		Abra Cadabra!!!
		<br>
		Keep this trip a secret from the normiez.
	</p>
	
	<hr>
	
	<a href="${pageContext.request.contextPath}/">Back to Home Page</a>
</body>

</html>