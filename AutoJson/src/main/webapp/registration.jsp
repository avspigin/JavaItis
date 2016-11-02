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
    <meta http-equiv="Content-Type" content="text/html; charset=unicode"/>
    <meta content="CoffeeCup HTML Editor (www.coffeecup.com)" name="generator"/>
</head>
<body>
<h2>Регистрация</h2>

<script src="scripts/windowError.js"></script>

<form action="" method="post" name="Form">
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
    <input type="submit" value="Registration" onclick="validateFormRegistration()">
    <span class="error">${error}</span>
</form>

<form>
    <input type="button" value="Login" onclick="window.location='/login'">
</form>
</body>
</html>
