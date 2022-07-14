<%-- 
    Document   : feedback
    Created on : Jul 14, 2022, 3:21:11 PM
    Author     : hungp
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <form action="MainController" method="POST">
            <input type="text" placeholder="Enter content" name="txtContentFeedback" value="" required="">
            <input type="text" placeholder="Enter your username" name="txtUsername" value="" required="">
            <input type="submit" name="btn" value="Send Feedback" required="">
        </form>
    </body>
</html>
