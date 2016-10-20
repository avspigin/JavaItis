<%--
  Created by IntelliJ IDEA.
  User: KFU-user
  Date: 20.10.2016
  Time: 11:17
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Owners!</title>
</head>
<body>
<h1>
    Список собственников
</h1>
<p>
    <c:forEach items="${requestScope.myOwners}" var="currentUser">
        <tr>
            <td><c:out value="${currentUser}" /><td>
            <br>
                <%--<td><c:out value="${currentUser.age}" /><td>--%>
        </tr>
    </c:forEach>
</p>

<h2>
    Форма для добавления нового владельца
</h2>

<form action="users" method="post">
    Name: <input type="text" name="name">
    Age: <input type="text" name="age">
    City: <input type="text" name="city">
    <input type="submit" value="Add">
    <span class="error">${error}</span>
</form>
</body>
</html>
