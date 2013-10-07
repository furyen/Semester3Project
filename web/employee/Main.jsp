<%@include file="../WEB-INF/jspf/header.jspf" %>
<title>Employee Menu</title>
        <div class="myclass">Welcome ${username}</div>
        
        <p><a href="Controller?command=logout_command">Logout</a></p>
        
        <form action="Controller">
            <input type="text" name="customerId" id="custid"> 
            <input type="hidden" name="command" value="view_customer">
            <input type="submit">
        </form>
<%@include file="../WEB-INF/jspf/footer.jspf" %>
