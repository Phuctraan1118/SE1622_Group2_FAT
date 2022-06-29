<%-- 
    Document   : notifi
    Created on : Jun 28, 2022, 4:13:23 PM
    Author     : hungp
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Notification Page</title>
        <style>
            .success{
                color: green;
            }
        </style>
    </head>
    <body>
        <form action="MainController" method="POST"> 
            <input type="text" name="txtNotificationName" value="" placeholder="Enter Notification Name" class="box">
            <input type="text" name="txtNotificationDetail" value="" placeholder="Enter Notification Detail" class="box">
            <input type="text" name="txtUsername" value="" placeholder="Enter username" class="box">
            <input type="submit" name="btn" value="Add Notification" class="btn">
        </form>
        <c:set var="created" value="${requestScope.CREATED}"/>
        <c:if test="${not empty created}">
            <p class="success">Notification Name ${created} is created</p>
        </c:if>
        <form action="MainController" method="POST">
            Search <input type="text" name="search" value="${param.search}" />
            <input type="submit" value="Search Notification" name="btn" /> </br>
        </form>

            <c:if test = "${not empty sessionScope.LIST_NOTIFICATION}">
            <table border="1">
                <thead>
                    <tr>
                        <th>NO</th>
                        <th>Notification Name</th>
                        <th>Detail</th>
                        <th>Username</th>
                        <th>Edit</th>
                    </tr>
                </thead>
                <tbody>
                    <c:forEach var="noti" items="${sessionScope.LIST_NOTIFICATION}" varStatus="counter">
                    <form action="MainController" method="post">
                        <tr>
                            <td>${counter.count}</td>
                            <td>${noti.name}</td>
                            <td>${noti.detail}</td>
                            <td>${noti.username}</td>
                            <td><a href="editNoti.jsp?notificationId=${noti.getId()}">Edit</a></td>
                        </tr>
                    </form>
                </c:forEach>
            </tbody>
        </table>
    </c:if>
</body>
</html>
