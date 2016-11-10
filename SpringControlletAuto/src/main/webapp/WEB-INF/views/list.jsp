<%@ page import="java.util.Iterator" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Owners and Cars</title>
</head>
<body>
<h2>Список владельцев и их авто</h2>
<table border="1">
    <tr>
        <th>User Id</th>
        <th>User Login</th>
        <th>User FIO</th>
        <th>Age</th>
        <th>Car Model</th>
        <th>Mileage</th>
    </tr>

    <c:forEach items="${requestScope.ownersForJsp}" var="currentUser">
    <tr>
        <td><c:out value="${currentUser.userId}" /></td>
        <td><c:out value="${currentUser.userLogin}" /></td>
        <td><c:out value="${currentUser.userFio}" /></td>
        <td><c:out value="${currentUser.age}" /></td>
        <c:forEach items="${requestScope.carsForJsp}" var="currentCar">
            <c:if test="${currentUser.userId == currentCar.userId}">
                <td><c:out value="${currentCar.carName}" /></td>
                <td><c:out value="${currentCar.carMileage}" /></td>
                </tr>
            </c:if>
        </c:forEach>
    </c:forEach>
</table>
<br>
<form>
    <input type="button" value="Add auto" onclick="window.location='/addAuto'">
</form>

</body>
</html>
