<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="java.util.Date"%> <!-- Tells us meta info, what language we're using.. etc.. we can add edits later. -->
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page isErrorPage="true" %>  
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<h1>Edit Burger</h1>
<form:form action="/burger/${burger.id}/edit/submit" method="post" modelAttribute="burger">
    <input type="hidden" name="_method" value="put">
    <div>
        <form:label path="burgerName">Burger Name: </form:label>
        <form:errors path="burgerName"/>
        <form:input type="text" path="burgerName"/>
    </div>
    <div>
        <form:label path="restaurantName">Restaurant Name: </form:label>
        <form:errors path="restaurantName"/>
        <form:input type="text" path="restaurantName"/>
    </div>
    <div>
        <form:label path="rating">Rating</form:label>
        <form:errors path="rating"/>
        <form:input type="number" path="rating"/>
    </div>
    <div>
        <form:label path="notes">Notes</form:label>
        <form:errors path="notes"/>     
        <form:textarea path="notes"/>
    </div>    
    <input type="submit" value="Submit"/>
</form:form>

</body>
</html>