<%-- 
    Document   : show_customers
    Created on : 23-09-2013, 10:56:13
    Author     : hsty
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Customers</h1>
        <c:forEach items="${customers}" var="customer">
            <div>${customer.firstName} ${customer.lastName}</div>
        </c:forEach>
    </body>
</html>
