<%-- 
    Document   : authentication-reset-password-simple
    Created on : Jun 3, 2022, 4:04:14 PM
    Author     : buikh
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!doctype html>
<html lang="en" class="light-theme">

    <head>
        <!-- Required meta tags -->
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">

        <!-- loader-->
        <link href="assets/css/pace.min.css" rel="stylesheet" />
        <script src="assets/js/pace.min.js"></script>

        <!--plugins-->
        <link href="assets/plugins/perfect-scrollbar/css/perfect-scrollbar.css" rel="stylesheet" />

        <!-- CSS Files -->
        <link href="assets/css/bootstrap.min.css" rel="stylesheet">
        <link href="assets/css/bootstrap-extended.css" rel="stylesheet">
        <link href="assets/css/style.css" rel="stylesheet">
        <link href="assets/css/icons.css" rel="stylesheet">
        <link href="https://fonts.googleapis.com/css2?family=Roboto:wght@400;500&display=swap" rel="stylesheet">

        <title>Reset Password</title>
    </head>

    <body>

        <!--start wrapper-->
        <div class="wrapper">
            <header>
                <nav class="navbar navbar-expand-lg navbar-light bg-transparent p-3">
                    <div class="container-fluid">
                        <a href="javascript:;"><img src="images/good1.png" width="140" alt="" /></a>
                        <button class="navbar-toggler" type="button" data-bs-toggle="collapse"
                                data-bs-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false"
                                aria-label="Toggle navigation">
                            <span class="navbar-toggler-icon"></span>
                        </button>
                    </div>
                </nav>
            </header>
            <div class="container">
                <div class="row">
                    <div class="col-xl-4 col-lg-5 col-md-7 mx-auto">
                        <div class="reset-passowrd">
                            <div class="card radius-10 w-100">
                                <div class="card-body p-4">
                                    <div class="text-center">
                                        <h4>Reset password</h4>
                                        <p>You will receive an e-mail in maximum 60 seconds</p>
                                    </div>
                                    <form action="MainController" method="POST" class="form-body row g-3">
                                        <div class="col-12">
                                            <label for="inputEmail" class="form-label">Username</label>
                                            <input type="text" class="form-control" name="userName" value="" id="inputEmail" placeholder="abc@example.com" required="">
                                            <label for="inputEmail" class="form-label">Email</label>
                                            <input type="email" class="form-control" name="email" value="" id="inputEmail" placeholder="abc@example.com" required="">
                                        </div>
                                        <div class="col-12 col-lg-12">
                                            <div class="d-grid">
                                                <input type="submit" name="btn" value="Retrieve" class="btn btn-primary">
                                            </div>
                                        </div>
                                        <c:set var="Error" value="${requestScope.ERROR}"/>
                                        <c:if test="${not empty Error}">
                                            <div class="text-center">
                                                <p>${Error}</p>
                                                <a href="index.jsp">Login in here</a>
                                            </div>
                                        </c:if>
                                    </form>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
            <footer class="my-5">
                <div class="container">
                    <div class="d-flex align-items-center gap-4 fs-5 justify-content-center social-login-footer">
                        <a href="javascript:;">
                            <ion-icon name="logo-twitter"></ion-icon>
                        </a>
                        <a href="javascript:;">
                            <ion-icon name="logo-linkedin"></ion-icon>
                        </a>
                        <a href="javascript:;">
                            <ion-icon name="logo-github"></ion-icon>
                        </a>
                        <a href="javascript:;">
                            <ion-icon name="logo-facebook"></ion-icon>
                        </a>
                        <a href="javascript:;">
                            <ion-icon name="logo-pinterest"></ion-icon>
                        </a>
                    </div>
                    <div class="text-center">
                        <p class="my-4">Copyright © 2021 UI Admin by Codervent.</p>
                    </div>
                </div>
            </footer>
        </div>
        <!--end wrapper-->

    </body>

</html>
