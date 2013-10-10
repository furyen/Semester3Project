<%-- 
    Document   : login
    Created on : 02-10-2013, 09:32:48
    Author     : hsty
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>

    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Login</title>
    </head>
    <body>
        <h1>Employee Login</h1>
        <div style="color: red;">${error}</div>
        <form action="Controller" method="post">
            <input type="hidden" name="command" value="employeeLogin"/>
            <p>Username: <input type="text" name="username"/></p>
            <p>Password: <input type="password" name="password"></p>
            <p><input type="submit" value="Login"/></p>
        </form>
        
             <h1>Customer Login</h1>
        <div style="color: red;">${error}</div>
        <form action="Controller" method="post">
            <input type="hidden" name="command" value="customerLogin"/>            
            <p>Username: <input type="text" name="username"/></p>
            <p>Password: <input type="password" name="password"></p>
            <p><input type="submit" value="Login"/></p>
    </body>
</html>
