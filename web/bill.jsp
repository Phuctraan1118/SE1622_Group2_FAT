<%-- 
    Document   : bill
    Created on : Jul 15, 2022, 1:02:15 AM
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
        <c:if test = "${not empty requestScope.SERVICE}">
            <table border="1">
                <thead>
                    <tr>
                        <th>NO</th>
                        <th>Electronic Price</th>
                        <th>Water Price</th>
                        <th>Room Price </th>
                        <th>Total</th>
                        <th>Send Bill</th>
                    </tr>
                </thead>
                <tbody>
                    <c:forEach var="sv" items="${requestScope.SERVICE}" varStatus="counter">
                        <c:forEach var="dto" items="${requestScope.R_PRICE}">
                        <form action="MainController" method="POST">
                            <tr>
                                <td>${counter.count}</td>
                                <td>${sv.electronicPrice}</td>
                                <td>${sv.waterPrice}</td>
                                <td>${dto.roomPrice}</td>
                                <td>
                                    <c:set var="total" value="${sv.electronicPrice + sv.waterPrice + dto.roomPrice}" />
                                    ${total}
                                    <input type="hidden" value="${total}" name="txtTotal" />
                                </td>
                                <td>
                                    <input type="hidden" value="${sv.roomId}" name="txtRoomId" />
                                    <input type="hidden" value="${sv.id}" name="txtServiceId" />
                                    <input type="submit" name="btn" value="Send Bill">
                                </td>
                            </tr>
                        </form>
                    </c:forEach>
                </c:forEach>
            </tbody>
        </table>
    </c:if>
</body>
</html>
