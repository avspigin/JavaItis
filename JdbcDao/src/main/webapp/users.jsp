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
    <title>Собственники</title>
</head>
<body>
<h1>
    <c:forEach items="${requestScope.myUsers}" var="currentUser">
        <tr>
            <td><c:out value="${currentUser.name}" /><td>
            <td><c:out value="${currentUser.age}" /><td>
        </tr>
    </c:forEach>
</h1>
</body>
</html>
