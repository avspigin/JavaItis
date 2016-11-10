<%--
  Created by IntelliJ IDEA.
  User: Span
  Date: 24.10.2016
  Time: 15:57
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Add auto</title>
</head>
<body>
<h2>Форма для добавления авто</h2>

<script src="../../scripts/windowError.js"></script>

<form action="addAuto" method="post" name="Form">
    <table border="0">
        <tr>
        <td>Model: </td><td><input type="text" name="name"></td>
        </tr>
        <tr>
            <td>Mileage: </td><td><input type="text" name="mileage"></td>
        </tr>
    </table>
    <br>
    <input type="submit" value="Add" onclick="validateFormAddAuto()" id = example-3>
</form>

<script>
    function createRequest() {
        var Request = new XMLHttpRequest();
        if (!Request) {
            alert("Невозможно создать Request!");
        }
        return Request;
    }
    function loginRequest() {
        var Request = createRequest();
        Request.onreadystatechange = function () {
            if (Request.readyState == 4) {
                if (Request.status == 200) {
                    responseHandler(Request);
                } else {
                    alert("Error");
                }
            } else {
                document.getElementById("formDiv").value = "Loading...";
            }
        };
        body = 'name=' + encodeURIComponent(document.getElementById("s_name").value) +
                '&password=' + encodeURIComponent(document.getElementById("password_id").value) +
                '&passwordAgain=' + encodeURIComponent(document.getElementById("password_id2").value) +
                '&city=' + encodeURIComponent(document.getElementById("city_id").value) +
                '&year=' + encodeURIComponent(document.getElementById("year_id").value);
        Request.open('POST', '/studentsAddForm', true);
        Request.setRequestHeader('Content-Type', 'application/x-www-form-urlencoded');
        Request.send(body);
    }
    function responseHandler(Request) {
        document.getElementById("formDiv").innerText = Request.responseText;
    }
</script>

<p>
<td><c:out value="${requestScope.owner}" /></td>
    <br/>
</p>

<table border="1">
    <tr>
        <th>User Id</th>
        <th>User Login</th>
        <th>User FIO</th>
        <th>Age</th>
        <th>Car Model</th>
        <th>Mileage</th>
    </tr>

    <%--<c: items="${requestScope.owner}" var="currentUser">--%>
        <tr>
        <td><c:out value="${requestScope.owner.userId}" /></td>
        <td><c:out value="${requestScope.owner.userLogin}" /></td>
        <td><c:out value="${requestScope.owner.userFio}" /></td>
        <td><c:out value="${requestScope.owner.age}" /></td>
        <c:forEach items="${requestScope.carsForJsp}" var="currentCar">
            <c:if test="${requestScope.owner.userId == currentCar.userId}">
                <td><c:out value="${currentCar.carName}" /></td>
                <td><c:out value="${currentCar.carMileage}" /></td>
                </tr>
            </c:if>
        </c:forEach>
</table>

<form>
    <input type="button" value="List" onclick="window.location='/list'">
</form>


</body>
</html>
