<%@ taglib prefix="f" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE html>
<html>
<head>
	<title>Student Registration Form</title>
</head>

<body>
	<f:form action="processForm" modelAttribute="student">
	First Name: <f:input path="firstName" />
	<br><br>
	Last Name: <f:input path="lastName" />
	<br><br>
	
	Country:
	
	<f:select path="country">
		<f:options items="${student.countryOptions}"/>

	</f:select>
	
	<br><br>
	
	Favorite Language:
	
	Java <f:radiobutton path="favoriteLanguage" value="Java" />
	PHP <f:radiobutton path="favoriteLanguage" value="PHP" />
	Ruby <f:radiobutton path="favoriteLanguage" value="Ruby" />
	C# <f:radiobutton path="favoriteLanguage" value="C#" />
	
	<br><br>
	Favorite Operating System:
	
	<f:checkboxes path="favoriteOperatingSystems" 
	items="${student.osOptions}"  />
	
	<br><br>
	
	Favorite Food:
	
	<f:radiobuttons path="favoriteFood" 
	items="${student.foodOptions}"  />
	
	<br><br>
	
	<input type="submit" value="submit" />
	
	</f:form>
</body>

</html>