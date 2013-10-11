<%-- 
    Document   : CreateNewAccount
    Created on : Oct 11, 2013, 1:27:07 PM
    Author     : TheOneX
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Create a new account for ${customer.firstName} ${customer.lastName}</h1>
        
        <form action="Controller">
            <input type="radio" name="accounttype" value="Checking Account">Checking Account<br>
            <input type="radio" name="accounttype" value="Money Market Account">Money Market Account<br>
            <input type="radio" name="accounttype" value="Time Deposit">Time Deposit<br>
            Balance:<input type="text" name="balance"><br>
            <input type="hidden" name="username" value="${customer.username}">
            <input type="hidden" name="command" value="addaccount">
            <input type="submit" value="Create New Account"> 
            
            
        </form>
            
    </body>
</html>
