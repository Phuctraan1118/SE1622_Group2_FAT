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
        <form action="MainController">
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
                        <th>UPDATE</th>
                        <th>DELETE</th>
                    </tr>
                </thead>
                <tbody>
                    <c:forEach var="dto" items="${requestScope.SEARCHRESULT}" varStatus="counter">
                    <form action="MainController">
                        <c:set var="errors1" value="${requestScope.CREATEERRORS1}"/>
                        <tr>
                            <td>
                                ${counter.count}
                            </td>
                            <td>
                                ${dto.roomId}

                            </td>
                            <td>
                                <input type="text" name="txtRoomDescription" placeholder="Description" required="" value="${dto.roomDescription}"/> </br>
                                <c:if test="${not empty errors1.roomDescriptionLengthError}">
                                    <font color="red">
                                    ${errors1.roomDescriptionLengthError}
                                </c:if></td>

                            </td>
                            <td>


                            <td>
                                <input type="text" name="txtRoomPrice" placeholder="Price"required="" value="${dto.roomPrice}"/> </br>
                                <c:if test="${not empty errors1.priceStringError}">
                                    <font color="red">
                                    ${errors1.priceStringError}
                                </c:if>
                            </td>
                            <td>
                                <c:set var="checkImage" value="${dto.image}"/>
                                <c:if test="${ empty checkImage}">
                                    <input type="file" name="txtImage" value="${param.txtImage}"  />

                                </c:if>
                                <c:if test="${ not empty checkImage}">
                                    <img src=images/${dto.image}  width="90"/>
                                    <input type="hidden" name="txtImage" value="${param.txtImage}"/>
                                </c:if>

                            </td>
                            <td>
                                <input type="submit" name="btn" value="Update Room" />
                                <input type="hidden" name="txtSearchValue" value="${param.txtSearchValue}"/>
                                <input type="hidden" name="txtRoomId" value="${dto.roomId}"/>
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


    <form action="MainController" >

        <table border="1">
            <tbody>
                <c:set var="errors" value="${requestScope.CREATEERRORS}"/>
            <th>Room Description</th>
            <td><input type="text" name="txtCreateRoomDescription" value="${param.txtCreateRoomDescription}" required="" placeholder="text ..."/> </br>
                <c:if test="${not empty errors.roomDescriptionLengthError}">
                    <font color="red">
                    ${errors.roomDescriptionLengthError}
                </c:if>
            </td> 
            <th>Price</th>
            <td><input type="text" name="txtCreateRoomPrice" value="${param.txtCreateRoomPrice}" required="" placeholder="number ..." /></br>
                <c:if test="${not empty errors.priceStringError}">
                    <font color="red">
                    ${errors.priceStringError}
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
    <h6>MANAGEMENT OWNED ROOM</h6>
    <form action="MainController">
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
                    <th>UPDATE</th>
                    <th>DELETE</th>

                </tr>
            </thead>
            <tbody>
                <c:forEach var="dtoBooked" items="${requestScope.SEARCH_BOOKED}" varStatus="counter">
                <form action="MainController">

                    <tr>
                        <td>
                            ${counter.count}
                        </td>
                        <td>
                            ${dtoBooked.roomId}
                            <input type="hidden" name="txtRoomId1" value="${dtoBooked.roomId}"/>
                        </td>
                        <td>
                            <input type="text" name="txtRoomDescription1" required="" value="${dtoBooked.roomDescription}"/>
                        </td>
                        <td>
                            <input type="text" name="txtRoomPrice1" required=""  value=" ${dtoBooked.roomPrice}"/>
                        </td>
                        <td>
                            <input type="text" name="txtBookingDate"  placeholder="dd/mm/yyyy"  value=" ${dtoBooked.bookingDate}"/>
                        </td>
                        <td>
                            <input type="text" name="txtCheckInDate" placeholder="dd/mm/yyyy" value=" ${dtoBooked.checkinDate}"/>
                        </td>
                        <td>
                            <input type="text" name="txtCheckOutDate" required="" placeholder="dd/mm/yyyy" value=" ${dtoBooked.checkoutDate}"/>
                        </td>

                        <td>
                            ${dtoBooked.username}
                            <input type="hidden" name="txtUsername" value="${dtoBooked.username}" />
                        </td>
                        <td>
                            <c:if test="${dtoBooked.status == 'B'}">Booked</c:if>
                            <input type="hidden" name="txtStatus1" value="${dtoBooked.status}" />

                        </td>
                        <td>
                            <img src=images/${dtoBooked.image}  width="90"/>
                            <input type="hidden" name="txtImage1" value="${dtoBooked.image}" />
                        </td>
                        <td>
                            <input type="submit" name="btn" value="Update Booked Room" />
                            <input type="hidden" name="txtSearchValueBooked" value="${param.txtSearchValueBooked}"/>
                            <input type="hidden" name="txtBookingId" value="${dtoBooked.bookingId}"/>
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





</form> 


</body>
</html>
