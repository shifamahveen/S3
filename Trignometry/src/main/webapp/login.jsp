<%@ page language="java" contentType="text/html; charset=US-ASCII"
    pageEncoding="US-ASCII"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "https://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=US-ASCII">
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
<title>Login</title>
</head>
<body>
	<section class="container w-50 container my-5 p-4 px-5 rounded border border-secondary shadow">
		<h1>Login</h1>
		
		<form action="login" method="POST" class="mb-3">
		  
		  <div class="mb-3">
		    <label class="form-label">Phone</label>
		    <input type="text" class="form-control" name="phone"  >
		  </div>
		  	  
		  <div class="mb-3">
		    <label class="form-label">Password</label>
		    <input type="password" class="form-control" name="password"  >
		  </div>
			
		<button type="submit" class="btn btn-primary">Login</button>
		</form>
		<p class="mb-3"> Dont have an account? <a href="register">Register Here</a></p>
	</section>
	
</body>
</html>