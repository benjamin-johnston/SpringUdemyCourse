<%@ taglib prefix="f" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE html>

<head>
	<title>Save Customer</title>

	<link type="text/css"
		rel="stylesheet"
		href="${pageContext.request.contextPath}/resources/css/style.css">
		
			
	<link type="text/css"
		rel="stylesheet"
		href="${pageContext.request.contextPath}/resources/css/add-customer-style.css">
		
</head>

<body>
	<div id="wrapper">
	
		<div id ="header">
			<h2>CRM - Customer Relationship Manager</h2>
		</div>
	</div>
	
	<div id="container">
		<h3>Save Customer</h3>
		
		<f:form action="saveCustomer" modelAttribute="customer" method="POST">
			
			<!-- Need to associate this data with a customer id -->
			<f:hidden path="id" />
			
			<table>
				<tbody>
					<tr>
						<td><label>First Name:</label></td>
						<td><f:input path="firstName" /></td>
					</tr>
					<tr>
						<td><label>Last Name:</label></td>
						<td><f:input path="lastName" /></td>
					</tr>
					<tr>
						<td><label>Email:</label></td>
						<td><f:input path="email" /></td>
					</tr>
					<tr>
						<td><label></label></td>
						<td><input type="submit" value="save" class="save" /></td>
					</tr>
				</tbody>
			
			</table>
		</f:form>
		
		<div style="clear; both;"></div>
		
		<p>
			<a href="${pageContext.request.contextPath}/customer/list">Back to List</a>
		</p>
	</div>
	
</body>
</html>