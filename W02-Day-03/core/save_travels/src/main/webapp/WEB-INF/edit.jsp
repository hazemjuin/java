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
    <title>Save Travels</title>
    <link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css">
    <link rel="stylesheet" href="/css/main.css"> <!-- change to match your file/naming structure -->
    <script src="/webjars/jquery/jquery.min.js"></script>
    <script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
</head>
<body>
	<div class="container">
		<div class="d-flex justify-content-between align-items-center">
			<h1 class="text-success">Edit Expense</h1>
			<a href="/expenses">Go back</a>
		</div>
		
	
		<form:form action="/expenses/${expense.id}" method="post" modelAttribute="expense">
			<input type="hidden" name="_method" value="put">
			<p>
				<form:label path="expenseName">Expense Name:</form:label>
				<form:errors path="expenseName"/>
				<form:input path="expenseName" class="form-control"/>
			</p>
			<p>
				 <form:label path="vendor">Vendor:</form:label>
				 <form:errors path="vendor"/>
				 <form:input path="vendor" class="form-control"/>
			</p>
				    
			<p>
				<form:label path="amount">Amount:</form:label>
				<form:errors path="amount"/>     
				<form:input path="amount" type="number" class="form-control"/>
			</p> 
			<p>
				<form:label path="description">Description:</form:label>
				<form:errors path="description"/>
				<form:textarea path="description" class="form-control"/>
			</p>			    
				       
			<input type="submit" value="Submit" class="btn btn-primary"/>
		</form:form>    	 	 	
	</div> 
				
</body>
</html>