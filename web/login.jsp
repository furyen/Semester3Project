<%-- 
    Document   : login
    Created on : 02-10-2013, 09:32:48
    Author     : hsty
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>

    <head>
        <meta charset="utf-8" />
  <title>jQuery UI Tabs - Open on mouseover</title>
  <link rel="stylesheet" href="http://code.jquery.com/ui/1.10.3/themes/smoothness/jquery-ui.css" />
  <script src="http://code.jquery.com/jquery-1.9.1.js"></script>
  <script src="http://code.jquery.com/ui/1.10.3/jquery-ui.js"></script>
  <link rel="stylesheet" href="/resources/demos/style.css" />
  <script>
 $(function() {
    $( "#tabs" ).tabs({
      event: "mouseover"
    });
  });
  </script>
    </head>
    <body>
        <div id="tabs">
  <ul>
    <li><a href="#tabs-1">Info about new clients</a></li>
    <li><a href="#tabs-2">About us</a></li>
    <li><a href="#tabs-3">Log in</a></li>
    <li><a href="#tabs-4">Log in as BankTeller</a></li>
  </ul>
  <div id="tabs-1">
    <p>Proin elit arcu, rutrum commodo, vehicula tempus, commodo a, risus. Curabitur nec arcu. Donec sollicitudin mi sit amet mauris. Nam elementum quam ullamcorper ante. Etiam aliquet massa et lorem. Mauris dapibus lacus auctor risus. Aenean tempor ullamcorper leo. Vivamus sed magna quis ligula eleifend adipiscing. Duis orci. Aliquam sodales tortor vitae ipsum. Aliquam nulla. Duis aliquam molestie erat. Ut et mauris vel pede varius sollicitudin. Sed ut dolor nec orci tincidunt interdum. Phasellus ipsum. Nunc tristique tempus lectus.</p>
  </div>
  <div id="tabs-2">
    <p>Morbi tincidunt, dui sit amet facilisis feugiat, odio metus gravida ante, ut pharetra massa metus id nunc. Duis scelerisque molestie turpis. Sed fringilla, massa eget luctus malesuada, metus eros molestie lectus, ut tempus eros massa ut dolor. Aenean aliquet fringilla sem. Suspendisse sed ligula in ligula suscipit aliquam. Praesent in eros vestibulum mi adipiscing adipiscing. Morbi facilisis. Curabitur ornare consequat nunc. Aenean vel metus. Ut posuere viverra nulla. Aliquam erat volutpat. Pellentesque convallis. Maecenas feugiat, tellus pellentesque pretium posuere, felis lorem euismod felis, eu ornare leo nisi vel felis. Mauris consectetur tortor et purus.</p>
  </div>
  <div id="tabs-3">
       <h1>Login</h1>
        <div style="color: red;">${error}</div>
        <form action="Controller" method="post">
            <input type="hidden" name="command" value="customerLogin"/>
            <p>Username: <input type="text" name="username"/></p>
            <p>Password: <input type="password" name="password"></p>
            <p><input type="submit" value="Login"/></p>
        </form>
  </div>
  <div id="tabs-4">
       <h1>Log in as BankTeller</h1>
        <div style="color: red;">${error}</div>
        <form action="Controller" method="post">
            <input type="hidden" name="command" value="employeeLogin"/>
            <p>Username: <input type="text" name="username"/></p>
            <p>Password: <input type="password" name="password"></p>
            <p><input type="submit" value="Login"/></p>
        </form>
  </div>
</div>
        <img src="http://www.redolivedesign.com/work/web-bank/images/logo-web-bank-main.jpg"style="position: absolute; center: 50px; right:50px">
       
    </body>
</html>
