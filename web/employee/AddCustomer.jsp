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
    <form action="Controller">
        
        <input type="text" name="command" value="addcustomer">
        <input type="hidden" name="command" value="addcustomer">
        
    </form>
    <a href="Controller?command=main">Goto main page</a>
    <a href="Controller?command=listcustomers">See all customers</a>
  </body>
</html>