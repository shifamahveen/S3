<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.List" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>All Records</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">

</head>
<body>

	<div class="border border-secondary p-5 m-5 rounded shadow w-50 d-block mx-auto">
		<h1 class="text-center py-2">All Records</h1>
		
		<table class="table table-striped">
			<tr>
				<th>SNO</th>
				<th>Angle</th>
				<th>Function</th>
				<th>Result</th>
				<th>Tools</th>
			</tr>
		
			<% List<String[]> records = (List<String[]>) request.getAttribute("records");
				if(records != null) {
					int index = 1;
					for(String[] record: records) {
			%>
						<tr>
							<td><%= index++ %></td>
							<td><%= record[1] %></td>
							<td><%= record[2] %></td>
							<td><%= record[3] %></td>
							<td>
								<a href="EditServlet?id=<%= record[0] %>" class="btn btn-warning">Edit</a>
								<a href="DeleteServlet?id=<%= record[0] %>" class="btn btn-danger" onclick="return confirm('Are your sure?')">Delete</a>
							</td>
						</tr>
			<%			
					}
				}
			%>
		</table>
		<a href="TrigServlet" class="btn btn-primary d-block mx-auto">Back to Home</a>
	</div>

</body>
</html>