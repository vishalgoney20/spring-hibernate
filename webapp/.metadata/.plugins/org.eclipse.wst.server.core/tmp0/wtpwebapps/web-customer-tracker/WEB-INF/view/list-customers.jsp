<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<title>List Customers</title>
<link type="text/css" rel="stylesheet"
	href="${pageContext.request.contextPath}/resources/css/style.css" />
</head>

<body>
	<div id="wrapper">
		<div id="header">
			<h3>Customer Relationship Manager</h3>
		</div>
	</div>
	<div id="container">
		<div id="content">

			<input type="button" value="AddCustomer"
				onclick="window.location.href='showFormForAdd';return false;"
				class="add-button" />
			<table>
				<tr>
					<th>First Name</th>
					<th>Last Name</th>
					<th>Email</th>
					<th>Action</th>
				</tr>

				<c:forEach var="temp" items="${customers}">
					<c:url var="updateLink" value="/customer/showformForUpdate">
						<c:param name="customerId" value="${temp.id}"></c:param>
					</c:url>

					<c:url var="deleteLink" value="/customer/delete">
						<c:param name="customerId" value="${temp.id}"></c:param>
					</c:url>
					<tr>
						<td>${temp.firstName}</td>
						<td>${temp.lastName}</td>
						<td>${temp.email}</td>
						<td>
						<a href="${updateLink}">Update</a>
						 |
						 <a	href="${deleteLink}"
						        onclick="if(!(confirm('Are you sure to delete this customer'))) return false">delete</a>
						</td>

					</tr>
				</c:forEach>

			</table>
		</div>
	</div>

</body>
</html>