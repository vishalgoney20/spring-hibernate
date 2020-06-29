<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
<title> Customer Confirmation </title>
</head>

<body>
 Customer is confirmed : ${customer.firstName}  ${customer.lastName}
 <br>
 free Passes : ${customer.freePasses}
  <br>
Postal Code : ${customer.postalCode}
  <br>
Course Code : ${customer.courseCode}
</body>

</html>