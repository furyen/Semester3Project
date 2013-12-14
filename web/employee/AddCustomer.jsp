<%-- 
    Document   : addCustomer
    Created on : 24-09-2013, 09:45:31
    Author     : lam
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <script src="http://code.jquery.com/jquery-1.10.1.min.js"></script>
        <script>
            $(document).ready(function() {
                $("#phoneGet").click(function() {
                    var phone = $("#phone").val();

                    $.ajax({
                        url: "PhoneLookup",
                        data: {phone: phone},
                        cache: false,
                        dataType: "json",
                        success: dataReady
                    });
                    function dataReady(data) {
                        $("#firstname").val(data.firstname);
                        $("#lastname").val(data.lastname);
                        $("#mail").val(data.email);
                        $("#address").val(data.address);
                    }

                });

                validateFields();
                $('input').keyup(function() {
                    validateFields();
                });

                $("#username").change(function() {
                    var username = $("#username").val();
                    $.ajax({
                        url: "CheckUsername",
                        data: {username: username},
                        success: function(data) {
                            $("#checkResult").html(data);
                            validateFields();
                        }
                    });
                });


                function validateFields() {

                    //Validation
                    var validated = true;
                    if ($('#firstname').val().length === 0) {
                        validated = false;
                        disableCreate();
                    } else {
                        $('#firstname').css('textTransform', 'capitalize');
                    }
                    if ($('#lastname').val().length === 0) {
                        validated = false;
                        disableCreate();
                    } else {
                        $('#lastname').css('textTransform', 'capitalize');
                    }
                    if ($("#checkResult").text() !== "Username is available")
                    {
                        validated = false;
                        disableCreate();
                    }
                    if ($('#password').val().length === 0) {
                        validated = false;
                        disableCreate();
                    }
                    if ($('#phone').val().length === 0 || !$.isNumeric($('#phone').val()))
                    {
                        validated = false;
                        disableCreate();
                        $("#phoneGet").attr('disabled', 'disabled');
                    } else {
                        $("#phoneGet").removeAttr("disabled");
                    }
                    if ($('#mail').val().length === 0 || !validateEmail($('#mail').val())) {
                        validated = false;
                        disableCreate();
                    }


                    //If form is validated enable create button
                    if (validated === true) {
                        $("input[type=submit]").removeAttr("disabled");
                    }
                }
                function disableCreate() {
                    $('input[type="submit"]').attr('disabled', 'disabled');
                }
                function validateEmail($email) {
                    var emailReg = /^([\w-\.]+@([\w-]+\.)+[\w-]{2,4})?$/;
                    if (!emailReg.test($email)) {
                        return false;
                    } else {
                        return true;
                    }
                }
            });
        </script>
        <script src="http://code.jquery.com/ui/1.10.3/jquery-ui.js"></script>


        <title>Add Customer</title>
    </head>
    <body>
        <h1>Add customer</h1>
        <div style="color: red;">${errorincreating}</div>
        <form id="addCustomer" action="Controller">

            <p>First Name:<input type='text' name='fisrtname' id='firstname'></p>
            <p>Last Name:<input type='text' name='lastname' id='lastname'></p>
            <p>E-mail:<input type='text' name='mail' id='mail'></p>
            <p>Phone:<input type='text' name='phone' id='phone'><button type="button" id="phoneGet">Get Address from phone</button></p>
            <div id="checkResult"></div>
            <p> Username:<input type='text' name='username' id='username'></p>
            <p>Password:<input type='password' name='password' id='password'></p>
            <input type="hidden" name="command" value="addcustomer">
            <input type="submit" id="create" value="Create customer">

        </form>
        <p id="errorp"></p>
        <a href="Controller?command=main">Goto main page</a>
        <a href="Controller?command=listcustomers">See all customers</a>
    </body>
</html>
