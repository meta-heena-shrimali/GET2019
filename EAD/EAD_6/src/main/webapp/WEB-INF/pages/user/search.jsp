<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Search User By Name</title>
</head>
<body>
	<%@include file="../header.html"%>
	<form action="search" method="post">
		<span>Search By</span>
		<input type="radio" name="searchBy" value="first_name" checked> First Name<br>
		<input type="radio" name="searchBy" value="last_name"> Last Name<br>
		<input type="radio" name="searchBy" value="contact_no"> Contact Number<br>
		<input type="radio" name="searchBy" value="email"> Email Id
		
		<input  name="userInfo" placeholder="Enter user data" type="text"/>  
		<input type="submit" value="submit">
	</form>
</body>
</html>