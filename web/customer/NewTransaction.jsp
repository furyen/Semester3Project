<%-- 
    Document   : NewTransaction
    Created on : Oct 10, 2013, 12:33:19 PM
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
        <h1>Create a new Transaction for</h1>
       <form action="Controller">
        
        <p>Amount:<input type='text' name='amount' id='amount'></p>
        <p>Info:<input type='text' name='info' id='info'></p>
        <input type="hidden" name="command" value="makenewowntransaction">
        <input type="hidden" name="accountid" value="${account.accountId}">
        <input type="submit" value="Create customer">
        
    </form>
    </body>
</html>
