<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Products</title>
</head>
<body>
	<h1>List Products</h1>
	<a href="insert.jsp">Add New</a>
	<table border="1">
		<tr>
			<th>.NO</th>
			<th>Name</th>
			<th>Expire</th>
			<th>Price</th>
			<th>Action</th>
		</tr>
		<c:forEach items="${products}" var="p">
			<tr>
				<td>${p.id}</td>
				<td>${p.name}</td>
				<td>${p.expire}</td>
				<td>${p.price}</td>
				<td><a
					href="EditServlet?id=<fmt:formatNumber type="number" value="${p.id}" />">Edit</a>
					| <a href="DeleteServlet?id=${p.id}">Delete</a></td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>