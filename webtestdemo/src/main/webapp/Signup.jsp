<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Signup Title</title>
</head>
<body>
	<h1>Signup Form</h1>
	<hr>
	<h6>
		<a href="index.jsp">Back</a>
	</h6>
	<hr>
	${message}
	<br>
	<br>
	<form action="SignupServlet" method="post">
		<label>First Name : </label><input type="text" name="fname"><br>
		<label>Last Name : </label><input type="text" name="lname"><br>
		<label>Username : </label><input type="text" name="username"><br>
		<label>Password : </label><input type="password" name="password"><br>
		<label><input type="submit" value="Signup"></label>
	</form>
</body>
</html>