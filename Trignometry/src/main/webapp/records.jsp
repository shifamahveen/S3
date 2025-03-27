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
				<th>Angle</th>
				<th>Function</th>
				<th>Result</th>
			</tr>
		
			<% List<String[]> records = (List<String[]>) request.getAttribute("records");
				if(records != null) {
					for(String[] i: records) {
			%>
						<tr>
							<td><%= i[0] %></td>
							<td><%= i[1] %></td>
							<td><%= i[2] %></td>
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