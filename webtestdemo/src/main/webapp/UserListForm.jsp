<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>User List</title>
</head>
<body>
	<h1>User List</h1>
	<hr>
	
	<table width="100%">
		<thead>
			<tr bgcolor="yellow">
				<th>First Name</th>
				<th>Last Name</th>
				<th>Username</th>
				<th>Password</th>
			</tr>
		</thead>
		
		<tbody>
			<c:forEach  var = "user" items="${ulist}">
				<tr bgcolor="skyblue">
					<td>${user.fname}</td>
					<td>${user.lname}</td>
					<td>${user.username}</td>
					<td>${user.password}</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
</body>
</html>