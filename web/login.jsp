<%-- 
    Document   : login
    Created on : 02-10-2013, 09:32:48
    Author     : hsty
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>

    <head>
        <meta charset="utf-8" />
  <title>Our Bank</title>
  <link rel="stylesheet" href="http://code.jquery.com/ui/1.10.3/themes/smoothness/jquery-ui.css" />
  <script src="http://code.jquery.com/jquery-1.9.1.js"></script>
  <script src="http://code.jquery.com/ui/1.10.3/jquery-ui.js"></script>
    <!--<link rel="stylesheet" href="/resources/demos/style.css" />-->
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
        <div id="tabs">
  <ul>
    <li><a href="#tabs-1">Info about new clients</a></li>
    <li><a href="#tabs-2">About us</a></li>
    <li><a href="#tabs-3">Log in</a></li>
    <li><a href="#tabs-4">Log in as Bank Teller</a></li>
  </ul>
  <div id="tabs-1">
      <p>Hello! We are your choice! Please make your choice carefully! </p>
         <form action="Controller" method="post">
          <input type="hidden" name="command" value="listaccounts"/>
            <input type="submit" value="sget"/>
      </form>
          
  </div>
  <div id="tabs-2">
    <p> A bank is a financial institution and a financial intermediary that accepts deposits and channels those deposits into lending activities, either directly by loaning or indirectly through capital markets. A bank links together customers that have capital deficits and customers with capital surpluses.Banking is a modern sense of the word can be traced to medieval and early Renaissance Italy, to the rich cities in the north like Florence, Lucca, Siena, Venice and Genoa. The Bardi and Peruzzi families dominated banking in 14th century Florence, establishing branches in many other parts of Europe.[2] One of the most famous Italian banks was the Medici Bank, set up by Giovanni di Bicci de' Medici in 1397.[3] The earliest known state deposit bank, Banco di San Giorgio (Bank of St. George), was founded in 1407 at Genoa, Italy.[4] The oldest bank still in existence is Monte dei Paschi di Siena, headquartered in Siena, Italy, which has been operating continuously since 1472.[5] It is followed by Berenberg Bank of Hamburg (1590)[6] and Sveriges Riksbank of Sweden (1668).</p>
  </div>
  <div id="tabs-3">
       <h1>Log in</h1>
        <div style="color: red;">${error}</div>
        <form action="Controller" method="post">
            <input type="hidden" name="command" value="custlogin"/>
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
  <div id="tabs-4">
       <h1>Log in as Bank Teller</h1>
        <div style="color: red;">${error}</div>
        <form action="Controller" method="post">
            <input type="hidden" name="command" value="emplogin"/>
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
</div>
        <img src="http://www.redolivedesign.com/work/web-bank/images/logo-web-bank-main.jpg">
       
    </body>
</html>
