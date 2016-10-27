<%--
  Created by IntelliJ IDEA.
  User: Span
  Date: 24.10.2016
  Time: 15:57
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Add auto</title>
</head>
<body>
<h2>Форма для добавления авто</h2>

<script src="scripts/windowError.js"></script>

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
    <input type="submit" value="Add" onclick="validateFormAddAuto()">
    <span class="error">${error}</span>
</form>

<form>
    <input type="button" value="List" onclick="window.location='/list'">
</form>


</body>
</html>
