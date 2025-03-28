<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Trigonometry Calculator</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
</head>
<body>
	<form action="TrigServlet" method="POST" class="border border-secondary p-5 m-5 rounded shadow w-50 d-block mx-auto">
		<h1 class="text-center py-2">Trigonometry Calculator</h1>
		<label for="angle" class="form-label">Angle</label>
		<input type="number" id="angle" name="angle" class="form-control" required />
		
		<br>
		<label for="func" class="form-label">Trig Function</label>
		<select name="func" id="func" class="form-select" required >
			<option value="sin">sin</option>
			<option value="cos">cos</option>
			<option value="tan">tan</option>
			<option value="cot">cot</option>
			<option value="sec">sec</option>
			<option value="cosec">cosec</option>
		</select>
		
		<br>
		<button type="submit" class="btn btn-primary d-block mx-auto">Calculate</button>
		<a href="RecordsServlet" class="btn btn-success">Go to Records</a>
		
	</form>

	
</body>
</html>