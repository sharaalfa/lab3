<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Login</title>
</head>
<body>
<div>
    <a href="/registration">Регистрация</a>
    <form action="/user_name" method="post">
        <label for="user_name">Login:</label>
        <input type="text" name="Login" id="user_name" value="" placeholder="Input">
        <label for="password">Password:</label>
        <input type="password" name="password" id="password" value="" placeholder="Input">

        <input type="submit" value="Login in" formmethod="post">
    </form>
</div>

</body>
</html>
