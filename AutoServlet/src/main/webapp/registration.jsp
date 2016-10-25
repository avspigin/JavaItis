<%--
  Created by IntelliJ IDEA.
  User: Span
  Date: 24.10.2016
  Time: 15:46
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Registration page</title>
</head>
<body>
<h2>Регистрация</h2>

<form action="registration" method="post">
    <table border="0">
    <tr>
        <td>Login: </td><td><input type="text" name="login"></td>
    </tr>
    <tr>
        <td>Password: </td><td><input type="password" name="password"></td>
    </tr>
    <tr>
        <td>FIO: </td><td><input type="text" name="fio"></td>
    </table>
    <br>
    <input type="submit" value="Registration">
    <span class="error">${error}</span>
</form>

<form>
    <input type="button" value="Login" onclick="window.location='/login'">
</form>
</body>
</html>
