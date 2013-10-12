<%-- 
    Document   : mobileMainNA
    Created on : Oct 12, 2013, 1:38:35 PM
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
  <div data-role="page" data-theme="b" data-add-back-btn="false">

    <div data-role="header">
      <h1>My Title</h1>
    </div>

    <div data-role="content">
      <p>Address part-1</p>
      <p>Address part-2</p>
      <p>Phone: <a href="tel:33333333">Call us</a></p>
      <p><a href="sms:33333333" data-theme="c" data-role="button">Send us an sms</a></p>
      <p>Email: somthingsomething@darkside.net</p>
      <form action="Controller"
      <input type="submit" value="Log In">
      <input type="hidden" name="command" value="loginmobile">
      </form>
    </div>

    <div data-role="footer" data-position="fixed">
      <h4>My Footer</h4>
    </div>
  </div>
</body>
</html>
