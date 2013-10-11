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
        <p>${customer.firstName}<br>${customer.lastName}<br>${customer.email}</p>
        <table border='1'>   
            <c:forEach var="account" items="${customer.accounts}">
                <tr>
                    <td><a href='Controller?accountid=${account.accountId}&command=viewtransactions'>
                            ${account.accountId}</a></td>
                    <td>${account.accountType}</td>
                    <td>${account.balance}</td>
                </tr>
            </c:forEach>    
        </table>
        <form action="Controller">
            <input type="hidden" name="command" value="gotoaddaccount">
            <input type="hidden" name="username" value="${customer.username}">
            <input type="submit" value="Create New Account">
        </form>
        
        <div>
            <form action="Controller">
                <input type="hidden" name="command" value="listcustomer">
                <p><input type="submit" value="Back"></p>
            </form>
            <a href='Controller?command=empmain'>Back to main page</a>
        </div>
    </body>
</html>
