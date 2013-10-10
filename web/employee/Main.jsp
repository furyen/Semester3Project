<%@include file="../WEB-INF/jspf/header.jspf" %>
<title>Employee Menu</title>
        <div class="myclass">Welcome ${username}</div>
        <div>
            <form action="Controller">
                <input type="hidden" name="command" value="listcustomer">
                <p><input type="submit" value="See Customers"></p>
            </form>
        </div>
        <div>
            <form action="Controller">
                <input type="hidden" name="command" value="listaccounts">
                <p><input type="submit" value="See Accounts"></p>
            </form>
        </div>
        <p><a href="Controller?command=logout_command">Logout</a></p>
        <form action="Controller">
            <input type="text" name="customerId" id="custid"> 
            <input type="hidden" name="command" value="view_customer">
            <input type="submit">
        </form>
<%@include file="../WEB-INF/jspf/footer.jspf" %>
