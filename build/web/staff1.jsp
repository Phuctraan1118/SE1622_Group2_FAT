<%-- 
    Document   : staff1
    Created on : Jun 7, 2022, 5:25:22 PM
    Author     : Bitano
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>STAFF MANAGEMENT ROOM</title>
    </head>
    <body>
        <h3>MANAGEMENT ROOM</h3>
        <h6>VIEW LIST OF ROOM</h6>
        <form action="MainController" method="POST">
            <input type="text" name="txtSearchValue" 
                   value="${param.txtSearchValue}" placeholder="search description"/>
            <input type="submit" value="SEARCH ROOM" name="btn" />
        </form><br/>
        <c:if test = "${not empty requestScope.SEARCHRESULT}">
            <table>
                <thead>
                    <tr>
                        <th>No</th>
                        <th>ID ROOM</th>
                        <th>DESCRIPTION</th>
                        <th>PRICE</th>
                        <th>IMAGE</th>
                        <th>EDIT</th>
                        <th>DELETE</th>
                    </tr>
                </thead>
                <tbody>
                    <c:forEach var="dto" items="${requestScope.SEARCHRESULT}" varStatus="counter">
                    <form action="MainController" method="POST">
                        <c:set var="errors1" value="${requestScope.CREATEERRORS1}"/>

                        <tr>
                            <td>
                                ${counter.count}
                            </td>
                            <td>
                                ${dto.roomId}
                            </td>
                            <td>
                                ${dto.roomDescription}
                            </td>
                            <td>
                                ${dto.roomPrice}
                            </td>
                            <td>
                                <img src=images/${dto.image}  width="90"/>
                            </td>   
                            <td>
                                <a href="editRoom.jsp?txtRoomId=${dto.roomId}&txtRoomDescription=${dto.roomDescription}
                                    &txtRoomPrice=${dto.roomPrice}&txtImage=${dto.image}">Edit</a>
                                <input type="hidden" name="txtSearchValue" value="${param.txtSearchValue}"/>

                            </td> 
                            <td>
                                <input type="submit" name="btn" value="Delete Room" />
                                <input type="hidden" name="txtSearchValue" value="${param.txtSearchValue}"/>
                                <input type="hidden" name="txtRoomId" value="${dto.roomId}"/>
                            </td>
                        </tr>
                    </form>
                </c:forEach>

            </tbody>
        </table>
    </c:if>


    <form action="MainController" method="POST">

        <table border="1">
            <tbody>
                <c:set var="errors" value="${requestScope.CREATEERRORS}"/>
            <th>Room Description</th>
            <td><input type="text" name="txtCreateRoomDescription" value="${param.txtCreateRoomDescription}" required="" placeholder="text ..."/> </br>
                <c:if test="${not empty errors.roomDescriptionLengthError}">
                    <font color="red">
                    ${errors.roomDescriptionLengthError}
                    </font><br/>
                </c:if>
            </td> 
            <th>Price</th>
            <td><input type="text" name="txtCreateRoomPrice" value="${param.txtCreateRoomPrice}" required="" placeholder="number ..." /></br>
                <c:if test="${not empty errors.priceStringError}">
                    <font color="red">
                    ${errors.priceStringError}
                    </font><br/>
                </c:if>
            </td> 


            <th>Image</th>
            <td><input type="file" name="txtCreateImage" value="${param.txtCreateImage}"  /></td> 
            <th>
                <input type="submit" name="btn" value="ADD ROOM"  />

            </th>
        </table>

    </form>



    </br>
    <!--  MANAGEMENT OWNED ROOM -->

    <h6>MANAGEMENT OWNED ROOM</h6>
    <form action="MainController" method="POST">
        <input type="text" name="txtSearchValueBooked" 
               value="${param.txtSearchValueBooked}" placeholder="search username"/>
        <input type="submit" value="SEARCH OWNED ROOM" name="btn"  />
    </form><br/>
    <c:if test = "${not empty requestScope.SEARCH_BOOKED}">
        <table class="table align-middle mb-0">
            <thead class="table-light">
                <tr>
                    <th>No</th>
                    <th>ID ROOM</th>
                    <th>DESCRIPTION</th>
                    <th>PRICE</th>
                    <th>BOOKING DATE</th>
                    <th>CHECK IN DATE</th>
                    <th>CHECK OUT DATE</th>
                    <th>USERNAME</th>
                    <th>STATUS</th>
                    <th>IMAGE</th>
                    <th>EDIT</th>
                    <th>DELETE</th>

                </tr>
            </thead>
            <tbody>
                <c:forEach var="dtoBooked" items="${requestScope.SEARCH_BOOKED}" varStatus="counter">
                <form action="MainController" method="POST">

                    <tr>
                        <td>
                            ${counter.count}
                        </td>
                        <td>
                            ${dtoBooked.roomId}
                            <input type="hidden" name="txtRoomId1" required="" value="${dtoBooked.roomId}"/>
                            <input type="hidden" name="txtBookingId" value="${dtoBooked.bookingId}" />
                        </td>
                        <td>
                            ${dtoBooked.roomDescription}

                        </td>
                        <td>
                            ${dtoBooked.roomPrice}

                        </td>
                        <td>
                            ${dtoBooked.bookingDate}

                        </td>
                        <td>
                            ${dtoBooked.checkinDate}

                        </td>
                        <td>
                            ${dtoBooked.checkoutDate}

                        </td>

                        <td>
                            ${dtoBooked.username}

                        </td>
                        <td>
                            <c:if test="${dtoBooked.status == 'B'}">Booked</c:if>
                            <input type="hidden" name="txtStatus1" value="${dtoBooked.status}" />

                        </td>
                        <td>
                            <img src=images/${dtoBooked.image}  width="90"/>
                        </td>
                        <td>

                            <a  href="editOwnedRoom.jsp?txtRoomId1=${dtoBooked.roomId}&txtRoomDescription1=${dtoBooked.roomDescription}
                                &txtRoomPrice1=${dtoBooked.roomPrice}&txtBookingDate=${dtoBooked.bookingDate}
                                &txtCheckInDate=${dtoBooked.checkinDate}
                                &txtCheckOutDate=${dtoBooked.checkoutDate}
                                &txtUsername=${dtoBooked.username}&txtStatus1=${dtoBooked.status}
                                &txtImage1=${dtoBooked.image}&txtBookingId=${dtoBooked.bookingId}"
                                >Edit</a>

                        </td> 
                        <td>
                            <input type="submit" name="btn" value="Delete Booked Room" />
                            <input type="hidden" name="txtSearchValueBooked" value="${param.txtSearchValueBooked}"/>
                            <input type="hidden" name="txtBookingId" value="${dtoBooked.bookingId}"/>
                        </td>
                    </tr>
                </form>
            </c:forEach>

        </tbody>
    </table>
</c:if>
    <!-- ViewBooking -->
    <a href="MainController?btn=ViewBooking">View Booking</a>
        <c:set var="orders" value="${requestScope.BOOKINGS}"/>
        <c:if test="${not empty orders}">
            <table border="1">
                <thead>
                    <tr>
                        <th>No.</th>
                        <th>Booking ID</th>
                        <th>Username</th>
                        <th>Room ID</th>
                        <th>Booking Date</th>
                        <th>Check In Date</th>
                        <th>Check Out Date</th>
                        
                    </tr>
                </thead>
                <tbody>
                    <c:forEach var="order" items="${orders}" varStatus="counter">
                        <tr>
                            <td>
                                ${counter.count}
                            </td>
                            <td>
                                ${order.bookingID}
                            </td>
                            <td>
                                ${order.username}
                            </td>
                            <td>
                                ${order.roomID}
                            </td>
                            <td>
                                ${order.bookingDate}

                            </td>
                            <td>
                                ${order.checkInDate}
                            </td>
                            <td>
                                ${order.checkOutDate}
                            </td>
                        </tr>
                </c:forEach>
            </tbody>
        </table>
    </c:if>




</body>
</html>
