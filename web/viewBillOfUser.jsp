<%-- 
    Document   : viewBillOfUser
    Created on : Jul 29, 2022, 12:59:42 AM
    Author     : Bitano
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
        <h1>VIEW BILL FOR USER</h1>
        <form action="MainController" method="GET">
            <c:set var="User" value="${sessionScope.USER}"/>
            <h6>Welcome ${USER.name} (USER)</h6>
            <input type="hidden" name="txtUsername" value="${USER.id}" />
            <input type="submit" name="btn" value="View Bill Of You" />


        </form>
        <c:if test = "${not empty sessionScope.BILL_USER}">
            <table border="1">
                <thead>
                    <tr>
                        <th>NO</th>
                        <th>Bill Name</th>
                        <th>Detail</th>
                        <th>Date</th>
                        <th>Room ID</th>
                        <th>Room Price</th>
                        <th>Electronic Detail</th>
                        <th>Electronic Price</th>
                        <th>Water Detail</th>
                        <th>Water Price</th>
                        <th>username</th>
                        <th>TOTAL</th>
                    </tr>
                </thead>
                <tbody>
                    <c:forEach var="bill" items="${sessionScope.BILL_USER}" varStatus="counter">
                    <form action="MainController" method="POST">
                        <tr>
                            <td>${counter.count}</td>
                            <td>${bill.billName}</td>
                            <td>${bill.detail}</td>
                            <td>${bill.date}</td>
                            <td>${bill.roomId1}</td>
                            <td>${bill.roomPrice}$</td>
                            <td>${bill.electronicDetail}</td>
                             <td>${bill.electronicPrice}$</td>
                            <td>${bill.waterDetail}</td>
                            <td>${bill.waterPrice}$</td>
                            <td>${bill.username}</td>
                            <td>  <c:set var="total" value="${bill.electronicPrice + bill.waterPrice + bill.roomPrice}" />
                                ${total}$
                            </td>
                            

                        </tr>
                    </form>
                </c:forEach>
            </tbody>
        </table>
    </c:if>
</body>
</html>
