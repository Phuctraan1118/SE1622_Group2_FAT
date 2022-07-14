<%-- 
    Document   : sendNotification
    Created on : Jul 15, 2022, 4:36:08 AM
    Author     : hungp
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <c:set var="username" value="${param.username}"></c:set> 
            <form action="MainController" class="ms-auto position-relative">
                <input type="submit" name="btn" value="Display Regulation In SendNotiPage">
                <input type="hidden" name="txtUsername" value="${username}">
        </form>
        <form action="MainController" method="POST"> 
            <c:if test = "${not empty requestScope.LIST_REGULATION_FOR_SEND_NOTI}">
                <table>
                    <thead>
                        <tr>
                            <th>NO</th>
                            <th>Regulation Name</th>
                            <th>Regulation Detail</th>
                        </tr>
                    </thead>
                    <tbody>
                        <c:forEach var="regulation" items="${requestScope.LIST_REGULATION_FOR_SEND_NOTI}" varStatus="counter">
                            <tr>
                                <td>${counter.count}</td>
                                <td>${regulation.regulationName}</td>
                                <td>${regulation.regulationDetail}</td>
                            </tr>
                        </c:forEach>
                    </tbody>
                </table>
            </c:if>
            <input type="text" name="txtNotificationName" value="" placeholder="Enter Notification Name" class="box">
            <input type="text" name="txtNotificationDetail" value="" placeholder="Enter Notification Detail" class="box">
            <input type="text" name="txtUsername" value="${requestScope.username}" placeholder="Enter username" class="box">
            <input type="submit" name="btn" value="Add Notification" class="btn">
        </form>
    </body>
</html>
