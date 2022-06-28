<%-- 
    Document   : editRoom
    Created on : Jun 29, 2022, 12:49:22 AM
    Author     : su
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Edit Page</title>
    </head>
    <body>
        <h1>Edit Room</h1>
             <form action="MainController" method="post">
            <c:set var="errors1" value="${requestScope.CREATEERRORS1}"/>
            <h4>ID ROOM : ${param.txtRoomId} 
                <input type="hidden" value="${param.txtRoomId}" name="txtRoomId" /> </h4> 
            <h4>ROOM DESCRIPTION: 
                <input type="text" name="txtRoomDescription" placeholder="Description" required="" value="${param.txtRoomDescription}"/>
                <c:if test="${not empty errors1.roomDescriptionLengthError}">
                    <font color="red"> 
                    ${errors1.roomDescriptionLengthError}
                    </font> <br/>
                </c:if>
            </h4>
            <h4>PRICE: 
                <input type="text" name="txtRoomPrice" placeholder="Price"required="" value="${param.txtRoomPrice}"/>
                <c:if test="${not empty errors1.priceStringError}">
                    <font color="red">
                    ${errors1.priceStringError}
                    </font> <br/>
                </c:if>
                </br>
            </h4>
            <h4>IMAGE: <img src=images/${param.txtImage}  width="90"/>
                <input type="file" name="txtImage" value="${param.txtImage}"/>
            </h4>
            <h4> <input type="submit" name="btn" value="Update Room"/> </h4>
        </form>
    </body>
</html>
