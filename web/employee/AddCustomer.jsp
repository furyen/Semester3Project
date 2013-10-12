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
    <title>Add Customer</title>
  </head>
  <body>
    <h1>Add customer</h1>
    <div style="color: red;">${errorincreating}</div>
    <form action="Controller">
        
        <p>First Name:<input type='text' name='fisrtName' id='firstname'></p>
        <p>Last Name:<input type='text' name='lastName' id='lastname'></p>
        <p>e-mail:<input type='text' name='mail' id='mail'></p>
        <p>Username:<input type='text' name='userName' id='usernName'></p>
        <p>Password:<input type='password' name='password' id='password'></p>
        <input type="hidden" name="command" value="addcustomer">
        <input type="submit" value="Create customer">
        
    </form>
    <a href="Controller?command=main">Goto main page</a>
    <a href="Controller?command=listcustomers">See all customers</a>
  </body>
</html>
