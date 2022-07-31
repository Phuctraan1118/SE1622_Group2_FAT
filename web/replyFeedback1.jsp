<%-- 
    Document   : replyFeedback.jsp
    Created on : Jul 15, 2022, 2:00:36 AM
    Author     : hungp
--%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Reply Feedback</title>
    </head>
    <body>
        <c:set var="feedbackId" value="${param.feedbackId}"></c:set>
        <c:set var="list" value="${sessionScope.FEEDBACK}"></c:set>
        <c:forEach var="x" items="${list}">
            <c:if test="${x.feedbackId eq feedbackId}">
                <p>Username ${x.username}</p>
                <p>Content feedback ${x.feedbackContent}</p>
                <form action="MainController" method="post">
                    <input type="text" placeholder="Enter content reply" name="txtReplyFeedback" value="" required="">
                    <input type="submit" name="btn" value="Send Feedback Reply" required="">
                    <input type="hidden" name="txtUsername" value=${x.username}>
                    <input type="hidden" name="txtFeedbackId" value=${x.feedbackId}>
                </form>
            </c:if> 
        </c:forEach>
        <c:set var="succcess" value="${requestScope.REPLY_SUCCESS}"/>
        <c:if test="${not empty succcess}">
            <p class="success">Already send reply feedback to username ${succcess}</p>
        </c:if>
    </body>
</html>
