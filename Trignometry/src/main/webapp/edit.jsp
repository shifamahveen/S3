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
	<% String[] record = (String[]) request.getAttribute("record"); %>
	
	<form action="UpdateServlet" method="POST" class="border border-secondary p-5 m-5 rounded shadow w-50 d-block mx-auto">
		<h1 class="text-center py-2">Update Record</h1>
		<input type="hidden" value=<%= record[0] %> name="id" />
		
		<label for="angle" class="form-label">Angle</label>
		<input type="number" id="angle" name="angle" class="form-control" value=<%= record[1] %> required />
		
		<br>
		<label for="func" class="form-label">Trig Function</label>
		<select name="func" id="func" class="form-select" required >
			<option value="sin" <%= record[2].equals("sin") ? "selected" : "" %>>sin</option>
			<option value="cos" <%= record[2].equals("cos") ? "selected" : "" %>>cos</option>
			<option value="tan" <%= record[2].equals("tan") ? "selected" : "" %>>tan</option>
			<option value="cot" <%= record[2].equals("cot") ? "selected" : "" %>>cot</option>
			<option value="sec" <%= record[2].equals("sec") ? "selected" : "" %>>sec</option>
			<option value="cosec" <%= record[2].equals("cosec") ? "selected" : "" %>>cosec</option>
		</select>
		
		<br>
		<label for="result" class="form-label">Result</label>
		<input type="number" id="result" name="result" class="form-control" value=<%= record[3] %> disabled />
		
		<br>
		<button type="submit" class="btn btn-primary d-block mx-auto">Update</button>		
	</form>

	
</body>
</html>