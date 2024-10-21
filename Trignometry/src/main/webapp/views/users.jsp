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
	          <a class="nav-link" href="admin">Admin</a>
	        </li>
	        <li class="nav-item">
	          <a class="nav-link" href="logout">Logout</a>
	        </li>
	      </ul>
	    </div>
	  </div>
	</nav>
	

	<section class="container my-5 p-4 px-5 rounded border border-secondary shadow">
		<h1 class="mt-3">Trigonometry Records</h1> 
		
		<section class="d-flex justify-content-between" >
			<table class="table" style="width: 70%">
				<tr>
					<th>ID</th>
					<th>Name</th>
					<th>Phone</th>
					<th>Email</th>
					<th>Gender</th>
					<th>Location</th>
				</tr>
				<c:forEach var="user" items="${users}" varStatus="row">
					<tr>
						<td>${row.index+1}</td>
						<td>${user.name}</td>
						<td>${user.phone}</td>
						<td>${user.email}</td>
						<td>${user.gender}</td>
						<td>${user.location}</td>
					</tr>
				</c:forEach>
				
			</table>
			
		</section>
		
		<a href="/" class="btn btn-success mb-3">Back to home</a>
	</section>
</body>
</html>