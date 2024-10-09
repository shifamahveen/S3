<%@ page language="java" contentType="text/html; charset=US-ASCII"
    pageEncoding="US-ASCII"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "https://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=US-ASCII">
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
<title>Edit Form</title>
</head>
<body>
	<section class="container my-5 p-4 px-5 rounded border border-secondary shadow">

		<h1>Trignomotery Calculator</h1>
		
		<form action="update" method="post">
			<input type="hidden" name="_method" value="PUT" />
			<input type="hidden" name="id" value="${record.id}" />
		
		  <div class="mb-3">
		    <label for="angle" class="form-label">Angle</label>
		    <input type="text" class="form-control" id="angle" name="angle" value="${record.angle}" >
		  </div>
		  <div class="mb-3">
		    <label for="" class="form-label">Trignometry Function</label>
		    <select class="form-select" name="func" value="${record.func}" selected>
		    	<option value="sin">sin</option>
		    	<option value="cos">cos</option>
		    	<option value="tan">tan</option>
		    	<option value="sec">sec</option>
		    	<option value="cosec">cosec</option>
		    	<option value="cot">cot</option>
		    </select>
		  </div>
		  <div class="mb-3">
		    <label for="result" class="form-label">Result</label>
		    <input type="text" class="form-control" id="result" name="result" value="${record.result}" >
		  </div>
		  <button type="submit" class="btn btn-primary">Update Record</button>
		</form>
	</section>
</body>
</html>