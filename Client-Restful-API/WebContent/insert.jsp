<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Add</title>
</head>
<body>
	<h1>Add new product</h1>
	<form action="SaveServlet" method="post">
		Name: <input type="text" name="name" /><br> Expire: <input
			type="text" name="expire" /><br> Price: <input type="text"
			name="price" /><br>
		<button>Save</button>
	</form>
</body>
</html>