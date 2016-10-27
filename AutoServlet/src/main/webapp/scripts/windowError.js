    function validateFormRegistration() {
        var a = document.forms["Form"]["login"].value;
        var b = document.forms["Form"]["password"].value;
        var c = document.forms["Form"]["fio"].value;
        if (a == null || a == "", b == null || b == "", c == null || c == "") {
            alert("Пожалуйста, заполните все поля");
            return false;
        }
    }

    function validateFormAddAuto() {
        var a = document.forms["Form"]["name"].value;
        var b = document.forms["Form"]["mileage"].value;
        if (a == null || a == "", b == null || b == "") {
            alert("Пожалуйста, заполните все поля");
            return false;
        }
    }
   