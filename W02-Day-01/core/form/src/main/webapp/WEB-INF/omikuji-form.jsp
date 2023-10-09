<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <title>Omikuji Form</title>
</head>
<body>
    <h1>Omikuji Form</h1>
    <form action="/omikuji/submit" method="post">
        <label for="fortune">Enter your fortune:</label>
        <input type="text" id="fortune" name="fortune" required>
        <button type="submit">Send</button>
    </form>
</body>
</html>
