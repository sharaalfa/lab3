<%@ taglib prefix="c"
           uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>List</h1>
<a href="/add/">Add roles</a>
<table border="1" cellpadding="5" cellspacing="0">
    <c:forEach items="${rolesList}" var="roles">
        <tr>
            <td><c:out value="${roles.id}"></c:out></td>
            <td><c:out value="${roles.name}"></c:out></td>
            <td><c:out value="${roles.description}"></c:out></td>
            <td><a href="/del/?id=<c:out value="${roles.id}"></c:out>">delete</a></td>
            <td><a href="/edit/?id=<c:out value="${roles.id}"></c:out>">edit</a></td>
        </tr>
    </c:forEach>
</table>

</body>
</html>
