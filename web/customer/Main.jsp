<link rel="stylesheet" type="text/css" href="../Semester3Project/my.css">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@include file="../WEB-INF/jspf/header.jspf" %>
<title>Customer Menu</title>
<div class="myclass">Welcome ${username}</div>
<p><a href="Controller?command=custchat">Chat with employee</a></p>
<a href='Controller?username=${customer.username}&command=custdata'>View accounts</a>
<h1>Customer Details!</h1>
<p>${customer.firstName}<br>${customer.lastName}<br>${customer.email}</p>
<a href='Controller?username=${customer.username}&command=custdata'>

    <%@include file="../WEB-INF/jspf/footer.jspf" %>
