<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<title>Student registration form</title>
</head>

<body>
	<form:form action="processForm" modelAttribute="student">

First Name: <form:input path="firstName" />
		<br>
		<br>
Last Name: <form:input path="lastName" />
		<br>
		<br>
		
		Country:
		<form:select path="Country">
			<form:options items="${student.countryOptions}" />
		</form:select>

		<br>
		<br>
		python : <form:radiobutton path="favouriteLanguage" value="python" />
		Java : <form:radiobutton path="favouriteLanguage" value="Java" />
		Ruby : <form:radiobutton path="favouriteLanguage" value="Ruby" />
		c : <form:radiobutton path="favouriteLanguage" value="C" />
		<br>
		Operating Systems :
		Linux : <form:checkbox path="operatingSystems" value="Linux" />
		Windows : <form:checkbox path="operatingSystems" value="Windows" />
		Mac Os : <form:checkbox path="operatingSystems" value="Mac Os" />
		Android : <form:checkbox path="operatingSystems" value="Android" />
		Symbion : <form:checkbox path="operatingSystems" value="Symbion" />
		<input type="submit" value="Submit" />

	</form:form>
</body>
</html>

