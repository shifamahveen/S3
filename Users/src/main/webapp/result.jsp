<%@ page language="java" contentType="text/html; charset=US-ASCII"
    pageEncoding="US-ASCII"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "https://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=US-ASCII">
<title>First JSP</title>
</head>
<body>
	<h1>User created succesfully</h1>
	<ul>
		<li>Name: ${name}</li>
		<li>Phone: ${phone}</li>
		<li>Email: ${email}</li>
	</ul>
	
	<a href="/" >Go back</a>
</body>
</html>