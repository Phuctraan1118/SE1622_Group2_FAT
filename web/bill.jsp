<%-- 
    Document   : bill
    Created on : Jul 15, 2022, 1:02:15 AM
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
            <input type="text" name="txtBillName" value="" placeholder="Enter Bill Name" class="box">
            <input type="text" name="txtNotificationDetail" value="" placeholder="Enter Notification Detail" class="box">
            <input type="text" name="txtUsername" value="" placeholder="Enter username" class="box">
            <input type="submit" name="btn" value="Add Bill" class="btn">
        </form>
    </body>
</html>
