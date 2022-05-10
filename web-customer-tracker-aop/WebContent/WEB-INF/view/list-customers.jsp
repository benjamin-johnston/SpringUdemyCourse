<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page import="com.luv2code.springdemo.util.SortUtils" %>

<!DOCTYPE html>

<head>
	<title>List Customers</title>
	
	<link type="text/css"
		rel="stylesheet"
		href="${pageContext.request.contextPath}/resources/css/style.css">
</head>

<body>

	<div id="wrapper">
		<div id ="header">
			<h2>CRM - Customer Relationship Manager</h2>
		</div>
	</div>
	
	<div id="container">
		<!-- Add customer button -->
		<input type="button" value="Add Customer"
			onclick="window.location.href='showFormForAdd'; return false;"
			class="add-button"/>
			
	    <!--  add a search box -->
        <form:form action="search" method="GET">
            Search customer: <input type="text" name="searchName" />
             
        	<input type="submit" value="Search" class="add-button" />
        </form:form>
		<!--  add out html table here -->
		<div id="content">
			<table>
				<tr>
					<!-- construct a sort link for first name -->
					<c:url var="sortLinkFirstName" value="/customer/list">
						<c:param name="sort" value="<%= Integer.toString(SortUtils.FIRST_NAME) %>" />
					</c:url>
					<th><a href="${sortLinkFirstName}">First Name</a></th>
					<!-- construct a sort link for last name -->
					<c:url var="sortLinkLastName" value="/customer/list">
						<c:param name="sort" value="<%= Integer.toString(SortUtils.LAST_NAME) %>" />
					</c:url>	
					<th><a href="${sortLinkLastName}">Last Name</a></th>
					<!-- construct a sort link for email -->
					<c:url var="sortLinkEmail" value="/customer/list">
						<c:param name="sort" value="<%= Integer.toString(SortUtils.EMAIL) %>" />
					</c:url>
					<th><a href="${sortLinkEmail}">Email</a></th>
					<th>Action</th>
				</tr>
				<!-- loop over and print our customers -->
				<c:forEach var="customer" items="${customers}">
				
					<!-- construct an "update" link variable with customer id -->
					<c:url var="updateLink" value="/customer/showFormForUpdate">
						<c:param name="customerId" value="${customer.id}" />
					</c:url>
					
					<!-- construct a "delete" link variable with customer id -->
					<c:url var="deleteLink" value="/customer/delete">
						<c:param name="customerId" value="${customer.id}" />
					</c:url>
					
					<tr>
						<td>${customer.firstName}</td>
						<td>${customer.lastName}</td>
						<td>${customer.email}</td>
						<td>
							<!-- display the update link -->
							<a href="${updateLink}">Update</a>
							|
							<a href="${deleteLink}"
								onclick="if (!(confirm('Are you sure you want to delete this customer?'))) return false"
							>Delete</a>
						</td>
					</tr>
				</c:forEach>
			</table>
		</div>
	
	</div>


</body>


</html>