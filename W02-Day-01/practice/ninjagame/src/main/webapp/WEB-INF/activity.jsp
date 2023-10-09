<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Activity Log</title>
    <!-- Include any CSS or JavaScript files you need -->
</head>
<body>
    <h1>Activity Log</h1>
    
    <ul>
        <c:forEach items="${activities}" var="activity">
            <li>${activity}</li>
        </c:forEach>
    </ul>
    
    <a href="/">Back to Game</a>
</body>
</html>
