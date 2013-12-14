<link rel="stylesheet" type="text/css" href="../Semester3Project/my.css">
<%@include file="../WEB-INF/jspf/header.jspf" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>List Customers</title>
    </head>
    <body>
        <h1>Customer List</h1>
        <ul class="ul">  
                <c:forEach var="customer" items="${customers}">
                <li>
                    <a href='Controller?username=${customer.username}&command=viewcustomer'>
                        ${customer.username}</a> - ${customer.firstName} ${customer.lastName}
                </li>
            </c:forEach>    
        </ul>
        <form action="Controller">
            <input type="hidden" name="command" value="gotoaddcustomer">
            <input type="submit" value="Create a new customer">
        </form>
        <a href='Controller?command=empmain'>Goto main page</a>
    </body>
</html>
