<%@ page language="java" contentType="text/html; charset=US-ASCII"
    pageEncoding="US-ASCII"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "https://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=US-ASCII">
<title>First JSP</title>
</head>
<body>
	<form action="create" method="POST">
		Name
		<input type="text" name="name" />
		
		Phone
		<input type="text" name="phone" />
		
		Email
		<input type="email" name="email" />
		
		<button type="submit">Create User</button>
	</form>
</body>
</html>