<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>

<head>
	<meta charset="utf-8">
	<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
	<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css" integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">
	<title>Dojos</title>
</head>

<body>
	<div class="container">
		<div class="row p-4 justify-content-center">
			<div class="col-sm-6">
				<h1 class="text-center">List of Dojo Locations</h1>
				<h3 class="text-center"><a href="/dojos/new">New Dojo</a> | <a href="/ninjas/new">New Ninja</a></h3>
			</div>
		</div>
		
		<div class="row">
			<c:if test="${!empty dojos}">
				 <table class="table table-bordered table-striped">
					<thead class="thead-dark">
						<tr>
							<th><h4>Dojo Name</h4></th>
							<th><h4>Ninja Count</h4></th>
						</tr>					        		
					</thead>
					<tbody>
						<c:forEach items="${ dojos }" var="dojo">
							<tr>
								<td><h4><a href="/dojos/${ dojo.id }">${ dojo.name }</a></h4></td>
								<td><h4><c:out value="${dojo.getNinjas().size()}"/> ninjas</h4></td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
			</c:if>
		</div>
		
		<div class="row p-4">
			<div class="col-sm-6">
				<c:if test="${empty dojos}">
					<h1>No Dojos added yet...</h1>
				</c:if>
			</div>
		</div>
		
	</div>
</body>
</html>