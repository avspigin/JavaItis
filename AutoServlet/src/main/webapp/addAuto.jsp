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
    <input type="submit" value="Add" onclick="validateFormAddAuto()" id = example-3>
</form>

<script type="text/javascript" src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js">

    $(document).ready(function(){                          // по завершению загрузки страницы
        $('#example-3').click(function(){                  // вешаем на клик по элементу с id = example-3
            // загрузку XML из файла example.xml
                $('#example-3').html('');
                $(xml).find('note').each(function(){       // заполняем DOM элемент данными из XML
                    $('#example-3').append('To: '   + $(this).find('to').text() + '<br/>')
                            .append('From: ' + $(this).find('from').text() + '<br/>')
                            .append('<b>'    + $(this).find('heading').text() + '</b><br/>')
                            .append(           $(this).find('body').text() + '<br/>');
                });
                                                 // указываем явно тип данных
        })
    });



    /*$(document).ready(function() {
        $.ajax({
            url: 'registration.jsp',             // указываем URL и
            dataType: "jsp",                     // тип загружаемых данных
            success: function (data, textStatus) { // вешаем свой обработчик на функцию success
                $.each(data, function (i, val) {    // обрабатываем полученные данные

                });
            }
        });
    });*/
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
        <th>Car Model</th>
        <th>Mileage</th>
    </tr>

    <%--<c: items="${requestScope.owner}" var="currentUser">--%>
        <tr>
        <td><c:out value="${requestScope.owner.userId}" /></td>
        <td><c:out value="${requestScope.owner.userLogin}" /></td>
        <td><c:out value="${requestScope.owner.userFio}" /></td>
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
