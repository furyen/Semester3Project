<%@include file="WEB-INF/jspf/header.jspf" %>
        <p><a href="Controller?command=show_date">Show Date</a></p>
        <div class="myclass">Hello</div>
        <p><a href="Controller?command=logout_command">Logout</a></p>
        
        <form action="Controller">
            <input type="hidden" name="command" value="show_date">
            <input type="submit">
        </form>
<%@include file="WEB-INF/jspf/footer.jspf" %>
