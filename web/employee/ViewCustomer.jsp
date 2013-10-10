<%-- 
    Document   : viewCustomer
    Created on : 24-09-2013, 10:13:49
    Author     : lam
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>View Customer</title>
    </head>
    <body>
        <h1>Customer Details!</h1>
        <p>${customer.firstName}</p>
        <p>${customer.lastName}</p>
        <p>${customer.email}</p>
        <table border='1'>   
            <c:forEach var="account" items="${customer.accounts}">
                <tr>
                    <td>${account.accountId}</td>
                    <td>${account.accountType}</td>
                    <td>${account.balance}</td>
                </tr>
            </c:forEach>    

        </table>
        <a href='Controller?command=empmain'>Back to main page</a>
    </body>
</html>
