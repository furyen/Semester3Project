<link rel="stylesheet" type="text/css" href="../Semester3Project/my.css">
<%@include file="../WEB-INF/jspf/header.jspf" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Create a new Transaction for ${account.accountId}</h1>
       <div style="color: red;">${errorincreating}</div>
        <form action="Controller">
        <p>Amount:<input type='text' name='amount' id='amount'></p>
        <p>Info:<input type='text' name='info' id='info'></p>
        <p>Recipient:<input type='text' name='recipient' id='recipient'></p>
        <input type="hidden" name="command" value="makenewtransaction">
        <input type="hidden" name="accountid" value="${account.accountId}">
              <input type="hidden" name="username" value="${account.username}">
        <input type="submit" value="Create Transaction">
        
    </form>
    </body>
</html>
