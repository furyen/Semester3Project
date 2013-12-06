<%-- 
    Document   : addCustomer
    Created on : 24-09-2013, 09:45:31
    Author     : lam
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <script src="http://code.jquery.com/jquery-1.10.1.min.js"></script>
    <script src="http://code.jquery.com/ui/1.10.3/jquery-ui.js"></script>
        <script>
        $(document).ready(function(){
            
            
            
          $("#btn").click(function(){
              $.ajax({
                  url: "AjaxController",
                        data: "phone="+$("#phone").val(),
                        cache: false,
                        dataType: "json",
                        success: dataReady
              });
          });
          
          $("#usernName").keyup(check_user);
          function check_user(){
              var username = $("#userName").val();
              if(username === ""){
                 $('#userName').css('border', '3px #CCC solid'); 
              }else{
                  $.ajax({
                  url:"AjaxController",
                  cache: false,
                  dataType:"json",
                  success:userCheked
              });
              }
          }
          function userCheked(data){
             $("#errorp").val(data); 
          }
          
        });
        function dataReady(data){
            $("#firstname").val(data.firstname);
            $("#lastname").val(data.lastname);
            $("#mail").val(data.email);
            $("#address").val(data.address);
        }
        </script>
        <title>Add Customer</title>
    </head>
    <body>
        <h1>Add customer</h1>
        <div style="color: red;">${errorincreating}</div>
        <form action="Controller">

            <p>First Name:<input type='text' name='fisrtName' id='firstname'></p>
            <p>Last Name:<input type='text' name='lastName' id='lastname'></p>
            <p>E-mail:<input type='text' name='mail' id='mail'></p>
           <p>Phone:<input type='text' name='phone' id='phone'></p><button id="btn">Get Address from phone</button>
            <p>Username:<input type='text' name='userName' id='usernName'></p>
            <p>Password:<input type='password' name='password' id='password'></p>
            <input type="hidden" name="command" value="addcustomer">
            <input type="submit" value="Create customer">

        </form>
        <p id="errorp"></p>
        <a href="Controller?command=main">Goto main page</a>
        <a href="Controller?command=listcustomers">See all customers</a>
    </body>
</html>
