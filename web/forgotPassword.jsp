<%-- 
    Document   : forgotPassword
    Created on : Jun 3, 2022, 2:25:35 AM
    Author     : buikh
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <form action="MainController" method="POST">
            <b>Forgot Password</b></br>
            UserName :<input type="text" name="userName" value="" required="" /></br>
            Email :<input type="text" name="email" value="" required="" /></br>
            <input type="submit" name="btn" value="Retrieve">
            <a href="login.jsp">Sign in</a>
        </form>
        <%
            String error = (String) session.getAttribute("ERROR");
            if (error == null) {
                error = "";
            }
        %>
        <%= error%>
    </body>
</html>
