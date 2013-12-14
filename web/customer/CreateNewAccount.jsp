<%@include file="../WEB-INF/jspf/header.jspf" %>
<link rel="stylesheet" type="text/css" href="../Semester3Project/my.css">

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Create a new account for ${customer.firstName} ${customer.lastName}</h1>
        <div style="color: red;">${errorincreating}</div>  
        <form id="addCustomer" action="Controller">
            <div class="inlineDiv" style="text-align: left ">
                <fieldset>
                    <input type="radio" name="accounttype" value="Checking Account" checked="checked">Checking Account<br>
                    <input type="radio" name="accounttype" value="Money Market Account">Money Market Account<br>
                    <input type="radio" name="accounttype" value="Time Deposit">Time Deposit<br>
                    <label for="balance">Balance:</label>
                    <input type='text' name='balance' id='balance'><br>
                    <label for="minimumbalance">Minimum Balance:</label>
                    <input type='text' name='minimumbalance' id='minimumbalance'><br>
                    <label for="interest">Interest:</label>
                    <input type="text" id="interest" name="interest"/>
                    <input type="hidden" name="command" value="custnewaccount">
                    <input type="submit" id="create" value="Create New Account">
                </fieldset>
            </div>
        </form>


    </body>
</html>
