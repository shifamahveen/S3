<%@ page language="java" contentType="text/html; charset=US-ASCII"
    pageEncoding="US-ASCII"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "https://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=US-ASCII">
<title>First JSP</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
</head>
<body>
	<form action="addStudent" method="POST">
		<label>ID</label>
		<input type="number" name="id" />
		<br>
		
		<label>Name</label>
		<input type="text" name="name" />
		<br>
		
		<label>BAtch</label>
		<input type="text" name="batch" />
		<br>
		
		<button type="submit">Create Record</button>
	</form>
</body>
</html>