<%@include file="../WEB-INF/jspf/header.jspf" %>
<link rel="stylesheet" type="text/css" href="../Semester3Project/my.css">

<title>Employee Menu</title>
        <div class="inlineDiv">Welcome ${username}</div>
        <br>
        
        <div class="inlineDiv">
            <form action="Controller">
                <input type="hidden" name="command" value="listcustomer">
                <input type="submit" value="See Customers">
            </form>
        </div>

<%@include file="../WEB-INF/jspf/footer.jspf" %>
