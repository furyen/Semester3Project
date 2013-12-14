<%-- 
    Document   : Chat
    Created on : Dec 14, 2013, 12:44:18 AM
    Author     : Petko
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <script src="http://code.jquery.com/jquery-1.10.1.min.js"></script>
        <script>
            var ws = new WebSocket("wss://localhost:8181/Semester3Project/chat");
            ws.onopen = function(evt) {
                $("#textarea").val(localStorage.log);
            };
            ws.onmessage = function(evt) {
                var currentdata = $("#textarea").val();
                $("#textarea").val(currentdata + "\n" + evt.data);
            };
            ws.onclose = function(evt) {
                localStorage.log = $("#textarea").val();
            };
            $(document).ready(function() {
                ws.open;
                $(window).unload(function() {
                    ws.close();
                });
                $("#btn").click(function() {
                    ws.send($("#texttosend").val());

                });
            });
        </script>
        <title>Bank Customer Chat</title>
    </head>
    <body>
        <h1>Welcome tho the bank chat</h1>
        <div>
            <!--<textarea id="onlineusers" cols="15" rows="10"></textarea>-->
            <textarea id="textarea" rows="10" cols="50"></textarea>
        </div>
        <div><label for="texttosend">Text</label><input id="texttosend" /> <button id="btn">Send</button></div>
    </body>
</html>