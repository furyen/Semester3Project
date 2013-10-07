
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
  <head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>List Customers</title>
  </head>
  <body>
    <h1>List Customers</h1>
    <table border='1'>     
      <c:forEach var="customer" items="${customers}">
        <tr><td>
            <a href='Controller?custid=${customer.customerId}&command=viewcustomer'>
              ${customer.customerId}</a></td><td>${customer.firstName} 
            ${customer.lastName}</td></tr>
          </c:forEach>    
    </table>
    <a href='Controller?custid=1001&command=viewcustomer'>See 1001</a>
    <form action='Controller'>
      <label>Enter id for customer</label>
      <input type='text' name='custid' id='custid'>
      <input type='hidden' name='command' value='viewcustomer'>
      <input type='submit' value='show details'>
    </form>



    <a href='Controller?command=viewcustomer'>SEE CUSTOMER</a>
    <a href='Controller?command=main'>Goto main page</a>
  </body>
</html>
