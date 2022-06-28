<%-- 
    Document   : editOwnedRoom
    Created on : Jun 18, 2022, 12:50:07 AM
    Author     : Bitano
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Edit Owned Room</title>
    </head>
    <body>
        <h1>Edit Owned Room</h1>
        <form action="MainController" method="post">
             <c:set var="fail" value="${requestScope.ERROR2}"/>
            <h4>ID ROOM :${param.txtRoomId1} 
                <input type="hidden" value="${param.txtRoomId1}" name="txtRoomId1" /> 
                <input type="hidden" value="${param.txtBookingId}" name="txtBookingId" /> 
            </h4> 
            <h4>ROOM DESCRIPTION  : 
                <input type="text" name="txtRoomDescription1" placeholder="Description" required="" value="${param.txtRoomDescription1}"/>
                 <c:if test="${not empty fail.roomDescriptionLengthError}">
                    <font color="red"> 
                    ${fail.roomDescriptionLengthError}
                    </font> <br/>
                </c:if>
            </h4>
            <h4>PRICE : 
                <input type="text" name="txtRoomPrice1" placeholder="Price"required="" value="${param.txtRoomPrice1}"/>
                  <c:if test="${not empty fail.priceStringError}">
                    <font color="red">
                    ${fail.priceStringError}
                    </font> <br/>
                </c:if>
            </h4>
<h4>BOOKING DATE  : 
                <input type="text" name="txtBookingDate" placeholder="booking date" required="" value="${param.txtBookingDate}"/>
                  <c:if test="${not empty fail.bookingDateLengthError}">
                    <font color="red">
                    ${fail.bookingDateLengthError}
                    </font> <br/>
                </c:if>
            </h4>
            <h4>CHECK IN DATE  : 
                <input type="text" name="txtCheckInDate" placeholder="check in date" required="" value="${param.txtCheckInDate}"/>
                 <c:if test="${not empty fail.checkinDateLengthError}">
                    <font color="red">
                    ${fail.checkinDateLengthError}
                    </font> <br/>
                </c:if>
            </h4>
            <h4>CHECK OUT DATE : 
                <input type="text" name="txtCheckOutDate" placeholder="check out date" required="" value="${param.txtCheckOutDate}"/>
                 <c:if test="${not empty fail.checkoutDateLengthError}">
                    <font color="red">
                    ${fail.checkoutDateLengthError}
                    </font> <br/>
                </c:if>
            </h4>
            <h4>USERNAME : ${param.txtUsername}
                <input type="hidden" name="txtUsername" placeholder="username" required="" value="${param.txtUsername}"/>
            </h4>
            <h4>STATUS :
                <c:if test="${param.txtStatus1 == 'B'}">BOOKED</c:if>
                <input type="hidden" name="txtStatus1" placeholder="Description" required="" value="${param.txtStatus1}"/>
            </h4>
            <h4>IMAGE : <img src=images/${param.txtImage1}  width="90" />
                <input type="file" name="txtImage1" value="${param.txtImage1}"/>
            </h4>
<h4> <input type="submit" name="btn" value="Update Owned Room"/> </h4>
        </form>
    </body>
</html>