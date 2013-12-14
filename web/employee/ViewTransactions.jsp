
<%@include file="../WEB-INF/jspf/header.jspf" %> 
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<link rel="stylesheet" type="text/css" href="../Semester3Project/my.css">
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Transactions for account ${account.accountId} </h1>
        <p>Account Type: ${account.accountType}
            <br> Ballance: ${account.balance}
            <br> Create Date : ${account.createdate}
        </p>


        <div class="inlineDiv">
            <h1>Incoming Transactions</h1>
            <table border='1' cellpadding="2" >

                <tr>
                    <td><b>Trans. Id</b></td>
                    <td><b>Sender</b></td>
                    <td><b>Amount</b></td>
                    <td><b>Date</b></td>
                    <td><b>Recipient </b></td>
                </tr>
                <c:forEach var="incoming" items="${incoming}"> 
                    <tr>
                        <td>${incoming.transactionId}</td>
                        <td>${incoming.accountId}</td>
                        <td>${incoming.amount}</td>
                        <td>${incoming.date}</td>
                        <td>${incoming.recipient}</td>
                    </tr>
                </c:forEach>
            </table>
        </div>
        <div class="inlineDiv">
            <h1>Outgoing Transactions</h1> 
            <table border='1' cellpadding="2" >

                <tr>
                    <td><b>Trans. Id</b></td>
                    <td><b>Sender</b></td>
                    <td><b>Amount</b></td>
                    <td><b>Date</b></td>
                    <td><b>Recipient </b></td>
                </tr>
                <c:forEach var="outgoing" items="${outgoing}"> 
                    <tr>
                        <td>${outgoing.transactionId}</td>
                        <td>${outgoing.accountId}</td>
                        <td>${outgoing.amount}</td>
                        <td>${outgoing.date}</td>
                        <td>${outgoing.recipient}</td>
                    </tr>
                </c:forEach>
            </table>
        </div><br>
        <form action="Controller" class="inlineDiv">
            <input type="hidden" name="command" value="viewcustomer">
            <input type="hidden" name="username" value="${account.username}">
            <input type="submit" value="Back to customer">
        </form>
        <form action="Controller" class="inlineDiv">
            <input type="hidden" name="command" value="gotomakenewtransaction">
            <input type="hidden" name="username" value="${account.username}">
            <input type="hidden" name="accountid" value="${account.accountId}">
            <input type="submit" value="Create a Transaction">
        </form>

    </body>
</html>
