<%-- 
    Document   : review
    Created on : Jul 13, 2022, 12:20:20 AM
    Author     : buikh
--%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <table border="1"> 
            <tbody>
                <tr>
                    <td colspan="2">Transaction Details:</td>
                    <td></td>
                </tr>
                <tr>
                    <td>Description</td>
                    <td>${transaction.description}</td>
                </tr>
                <tr>
                    <td>Sub Total</td>
                    <td>${transaction.amount.details.subtotal}</td>
                </tr>
                
                
                
                <tr>
                    <td colspan="2">Payer Information:</td>
                    <td></td>
                </tr>
                
                <tr>
                    <td>Sub Total</td>
                    <td>${sessionScope.USER.name}</td>
                </tr>
                
                <tr>
                    <td>First Name</td>
                    <td>${PAYER.firstName}  ${PAYER.lastName}</td>
                </tr>
                
                <tr>
                    <td>Payer Email</td>
                    <td>${PAYER.email}</td>
                </tr>
            </tbody>
        </table>

    </body>
</html>
