<%-- 
    Document   : addRoom
    Created on : Jun 3, 2022, 11:10:15 AM
    Author     : Bitano
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Add Room</title>
    </head>
    <body>
        <h1>Create Room </h1>
        <form action="MainController" method="POST">
            <select name="txtIdCategory">
                <option>Loai phong</option>
                <option value="C001">phong thuong loai 1</option>
                <option value="C002">phong thuong loai 2</option>
                <option value="C003">phong thuong loai 3</option>
                <option value="C004">phong vip loai 1</option>
                <option value="C005">phong vip loai 2</option>
            </select>
            <input type="text" name="txtNameOfRoom" value="" placeholder="NAME OF ROOM"/>
            <input type="text" name="txtDetailOfRoom" value="" placeholder="DETAIL OF ROOM" />
            <input type="text" name="txtQuantity" value="" placeholder="QUANTITY OF ROOM" /> 
            <input type="submit" value="Add Room" name="btn" />
        </form> </br>
    </body>
</html>
