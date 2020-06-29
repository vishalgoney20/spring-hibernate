<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<title>Student Confirmation Page</title>
</head>

<body>

	The Student is :${student.firstName} ${student.lastName}
	<br> Country is : ${student.country}
	<br> Favourite Language is : ${student.favouriteLanguage}
	<br>
	<ul>
		<c:forEach var="item" items="${student.operatingSystems}">
			<li>${item}</li>
		</c:forEach>
	</ul>
</body>
</html>

