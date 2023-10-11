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
	<div class=container>
		<h1 class="text-primary">Save Travels</h1>		
		<div>
			<table class="table table-striped">
				<thead>
					<tr>
						<th>Expense</th>
					    <th>Vendor</th>
					    <th>Amount</th>					    
					    <th>Action</th>					    
					    <th></th>				    
					</tr>			
				</thead>
				<tbody>
					<c:forEach items="${alldaExpenses}" var="expense">
						<tr>
							<td><a href="/expenses/${expense.id}">${expense.expenseName}</a></td>						
							<td>${expense.vendor}</td>						
							<td>$${expense.amount}</td>					
							<td><a href="/expenses/edit/${expense.id}">edit</a></td>
							<td>
								<form action="/expenses/${expense.id}" method="post">
									<input type="hidden" name="_method" value="delete">
									<input type="submit" value="delete" class="btn btn-danger">
								</form>
							</td>					
						</tr>
					</c:forEach>													
				</tbody>		
			</table>
		</div>
		
		<div>
			<h1 class="text-primary">Add an expense:</h1>
			<form:form action="/processForm" method="post" modelAttribute="expense">
				<p>
			        <form:label path="expenseName">Expense Name:</form:label>
			        <form:errors path="expenseName" class="text-danger"/>
			        <form:input path="expenseName" class="form-control"/>
			    </p>
			    <p>
			        <form:label path="vendor">Vendor:</form:label>
			        <form:errors path="vendor" class="text-danger"/>
			        <form:input path="vendor" class="form-control"/>
			    </p>
			    
			    <p>
			        <form:label path="amount">Amount:</form:label>
			        <form:errors path="amount" class="text-danger"/>     
			        <form:input path="amount" type="number" class="form-control"/>
			    </p> 
			    <p>
			        <form:label path="description">Description:</form:label>
			        <form:errors path="description" class="text-danger"/>
			        <form:textarea path="description" class="form-control"/>
			    </p>			    
			       
			    <input type="submit" value="Submit" class="btn btn-primary"/>
			</form:form>    
		</div>
	</div>
   
</body>
</html>