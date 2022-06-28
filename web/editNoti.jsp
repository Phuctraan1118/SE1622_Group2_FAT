<%-- 
    Document   : editNoti
    Created on : Jun 28, 2022, 7:07:38 PM
    Author     : hungp
--%>
<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%@page import="dto.NotificationDto"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Edit Notification Page</title>
    </head>
    <body>
    <c:set var="list" value="${sessionScope.LIST_NOTIFICATION}"></c:set>
    <c:set var="notificationId" value="${param.notificationId}"></c:set>
    <c:forEach var="x" items="${LIST_NOTIFICATION}">
        <c:if test="${x.getId() eq notificationId}">
            <form action="MainController" method="post">

                <p>Notification Name:<input type="text" value="${x.name()}"name="notificationName" required></p>
                <p>Notification Detail:<input type="text" value="${x.detail()}" name="notificationDetail"required> 
                <p>Quantity:<input type="text" value="${x.username()}" name="quantity" min="0" max="20" required> 
                <input type="submit" name="action" value="Update Product" onclick="updated()">
                <input type="submit" name="action" value="Remove Product" onclick="deleted()">

            </form>
        </c:if> 
    </c:forEach>
</body>
</html>
