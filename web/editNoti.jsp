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
        <c:forEach var="x" items="${list}">
            <c:if test="${x.getId() eq notificationId}">
                <form action="MainController" method="post">
                    <p>Notification Name:<input type="text" value="${x.name}"name="notificationName" ></p>
                    <p>Notification Detail:<input type="text" value="${x.detail}" name="notificationDetail"> 
                    <p>Username<input type="text" value="${x.username}" name="username"> </br>
                        <input type="hidden" value="${x.id}" name="notificationId">
                        <input type="submit" name="btn" value="Update Notification" onclick="updated()">
                        <input type="submit" name="btn" value="Remove Notification" onclick="deleted()">
                </form>
            </c:if> 
        </c:forEach>
        <script>
            function updated() {
                alert("Update Success!");
            }

            function deleted() {
                alert("Delete Success!");
            }

        </script>
    </body>
</html>
