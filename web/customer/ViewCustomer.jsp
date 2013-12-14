<link rel="stylesheet" type="text/css" href="../Semester3Project/my.css">
<%@include file="../WEB-INF/jspf/header.jspf" %>
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
        <div class="inlineDiv" style="text-align: center">
            Accounts <br>
            <table border='1'>   
                <c:forEach var="account" items="${accounts}">
                    <tr>
                        <td><a href='Controller?accountid=${account.accountId}&command=viewowntransactions'>
                                ${account.accountId}</a></td>
                        <td>${account.username}</td>
                    </tr>
                </c:forEach>    
            </table>
        </div>
        <div class="inlineDiv" style="text-align: left">
            First name: ${customer.firstName}<br>
            Last name: ${customer.lastName}<br>
            Email: ${customer.email}</div>
        </br>
        <div class="inlineDiv">
            <form action="Controller">
                <input type="hidden" name="username" value="${customer.username}">
                <input type="hidden" name="command" value="custmain">
                <input type="submit" value="Back">
            </form>
        </div>
        <div class="inlineDiv">
            <form action="Controller">
                <input type="hidden" name="command" value="custnewaccountpage">
                <input type="hidden" name="username" value="${customer.username}">
                <input type="submit" value="Create New Account">
            </form>
        </div>

    </body>
</html>
