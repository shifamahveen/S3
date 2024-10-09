<%@ page language="java" contentType="text/html; charset=US-ASCII"
    pageEncoding="US-ASCII"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "https://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=US-ASCII">
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
<title>First JSP</title>
</head>
<body>
	<section class="container my-5 p-4 px-5 rounded border border-secondary shadow">

		<p class="py-4 text-center">The result of <b>${func}(${angle})</b> is: <b>${result}</b> </p> 
		<div class="d-flex justify-content-center">
			<a href="/" class="btn btn-success mx-2">Back to home</a>
			<a href="/records" class="btn btn-info mx-2">View Logs</a>
		</div>
		
	</section>
</body>
</html>