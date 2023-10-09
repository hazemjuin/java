<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Ninja Gold Game</title>
    <!-- Include any CSS or JavaScript files you need -->
</head>
<body>
    <h1>Welcome to the Ninja Gold Game</h1>
    <p>Current Gold: <span id="gold"><%= player.getGold() %></span></p>
    
    <form action="/process" method="post">
        <button type="submit" name="action" value="farm">Farm</button>
        <button type="submit" name="action" value="cave">Cave</button>
        <button type="submit" name="action" value="house">House</button>
        <button type="submit" name="action" value="quest">Quest</button>
        <button type="submit" name="action" value="spa">Spa</button>
    </form>

    <a href="/activity">Activity Log</a>
</body>
</html>
