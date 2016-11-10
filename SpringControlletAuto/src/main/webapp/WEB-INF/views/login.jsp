<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Login</title>
</head>
<body>
<h2>Авторизация</h2>

<script type="text/javascript">
    function validateForm()
    {
        var a=document.forms["Form"]["userLogin"].value;
        var b=document.forms["Form"]["password"].value;
        if (a==null || a=="",b==null || b=="")
        {
            alert("Логин и пароль не совпадают");
            return false;
        }
    }
</script>

<form action="" method="POST">
    <table border="0">
        <tr>
            <td>Login: </td><td><input type="text" name="userLogin"></td>
        </tr>
        <tr>
            <td>Password: </td><td><input type="password" name="password"></td>
        </tr>
    </table>
        <br>
    <input type="submit" value="Authorization">
    <span class="error">${error}</span>
</form>

<form>
    <input type="button" value="List" onclick="window.location='/list'">
</form>

<form>
    <input type="button" value="Registration" onclick="window.location='/registration'">
</form>

</body>
</html>
