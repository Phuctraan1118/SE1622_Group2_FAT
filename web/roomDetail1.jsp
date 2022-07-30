<%-- 
    Document   : roomDetail
    Created on : Jul 29, 2022, 6:32:02 PM
    Author     : Bitano
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Room Detail</title>
    </head>
    <body>
        <h1> Room ${param.roomId}</h1>
        <form action="MainController" method="get">
            <input type="hidden" name="txtRoomId" value="${param.roomId}" />
            <input type="submit" name="btn" value="View Room Detail" />
            <c:forEach var="dto" items="${requestScope.VIEW_ROOM_DETAIL}" >
                <h4>Category Name</h4>
                ${dto.categoryName} </br>
                <h4>Room Id</h4>
                ${dto.roomId} </br>
                <h4>Room Description</h4>
                ${dto.roomDescription}</br>
                <h4>Room Price</h4>
                ${dto.roomPrice}</br>
                <h4>Image</h4>
                <img style="width: 370.75px; height: 247.36px" src="images/${dto.image}" class="card-img-top" alt="..."> </br>
            </c:forEach>
            <c:forEach var="dto1" items="${requestScope.GET_IMAGE_DETAIL}" > 
                <img style="width: 370.75px; height: 247.36px" src="images/${dto1.imageTmp}" class="card-img-top" alt="..."> </br>
            </c:forEach>

            </br><!-- comment -->



            <div class="product-action mt-2">
                <div class="d-grid">
                    <input type="hidden" name="txtUsername" value="${User.id}" />
                    <input type="hidden" name="txtRoomId" value="${dto.roomId}" />
                    <input type="submit" class="btn btn-dark px-4 radius-10" name="btn" value="Booking Room"/>
                </div>
            </div>






        </form>
    </body>
</html>
