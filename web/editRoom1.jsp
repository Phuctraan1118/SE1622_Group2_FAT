<%-- 
    Document   : editRoom
    Created on : Jul 30, 2022, 4:46:43 PM
    Author     : Bitano
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Edit room</title>
    </head>
    <body>
        <h1> Edit Room ${param.txtRoomId}</h1>
        <form action="MainController">
            <input type="hidden" name="txtRoomId" value="${param.txtRoomId}" />
            <input type="hidden" name="btn" value="Edit Room Detail" />
        </form>
        <form action="MainController"> 
            <c:forEach var="dto" items="${requestScope.EDIT_ROOM_DETAIL}" >
                <h4>Category Name</h4>
                ${dto.categoryName}
                </br>
                <h4>Room Id</h4>
                <input type="hidden" name="txtRoomId" value="${dto.roomId}" />
                ${dto.roomId} </br> 
                <h4>Room Name</h4>
                <input type="text" name="txtRoomName" value="${dto.roomName}" />

                <h4>Room Description</h4>
                ${dto.roomDescription} </br>
                <input type="text" name="txtRoomDescription" value="${dto.roomDescription}" />
                </br>
                <h4>Room Price</h4>
                <input type="text" name="txtRoomPrice" value="${dto.roomPrice}" />
                </br>
                <h4>Image</h4>
                <input type="hidden" name="txtImage" value="${dto.image}" />
                <img style="width: 370.75px; height: 247.36px" src="images/${dto.image}" class="card-img-top" alt="..."> </br>
            </c:forEach>
            <c:forEach var="dto1" items="${requestScope.EDIT_IMAGE_DETAIL}" > 
                <img style="width: 370.75px; height: 247.36px" src="images/${dto1.imageTmp}" class="card-img-top" alt="..."> </br>
            </c:forEach>

            <h4> <input type="submit" name="btn" value="Update Room"/> </h4>
            <a href="MainController?txtSearchValue=&btn=SEARCH+ROOM">Click here to back </a>
        </form>
    </body>
</html>
