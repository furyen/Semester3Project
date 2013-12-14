<%@include file="../WEB-INF/jspf/header.jspf" %>
<link rel="stylesheet" type="text/css" href="../Semester3Project/my.css">

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <script src="http://code.jquery.com/jquery-1.10.1.min.js"></script>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <script>
            $(document).ready(function() {
                validateFields();
                $('input').keyup(function() {
                    validateFields();
                });
                $("#recipient").change(function() {
                    var recipient = $("#recipient").val();
                    $.ajax({
                        url: "CheckAccount",
                        data: {recipient: recipient},
                        success: function(data) {
                            $("#checkResult").html(data);
                            validateFields();
                        }
                    });
                });
                function validateFields() {

                    //Validation
                    var validated = true;
                    if ($('#amount').val().length === 0) {
                        validated = false;
                        disableCreate();
                    }
                    if ($('#info').val().length === 0) {
                        validated = false;
                        disableCreate();
                    }
                    if ($("#checkResult").text() !== "Recipient exists")
                    {
                        validated = false;
                        disableCreate();
                        //If form is validated enable create button

                    }
                    if (validated === true) {
                        $("input[type=submit]").removeAttr("disabled");
                    }
                    function disableCreate() {
                        $('input[type="submit"]').attr('disabled', 'disabled');
                    }

                }
                
            });
        </script>
    </head>
    <body>
        <h1>Create a new Transaction for ${account.accountId}</h1>
        <div style="color: red;">${errorincreating}</div>
        <form action="Controller">
            <p>Amount:<input type='text' name='amount' id='amount'></p>
            <p>Info:<input type='text' name='info' id='info'></p>
            <div id="checkResult"></div>
            <p>Recipient:<input type='text' name='recipient' id='recipient'></p>
            <input type="hidden" name="command" value="makenewowntransaction">
            <input type="hidden" name="accountid" value="${account.accountId}">
            <input type="hidden" name="username" value="${account.username}">
            <input type="submit" value="Create Transaction">

        </form>
    </body>
</html>
