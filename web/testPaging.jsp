<%-- 
    Document   : testPaging
    Created on : Jul 7, 2022, 1:18:02 AM
    Author     : hungp
--%>

<%@page import="form.UserError"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page import="java.util.List"%>
<%@page import="form.UserDisplayForm"%>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <table border="1">
            <thead>
                <tr>
                    <th>Username</th>
                    <th>Full Name</th>
                    <th>Address</th>
                    <th>Phone</th>
                    <th>CMND/CCCD</th>
                    <th>Email</th>
                    <th>Image</th>
                </tr>
            </thead>
            <tbody>
                <c:forEach items="${LIST_USER}" var="user">
                    <tr>
                        <td>${user.username}</td>
                        <td>${user.fullName}</td>
                        <td>${user.address}</td>
                        <td>${user.phone}</td>
                        <td>${user.citizenIdentification}</td>
                        <td>${user.email}</td>
                        <td><img src="images/${user.getImage()}" style="width: 25%"></td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>
        <c:forEach begin="1" end="${endP}" var="i">
            <a href="SearchStaffController?index=${i}">${i}</a>
        </c:forEach>
       
    </body>
</html>
