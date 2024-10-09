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
	<section class="container my-5 p-4 px-5 rounded border border-secondary shadow">
		<h1 class="mt-3">Trigonometry Records</h1> 
		
		<table class="table">
			<tr>
				<th>ID</th>
				<th>Func</th>
				<th>Angle</th>
				<th>Result</th>
				<th>Edit</th>
				<th>Delete</th>
			</tr>
			<c:forEach var="record" items="${records}" varStatus="count">
				<tr>
					<td>${count.index+1}</td>
					<td>${record.func}</td>
					<td>${record.angle}</td>
					<td>${record.result}</td>
					<td><a href="edit?id=${record.id}" class="btn btn-warning">Edit</a></td>
					<td>
						<form action="delete/${record.id}" method="POST">
							<input type="hidden" name="_method" value="DELETE" />
							<button type="submit" class="btn btn-danger">Delete</button>
						</form>
					</td>
				</tr>
			</c:forEach>
			
		</table>
		
		<a href="/" class="btn btn-success mb-3">Back to home</a>
	</section>
</body>
</html>