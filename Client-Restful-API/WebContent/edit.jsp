<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Edit</title>
</head>
<body>
	<h1>Edit product</h1>
	<form action="UpdateServlet" method="post">
		<input type="hidden" name="id" value="${product.id}" /> Name: <input
			type="text" name="name" value="${product.name}" /><br> Expire:
		<input type="text" name="expire" value="${product.expire}" /><br>
		Price: <input type="number" name="price" value="${product.price}" /><br>
		<button>Update</button>
	</form>
</body>
</html>