
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
    <form action="Controller">
        <input type="hidden" name="command" value="gotoaddcustomer">
        <input type="submit" value="Create a new customer">
    </form>
    <a href='Controller?command=empmain'>Goto main page</a>
  </body>
</html>
