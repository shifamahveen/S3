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
	<nav class="navbar navbar-expand-lg bg-body-tertiary">
	  <div class="container">
	    <a class="navbar-brand" href="#">Trig App</a>
	    <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarNav" aria-controls="navbarNav" aria-expanded="false" aria-label="Toggle navigation">
	      <span class="navbar-toggler-icon"></span>
	    </button>
	    <div class="collapse navbar-collapse" id="navbarNav">
	      <ul class="navbar-nav">
	        <li class="nav-item">
	          <a class="nav-link active" aria-current="page" href="/">Home</a>
	        </li>
	        <li class="nav-item">
	          <a class="nav-link" href="records">Records</a>
	        </li>
	        <li class="nav-item">
	          <a class="nav-link" href="logout">Logout</a>
	        </li>
	      </ul>
	    </div>
	  </div>
	</nav>
	
	<h1>Hello ${name}</h1>

	<section class="container my-5 p-4 px-5 rounded border border-secondary shadow">
		<h1 class="mt-3">Trigonometry Records</h1> 
		
		<section class="d-flex justify-content-between" >
			<table class="table" style="width: 70%">
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
			
			<div style="width: 25%">
				<h3>Tools</h3>
				<form action="search" method="GET" class="d-flex mt-3">
					<input type="text" name="text" class="form-control rounded-end-0" placeholder="Search here..." />
					<button type="submit" class="btn btn-info rounded-start-0">Search</button>
				</form>
				
				<form action="sort" method="GET" class="d-flex mt-3">
					<select name="orderFunc" class="form-select rounded-end-0">
						<option value="asc">Ascending</option>
						<option value="desc">Descending</option>
					</select>
					<button type="submit" class="btn btn-primary rounded-start-0">Sort</button>
				</form>
			</div>
		</section>
		
		<a href="/" class="btn btn-success mb-3">Back to home</a>
	</section>
</body>
</html>