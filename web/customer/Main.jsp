<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@include file="../WEB-INF/jspf/header.jspf" %>
<title>Customer Menu</title>
<div class="myclass">Welcome ${username}</div>

<p><a href="Controller?command=logout_command">Logout</a></p>

   <h1>Customer Details!</h1>
        <p>${customer.firstName}<br>${customer.lastName}<br>${customer.email}</p>
        <table border='1'>   
            <c:forEach var="account" items="${customer.accounts}">
                <tr>
                    <td><a href='Controller?accountid=${account.accountId}&command=viewowntransactions'>
                            ${account.accountId}</a></td>
                    <td>${account.accountType}</td>
                    <td>${account.balance}</td>
                </tr>
            </c:forEach>    
        </table>
<%@include file="../WEB-INF/jspf/footer.jspf" %>
