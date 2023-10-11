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
    <title>Edit Burger</title>
    <link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css">
    <link rel="stylesheet" href="/css/main.css"> <!-- change to match your file/naming structure -->
    <script src="/webjars/jquery/jquery.min.js"></script>
    <script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
</head>
<body>
   <div class = "container">
   <h1>Edit Burger</h1>
	<a href="/">Go back</a>
   		<form:form class ="form" action="/burgers/${burger.id}" method="post" modelAttribute="burger">
	   		<input type="hidden" name="_method" value="put">
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