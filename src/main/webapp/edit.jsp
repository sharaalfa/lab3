
<%@ page import="models.pojo.Roles" %><%--
  Created by IntelliJ IDEA.
  User: innopolis
  Date: 25.02.17
  Time: 12:51
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>Edit</h1>
<% Roles roles = (Roles) request.getAttribute("roles");%>
<form action="/edit/?id=<%= roles.getId() %>" method="post">
    <div>
        <label for="name">name</label>
        <input type="text" name="name" id="name" value="<%= roles.getName()%>">
    </div>
    <div>
        <label for="description"></label>
        <input type="text" name="description" id="description" value="<%= roles.getDescription()%>">
    </div>
    <div>
        <input type="submit" value="Save">
    </div>
</form>


</body>
</html>
