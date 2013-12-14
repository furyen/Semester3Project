
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>

    <head>
        <meta charset="utf-8" />
  <title>Our Bank</title>
    <link rel="stylesheet" type="text/css" href="my.css">
  <script>
 $(function() {
    $( "#tabs" ).tabs({
      event: "mouseover"
    });
  });
  </script>
    </head>
    <body>
    
       <h1>Log in</h1>
        <div style="color: red;">${error}</div>
        <div class="inlineDiv">
        <form action="Controller" method="post">
            <input type="hidden" name="command" value="login"/>
            <label>
            Username:
            <br/>
            <input type="text" name="username"/>
            <br/>
           <br/>
            Password:  
            <br/>
            <input type="password" name="password">
            <br/>
            <br/>
            <input type="submit" value="Login"/>
            </label>
 
        </form>
        </div>
       
    </body>
</html>
