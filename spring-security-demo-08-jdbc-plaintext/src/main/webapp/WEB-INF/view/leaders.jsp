<%@ taglib prefix="f" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>

<!DOCTYPE html>

<head>
	<title>Leaders Home Page</title>
</head>

<body>
	<h2>Leaders Home Page</h2>
		
	<!-- Display user name and role -->
	<hr>
	
	<p>
		See you in Brazil ... for our annual Leadership retreat!
		<br>
		Keep this trip a secret, don't tell the regular emps.
	</p>
	
	<hr>
	
	<a href="${pageContext.request.contextPath}/">Back to Home Page</a>
</body>

</html>