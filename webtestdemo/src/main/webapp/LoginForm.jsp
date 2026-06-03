<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>Login Form</h1>
	<hr>
	<h6>
		<a href="index.jsp">Back</a>
	</h6>
	<hr>
	<h4>${message}</h4>
	<hr>
	<form action="HomePage" method="post">
		<label>Username : </label><input type="username" name="username"><br>
		<label>Password : </label><input type="password" name="password"><br>
		</label><input type="submit" value="Login">
	</form>
</body>
</html>