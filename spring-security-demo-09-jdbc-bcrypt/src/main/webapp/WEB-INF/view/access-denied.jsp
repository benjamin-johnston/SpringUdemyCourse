<%@ taglib prefix="f" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>

<!DOCTYPE html>

<head>
	<title>Access Denied</title>
</head>

<body>
	<h2>Access Denied - You are not authorized to access this page.</h2>
			
	<hr>
	
	<a href="${pageContext.request.contextPath}/">Back to Home Page</a>
</body>

</html>