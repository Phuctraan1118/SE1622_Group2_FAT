<%-- 
    Document   : service
    Created on : Jul 15, 2022, 12:59:04 PM
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
            <input type="text" name="txtElectronicDetail" value="" placeholder="Enter Electronic Detail" class="box">
            <input type="text" name="txtWaterDetail" value="" placeholder="Enter Water Detail" class="box">
            <input type="text" name="txtElectronicPrice" value="" placeholder="Enter Electronice Price" class="box">
            <input type="text" name="txtWaterPrice" value="" placeholder="Enter Water Price" class="box">
            ${param.roomId}
            <input type="hidden" name="txtRoomId" value="${param.roomId}"class="box">
            <input type="text" name="txtUsername" value="${param.username}"class="box">
            <input type="submit" name="btn" value="Add Service" class="btn">
        </form>
    </body>
</html>
