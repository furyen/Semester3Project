<link rel="stylesheet" type="text/css" href="../Semester3Project/my.css">
<%@include file="../WEB-INF/jspf/header.jspf" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>List Accounts</h1>
        <table border='1'>     
      <c:forEach var="accounts" items="${accounts}">
        <tr>
            <td><a href='Controller?username=${accounts.accountId}&command=viewcustomer'>${accounts.accountId}</a></td>
            <td>${accounts.accountType}</td>
            <td>${accounts.balance}</td>
            <td>${accounts.owner}</td>
        </tr>
          </c:forEach>    
        
    </table>
    </body>
</html>
