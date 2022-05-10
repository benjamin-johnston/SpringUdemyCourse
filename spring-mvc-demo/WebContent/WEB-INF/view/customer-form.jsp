<%@ taglib prefix="f" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE html>
<html>
<head>
	<title>Customer Registration Form</title>
	
	<style>
		.error {color:red}
	</style>
</head>

<body>
	<i>Fill out the form. Asterisk (*) means required.</i>
		
	<br><br>
		
	<f:form action="processForm" modelAttribute="customer">
		First Name: <f:input path="firstName" />
		
		<br><br>
		
		Last Name (*): <f:input path="lastName" />
		<f:errors path="lastName" cssClass="error" />
		
		<br><br>
		
		Free passes (*): <f:input path="freePasses" />
		<f:errors path="freePasses" cssClass="error" />
		
		<br><br>
		
		Postal Code: <f:input path="postalCode" />
		<f:errors path="postalCode" cssClass="error" />
		
		<br><br>
		
		Course Code: <f:input path="courseCode" />
		<f:errors path="courseCode" cssClass="error" />
		
		<br><br>
			
		<input type="submit" value="submit" />
	</f:form>
</body>

</html>