<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>

<head>
	<meta charset="utf-8">
	<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css" integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
	<title>Dojo Page</title>
</head>

<body>
	<div class="container">
		<div class="row p-4 justify-content-center">
			<div>
				<h3 class="text-center"><a href="/">Home</a> | <a href="/ninjas/new">Create Ninja</a></h3>
				<h1 class="text-center"><c:out value="${dojo.name}" /> Location Ninjas</h1>
			</div>
		</div>
		
		<div class="row">
			 <table class="table table-bordered table-striped">
				<thead class="thead-dark">
					<tr>
						<th scope="col"><h4>First Name</h4></th>
						<th scope="col"><h4>Last Name</h4></th>
						<th scope="col"><h4>Age</h4></th>
					</tr>					        		
				</thead>
				<tbody>
					<c:forEach items="${ ninjas }" var="ninja">
						<tr>
							<td><h4><c:out value="${ ninja.firstName }"/></h4></td>
							<td><h4><c:out value="${ ninja.lastName }"/></h4></td>
							<td><h4><c:out value="${ ninja.age }"/></h4></td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</div>
		
	</div>

</body>
</html>