<%@ page language="java" contentType="text/html; charset=US-ASCII"
    pageEncoding="US-ASCII"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "https://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=US-ASCII">
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
<title>First JSP</title>
</head>
<body>
	<p>Trigonometry Records</p> 
	
	<table>
		<tr>
			<th>ID</th>
			<th>Func</th>
			<th>Angle</th>
			<th>Result</th>
		</tr>
		<c:forEach var="record" items="${records}">
			<tr>
				<td>${record.id}</td>
				<td>${record.func}</td>
				<td>${record.angle}</td>
				<td>${record.result}</td>
			</tr>
		</c:forEach>
		
	</table>
	
	<a href="/" class="btn btn-success">Back to home</a>
</body>
</html>