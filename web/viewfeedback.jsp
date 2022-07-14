<%-- 
    Document   : viewfeedback
    Created on : Jul 15, 2022, 1:29:34 AM
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
        <c:if test = "${not empty sessionScope.FEEDBACK}">
            <table border="1">
                <thead>
                    <tr>
                        <th>NO</th>
                        <th>Feedback Name</th>
                        <th>Username</th>
                        <th>Reply</th>
                    </tr>
                </thead>
                <tbody>
                    <c:forEach var="fb" items="${sessionScope.FEEDBACK}" varStatus="counter">
                    <form action="MainController" method="POST">
                        <tr>
                            <td>${counter.count}</td>
                            <td>${fb.feedbackContent}</td>
                            <td>${fb.username}</td>
                            <td><a href="replyFeedback.jsp?feedbackId=${fb.feedbackId}">Reply</a></td>
                        </tr>
                    </form>
                </c:forEach>
            </tbody>
        </table>
    </c:if>
    </body>
</html>
