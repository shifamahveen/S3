<%@ page language="java" contentType="text/html; charset=US-ASCII"
    pageEncoding="US-ASCII"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "https://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=US-ASCII">
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
<title>First JSP</title>
</head>
<body class="container my-5 border border-secondary shadow-xl">
	<h1>Calculator</h1>
	
	<form action="calc" method="post">
		<div class="my-2">
			<label class="form-label">A</label>
			<input class="form-control" type="text" placeholder="Enter A..." name="a" />
		</div>
		
		<div class="my-2">
			<label class="form-label">B</label>
			<input class="form-control" type="text" placeholder="Enter B..." name="b" />
		</div>
		
		<label class="form-label my-2">Operator</label>
		<select class="form-select" name="opr">
			<option value="add">Addition</option>
			<option value="sub">Subtraction</option>
			<option value="mul">Multiply</option>
			<option value="div">Division</option>
		</select>
		
		<button type="submit" class="btn btn-primary my-2">Calculate</button>
	</form>
</body>
</html>