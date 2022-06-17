<%-- 
    Document   : admin
    Created on : May 30, 2022, 10:32:52 PM                    

    Author     : buikh
--%>

<%@page import="form.UserError"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page import="java.util.List"%>
<%@page import="form.UserDisplayForm"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Ad Page</title>
        <style>
            .col-sm-8 p{
                overflow: hidden;
                display: -webkit-box;
                -webkit-line-clamp: 3;
                -webkit-box-orient: vertical;
            }
        </style>
        <style>
            .error{
                color: red;
            }
        </style>
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.1/css/bootstrap.min.css">
        <jsp:useBean id="a" class="dao.UserDao" scope="request"></jsp:useBean>
        </head>
        <body>
            <form action="MainController" method="POST"> 
                <input type="text" name="txtUsername" value="" placeholder="Enter user name" class="box">
            ${requestScope.USER_ERROR.usernameError}
            <input type="password" name="txtPassword" value="" placeholder="Enter staff password" class="box">
            ${requestScope.USER_ERROR.passwordError}
            <input type="text" name="txtFullName" value="" placeholder="Enter full name" class="box">
            ${requestScope.USER_ERROR.fullNameError}
            <input type="text" name="txtEmail" value="" placeholder="Enter staff email" class="box">
            ${requestScope.USER_ERROR.emailError}
            <input type="text" name="txtAddress" value="" placeholder="Enter staff address" class="box">
            ${requestScope.USER_ERROR.addressError}
            <input type="text" name="txtPhone" value="" placeholder="Enter staff phone" class="box">
            ${requestScope.USER_ERROR.phoneNumError}
            <input type="text" name="txtCitizenIdentification" value="" placeholder="Enter citizen identification" class="box">
            ${requestScope.USER_ERROR.citizenIndentification}
            <input type="file" name="txtImg"> 
            <input type="submit" name="btn" value="Add Staff" class="btn">
            ${requestScope.USER_ERROR.messageError}
        </form>

        <form action="MainController" method="POST">
            Search <input type="text" name="search" value="${param.search}" required="" />
            <input type="submit" value="Search Staff" name="btn" /> </br>
        </form>
        <form action="MainController" method="POST">
            <input type="submit" value="View All" name="btn" /> </br>
        </form>
        <c:set var="dupplicate" value="${requestScope.USER_DUPPLICATE}"/>
        <c:if test="${not empty dupplicate}">
            <p class="error">User `${dupplicate}` is existed</p>
        </c:if>

        <c:set var="userError" value="${requestScope.USER_ERROR}"/>
        <c:if test="${not empty userError}">
            <p class="error">User `${dupplicate}` is existed</p>
        </c:if>
        <c:if test = "${not empty requestScope.LIST_USER}">
            <table border="1">
                <thead>
                    <tr>
                        <th>NO</th>
                        <th>Username</th>
                        <th>Full Name</th>
                        <th>Address</th>
                        <th>Phone</th>
                        <th>CMND/CCCD</th>
                        <th>Email</th>
                        <th>Image</th>
                        <th>Update</th>
                        <th>Delete</th>
                    </tr>
                </thead>
                <tbody>
                    <c:forEach var="user" items="${requestScope.LIST_USER}" varStatus="counter">
                    <form action="MainController" method="post">
                        <tr>
                            <td>${counter.count}</td>
                            <td><input type="text" name="txtUsername" required="" value="${user.username}"></td>
                            <td><input type="text" name="txtFullName" required="" value="${user.fullName}"></td>
                            <td><input type="text" name="txtAddress" required="" value="${user.address}"></td>
                            <td><input type="text" name="txtPhone" required="" value="${user.phone}"></td>
                            <td><input type="text" name="txtCmnd" required="" value="${user.citizenIdentification}"></td>
                            <td><input type="text" name="txtEmail" required="" value="${user.email}"></td>
                            <td> <img src="images/${user.getImage()}" style="width: 25%"></td>
                            <td>
                                <input type="submit" name="btn" value="Update Staff" />
                                <input type="hidden" name="search" value="${param.search}"/>
                                <input type="hidden" name="username" value="${user.username}"/>
                            </td> 
                            <td>
                                <input type="submit" name="btn" value="Delete Staff" />
                                <input type="hidden" name="search" value="${param.search}"/>
                                <input type="hidden" name="userId" value="${user.id}"/>
                            </td>
                        </tr>
                    </form>
                </c:forEach>
            </tbody>
        </table>
    </c:if>
    <div>
        <table border="1">
            <thead>
                <tr>
                    <th>NO</th>
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
                <c:forEach var="user" items="${LIST}" varStatus="counter">
                    <tr>
                        <td>${counter.count}</td>
                        <td><input type="text" name="txtUsername" required="" value="${user.username}"></td>
                        <td><input type="text" name="txtFullName" required="" value="${user.fullName}"></td>
                        <td><input type="text" name="txtAddress" required="" value="${user.address}"></td>
                        <td><input type="text" name="txtPhone" required="" value="${user.phone}"></td>
                        <td><input type="text" name="txtCmnd" required="" value="${user.citizenIdentification}"></td>
                        <td><input type="text" name="txtEmail" required="" value="${user.email}"></td>
                        <td> <img src="images/${user.getImage()}" style="width: 25%"></td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>
        
        <nav style="margin: 20px auto; width: 500px" aria-label="...">
            <ul class="pagination pagination-lg">
                <c:forEach begin="1" end="${a.numberOfPage}" var="i">
                    <li class="page-item"><a class="page-link" href="paging?index=${i}">${i}</a></li>
                    </c:forEach>
            </ul>
        </nav> 
    </div>


    <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.1/js/bootstrap.min.js"></script>
</body>
</html>
