<%@include file="../WEB-INF/jspf/header.jspf" %>
<title>Employee Menu</title>
        <div class="myclass">Welcome ${username}</div>
        <div>
            <form action="Controller">
                <input type="hidden" name="command" value="listcustomer">
                <p><input type="submit" value="See Customers"></p>
            </form>
        </div>
        <p><a href="Controller?command=logout_command">Logout</a></p>

<%@include file="../WEB-INF/jspf/footer.jspf" %>
