<%--
  Created by IntelliJ IDEA.
  User: bot
  Date: 23.02.17
  Time: 11:03
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body><H1>REGISTRATION</H1>
    <form action="/registration" method="post">
        <label for="user_name">Login:</label>
        <input type="text" name="user_name" id="user_name" value="" placeholder="Input">
        <label for="password">Password:</label>
        <input type="password" name="password" id="password" value="" placeholder="Input">
        <label for="email">E-mail:</label>
        <input type="text" name="email" id="email" value="" placeholder="Input">
        <label for="lastName">Last Name:</label>
        <input type="text" name="lastName" id="lastName" value="" placeholder="Input">
        <label for="firstName">First Name:</label>
        <input type="text" name="firstName" id="firstName" value="" placeholder="Input">
        <label for="middleName">Middle Name:</label>
        <input type="text" name="middleName" id="middleName" value="" placeholder="Input">
        <label for="phone">Phone:</label>
        <input type="text" name="phone" id="phone" value="" placeholder="Input">
        <label for="address">Address:</label>
        <input type="text" name="address" id="address" value="" placeholder="Input">
        <input type="submit" value="Submit" formmethod="post">
    </form>
</body>
</html>
