<%-- 
    Document   : ViewTransactions
    Created on : Oct 10, 2013, 11:10:35 AM
    Author     : TheOneX
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Transactions for account ${account.accountId} </h1>
        <p>Type: ${account.accountType} Ballance: ${account.balance}</p>
       <table border='1' cellpadding="2">
        <c:forEach var="transaction" items="${transactions}"> 
                   <tr>
                    <td>${transaction.transactionId}</td>
                    <td>${transaction.amount}</td>
                    <td>${transaction.date}</td>
                    <td>${transaction.recipient}</td>
                </tr>
            </c:forEach>
       </table>
       <form action="Controller">
        <input type="hidden" name="command" value="viewcustomer">
        <input type="hidden" name="username" value="${account.username}">
        <input type="submit" value="Back to customer">
    </form>
       <form action="Controller">
        <input type="hidden" name="command" value="gotomakenewtransaction">
        <input type="hidden" name="username" value="${account.username}">
        <input type="hidden" name="accountid" value="${account.accountId}">
        <input type="submit" value="Create a Transaction">
    </form>
        
    </body>
</html>
