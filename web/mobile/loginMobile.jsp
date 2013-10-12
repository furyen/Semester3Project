<%-- 
    Document   : loginMobileNA
    Created on : Oct 12, 2013, 2:09:11 PM
    Author     : TheOneX
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
    <title>My Page</title> 
    <meta name="viewport" content="width=device-width, initial-scale=1"> 
    <link rel="stylesheet" href="http://code.jquery.com/mobile/1.2.1/jquery.mobile-1.2.1.min.css" />
    <script src="http://code.jquery.com/jquery-1.8.3.min.js"></script>
    <script src="http://code.jquery.com/mobile/1.2.1/jquery.mobile-1.2.1.min.js"></script>
    <script>
      $(document).bind('mobileinit', function() {
        $.mobile.page.prototype.options.addBackBtn = true;
      });
    </script>
  </head>
  <body>
    <div data-role="page" data-theme="b" data-add-back-btn="true">

      <div data-role="header">
        <h1>Something Something Darkside</h1>
      </div>

      <div data-role="content">
        <hr/>
        <form action="Controller">
        <div data-role="fieldcontain">
            <lable for="username" class="ui-hidden-accessible">Username</lable>
            <input type="text" name="username" id="username" value="" placeholder="username"/>
        </div>
        <div data-role="fieldcontain">
            <lable for="password" class="ui-hidden-accessible">Password</lable>
            <input type="text" name="password" id="password" value="" placeholder="password"/>
        </div>
            <input type="submit" value="logon">
            <input type="hidden" name="command" value="mainauthenticateclient">
        </form>
      </div>

      <div data-role="footer" data-position="fixed">
        <h4>My Footer</h4>
      </div>
    </div>
  </body>
</html>
