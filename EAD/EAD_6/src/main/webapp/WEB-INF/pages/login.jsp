<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>User Portal</title>
	</head>
	<body>
		<h1>Login</h1>
		 <form action="login" method="post">
			<span>Username</span><input type="text" name="username" required /><br>
			<span>password</span><input type="password" name="password" required /><br>
			<input type="submit" value="submit">
		</form>
	</body>
</html>