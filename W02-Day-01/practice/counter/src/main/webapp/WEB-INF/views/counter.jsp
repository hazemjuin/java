<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <title>Visitor Counter</title>
</head>
<body>
    <h1>Visitor Counter</h1>
    <p>Number of visits: ${counter}</p>
    <a href="<%= request.getContextPath() %>/increment">Increment Counter</a>
    <a href="<%= request.getContextPath() %>/incrementby2">Increment by 2</a>
    <a href="<%= request.getContextPath() %>/reset">Reset Counter</a>
</body>
</html>
