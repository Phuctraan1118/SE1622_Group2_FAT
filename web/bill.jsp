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
                        <th>Electronic Detail</th>
                        <th>Water Detail</th>
                        <th>Total</th>
                    </tr>
                </thead>
                <tbody>
                    <c:forEach var="sv" items="${requestScope.SERVICE}" varStatus="counter">
                    <form action="MainController" method="POST">
                        <tr>
                            <td>${counter.count}</td>
                            <td>${sv.electronicDetail}</td>
                            <td>${sv.waterDetail}</td>
                            <td>30000000</td>
                        </tr>
                    </form>
                </c:forEach>
            </tbody>
        </table>
    </c:if>
</body>
</html>
