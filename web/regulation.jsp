<%-- 
    Document   : regulation
    Created on : Jul 11, 2022, 12:14:15 AM
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
        <form action="MainController" method="POST">
            Search <input type="text" name="search" value="${param.search}" />
            <input type="submit" value="Search Regulation" name="btn" /> </br>
        </form>

        <c:if test = "${not empty sessionScope.LIST_REGULATION}">
            <table border="1">
                <thead>
                    <tr>
                        <th>NO</th>
                        <th>Regulation Name</th>
                        <th>Regulation Detail</th>
                    </tr>
                </thead>
                <tbody>
                    <c:forEach var="regulation" items="${sessionScope.LIST_REGULATION}" varStatus="counter">
                    <form action="MainController" method="post">
                        <tr>
                            <td>${counter.count}</td>
                            <td>${regulation.regulationName}</td>
                            <td>${regulation.regulationDetail}</td>
                        </tr>
                    </form>
                </c:forEach>
            </tbody>
        </table>
    </c:if>
</body>
</html>
