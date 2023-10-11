<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!-- c:out ; c:forEach etc. --> 
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!-- Formatting (dates) --> 
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!-- form:form -->
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!-- for rendering errors on PUT routes -->
<%@ page isErrorPage="true" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Burger Tracker</title>
    <link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css">
    <link rel="stylesheet" href="/css/main.css"> <!-- change to match your file/naming structure -->
    <script src="/webjars/jquery/jquery.min.js"></script>
    <script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
</head>
<body>
   <div class = "container">
   <h1>Burger Tracker</h1>
   <table class="table table-striped">
	   <thead>
		   	<th>Burger Name</th>
		   	<th>Restaurant Name</th>
		   	<th>Rating (out of 5)</th>
	   </thead>
	   <tbody>
		   	<c:forEach var="burger" items="${allBurgers}">
		   		<tr>
			   		<td><a href="/burgers/${burger.id}/edit"><c:out value="${burger.burgerName}"/></a></td>
			   		<td><c:out value="${burger.restaurantName}"/></td>
			   		<td><c:out value="${burger.rating}"/></td>
		   		</tr>
		   	</c:forEach>
	   </tbody>
   </table>
   </div>
   <div class="container col-4">
   		<h1>Add a Burger</h1>
   		<form:form class ="form" action="/create" method="post" modelAttribute="burger">
	   		<div class="form-group">
	   			<form:label path="burgerName">Burger Name</form:label>
	   			<form:input class="form-control" path="burgerName"/>
	   			<form:errors path="burgerName" class="text-danger"/>
	   		</div>
	   		<div class="form-group">
	   			<form:label path="restaurantName">Restaurant Name</form:label>
	   			<form:input class = "form-control" path="restaurantName"/>
	   			<form:errors path="restaurantName" class="text-danger"/>
	   		</div>
	   		<div class="form-group">
	   			<form:label path="rating">Rating</form:label>
	   			<form:input class="form-control" path="rating"/>
	   			<form:errors path="rating" class="text-danger"/>
	   		</div>
	   		<div class="form-group">
	   			<form:label path="notes">Notes</form:label>
	   			<form:input class="form-control" path="notes"/>
	   			<form:errors path="notes" class="text-danger"/>
	   		</div>
			<button class="btn btn-primary">Submit</button>
		</form:form>
	</div>
</body>
</html>