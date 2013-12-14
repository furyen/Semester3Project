<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@include file="../WEB-INF/jspf/header.jspf" %>
<title>Customer Menu</title>
<div class="myclass">Welcome ${username}</div>
<p><a href="Controller?command=custchat">Chat with employee</a></p>
<p><a href="Controller?command=logout_command">Logout</a></p>

   <h1>Customer Details!</h1>
        <p>${customer.firstName}<br>${customer.lastName}<br>${customer.email}</p>

<%@include file="../WEB-INF/jspf/footer.jspf" %>
