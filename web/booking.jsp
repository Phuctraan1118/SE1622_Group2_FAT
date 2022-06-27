<%-- 
    Document   : booking
    Created on : Jun 20, 2022, 12:45:37 AM
    Author     : buikh
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <c:set var="Success" value="${requestScope.SUCCESS}"/>
        <c:if test="${empty Success}">
            <form action="MainController" method="POST">
                RoomID ${param.txtRoomId} <br/>
                <input type="hidden" name="txtRoomId" value="${param.txtRoomId}" />
                <input type="hidden" name="txtUsername" value="${param.txtUsername}" />
                Check In Date<input type="date" name="txtCheckInDate" value="" /> <br/>
                ChecK Out Date<input type="date" name="txtCheckOutDate" value="" /> <br/>
                <input type="submit" value="Confirm" name="btn" />
            </form>
        </c:if>


        <c:if test="${not empty Success}">
            <H1 style="color: greenyellow">${Success}</H1>
            <a href="user-google.jsp">click here to order new room</a>
            </c:if>
            <c:set var="Error" value="${requestScope.ERROR}"/>
            <c:if test="${not empty Error}">
            <H1 style="color: red">${Error}</H1>
            </c:if>
    </body>
</html>
