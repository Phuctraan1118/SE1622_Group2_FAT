<%-- 
    Document   : error
    Created on : Jul 12, 2022, 11:10:48 PM
    Author     : buikh
--%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Payment Error Page</title>
    </head>
    <body>
        <H1>${requestScope.errorMessage}</H1>
    </body>
</html>
