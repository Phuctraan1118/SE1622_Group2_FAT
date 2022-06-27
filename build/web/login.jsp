<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="en" class="no-js">

    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <title>Deazy | Responsive Bootstrap Landing Page Template</title>
        <meta name="description" content>
        <meta name="keywords" content>
        <meta name="author" content="Themesdesign">

        <link rel="shortcut icon" href="favicon.ico">

        <!-- Bootstrap core CSS -->
        <link rel="stylesheet" href="asset/css/bootstrap.min.css" type="text/css">

        <!--Material Icon -->
        <link rel="stylesheet" type="text/css" href="asset2/css/materialdesignicons.min.css">

        <!-- Pe-icon-7 icon -->
        <link rel="stylesheet" type="text/css" href="asset2/css/pe-icon-7-stroke.css">

        <!-- Custom  Css -->
        <link rel="stylesheet" type="text/css" href="asset2/css/style.css">

        <link rel="stylesheet" type="text/css" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css">

        <link rel="stylesheet" type="text/css"
              href="https://stackpath.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.bundle.min.js">
        <link rel="stylesheet" type="text/css" href="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js">

    </head>

    <body>
        <!-- START HOME -->

        <%
            String username = "", password = "", remember = "";
            Cookie[] cookies = request.getCookies();
            if (cookies != null) {
                for (Cookie cookie : cookies) {
                    if (cookie.getName().equals("USERNAME")) {
                        username = cookie.getValue();
                    } else if (cookie.getName().equals("PASSWORD")) {
                        password = cookie.getValue();
                    } else if (cookie.getName().equals("REMEMBER")) {
                        remember = cookie.getValue();
                    }
                }
            }
        %> 
        <section class="section bg-home home-five align-items-center d-flex" id="home">
            <div class="bg-overlay"></div>
            <div class="container slidero">
                <div class="row justify-content-center">
                    <div class="col-lg-9">
                        <div class="text-center text-white">
                            <div class="row">
                                <div class="col-md-6 mx-auto p-0">
                                    <div class="cardd">
                                        <div class="login-box">
                                            <form action="MainController" class="login-form" method="POST">
                                                <div class="login-snip">
                                                    <input id="tab-1" type="radio" name="tab" class="sign-in" checked><label
                                                        for="tab-1" class="tab">Login</label>
                                                    <input id="tab-2" type="radio" name="tab" class="sign-up"><label for="tab-2" class="tab">Sign Up</label>
                                                    <div class="login-space">
                                                        <div class="login">
                                                            <div class="group">
                                                                <label for="user" class="label">Username</label>
                                                                <input id="user" type="text" name="txtUsername" value="<%=username%>" class="input"
                                                                       placeholder="Enter your username">
                                                            </div>
                                                            <div class="group">
                                                                <label for="pass" class="label">Password</label>
                                                                <input id="pass" type="password" class="input" name="txtPassword" value="<%=password%>" data-type="password" placeholder="Enter your password">
                                                            </div>
                                                            <div class="group">
                                                                <input id="check" type="checkbox" name="txtRemember" id="remember-me" value="1" class="check" checked
                                                                       <% if ("1".equals(remember)) {
                                                                       %>
                                                                       checked="checked"
                                                                       <%
                                                                           }%>>
                                                                <label for="check"><span class="icon"></span> Keep me Signed
                                                                    in</label>
                                                            </div>
                                                            <div class="group">
                                                                <input type="submit" name="btn" class="button" value="login now">
                                                            </div>
                                                            <c:set var="error" value="${requestScope.ERROR}"/>
                                                            <c:if test="${not empty error}">
                                                                <p style="color: red;">${error}</p>
                                                            </c:if>
                                                            <div class="hr"></div>
                                                            <div>
                                                                <a class="hollow button primary" href="https://accounts.google.com/o/oauth2/auth?scope=%20profile%20email&redirect_uri=http://localhost:8080/HostelManagementSystem/LoginGoogleController&response_type=code&client_id=439305708712-m7f3ru5gmloasv1n079kjgh83run99mi.apps.googleusercontent.com&approval_prompt=force">
                                                                    <img src="assets/images/icons/google.png" width="20px" style="margin-bottom:3px; margin-right:5px" alt="Google login"/>
                                                                    Sign in with Google
                                                                </a>
                                                            </div>
                                                            <div class="hr"></div>
                                                            <div class="foot">
                                                                <a href="authentication-reset-password-simple.jsp">Forgot Password?</a>
                                                            </div>
                                                        </div>
                                                        <form action="MainController" method="post" class="form-body row g-3">
                                                            <c:set var="errors" value="${requestScope.CREATEERRORS}"/>
                                                            <div class="sign-up-form">
                                                                <div class="group">
                                                                    <label for="inputName" class="label">UserName</label>
                                                                    <input type="text" name="txtUsername" value="${param.txtUsername}" class="input" id="inputName" placeholder="(e.g. 6 - 20 chars)">
                                                                    <c:if test="${not empty errors.usernameLengthError}">
                                                                        <font color="red">
                                                                        ${errors.usernameLengthError}
                                                                        </font>
                                                                    </c:if>
                                                                    <c:if test="${not empty errors.usernameIsExisted}">
                                                                        <font color="red">
                                                                        ${errors.usernameIsExisted}
                                                                        </font>
                                                                    </c:if>
                                                                </div>
                                                                <div class="group">
                                                                    <label for="inputPassword" class="label">Password</label>
                                                                    <input type="password" name="txtPassword" value="" class="input" id="inputPassword" placeholder="(e.g. 3 - 20 chars)">
                                                                    <c:if test="${not empty errors.passwordLengthError}">
                                                                        <font color="red">
                                                                        ${errors.passwordLengthError}
                                                                        </font>
                                                                    </c:if>
                                                                </div>
                                                                <div class="group">
                                                                    <label for="inputPassword" class="label">Confirm Password</label>
                                                                    <input type="password" name="txtConfirm" value="" class="input" id="inputConfirm">
                                                                    <c:if test="${not empty errors.confirmNotMatched}">
                                                                        <font color="red">
                                                                        ${errors.confirmNotMatched}
                                                                        </font>
                                                                    </c:if>
                                                                </div>
                                                                <div class="group">
                                                                    <label for="inputEmail" class="label">FullName</label>
                                                                    <input type="text" name="txtFullname" value="${param.txtFullname}" class="input" id="inputFullName" placeholder="(e.g. 2 - 50 chars)">
                                                                    <c:if test="${not empty errors.fullnameLengthError}">
                                                                        <font color="red">
                                                                        ${errors.fullnameLengthError}
                                                                        </font>
                                                                    </c:if>
                                                                </div>
                                                                <div class="group">
                                                                    <label class="label">Email</label>
                                                                    <input type="email" name="txtEmail" value="${param.txtEmail}"  class="input" id="inputEmail" placeholder="(e.g. 6 - 400 chars)">
                                                                    <c:if test="${not empty errors.emailLengthError}">
                                                                        <font color="red">
                                                                        ${errors.emailLengthError}
                                                                        </font>
                                                                    </c:if>
                                                                </div>
                                                                <div class="group">
                                                                    <label class="label">Address</label>
                                                                    <input type="text" name="txtAddress" value="${param.txtAddress}"  class="input" id="inputAddress" placeholder="(e.g. 3 - 50 chars)">
                                                                    <c:if test="${not empty errors.addressLengthError}">
                                                                        <font color="red">
                                                                        ${errors.addressLengthError}
                                                                        </font>
                                                                    </c:if>
                                                                </div>
                                                                <div class="group">
                                                                    <label class="label">Phone</label>
                                                                    <input type="text" name="txtPhone" value="${param.txtPhone}"  class="input" id="inputPhone" placeholder="(e.g. 10 chars)">
                                                                    <c:if test="${not empty errors.phoneLengthError}">
                                                                        <font color="red">
                                                                        ${errors.phoneLengthError}
                                                                        </font>
                                                                    </c:if>
                                                                </div>
                                                                <div class="group">
                                                                    <label class="label">Citizen Identification Number</label>
                                                                    <input type="text" name="txtCitizenIdetification" value="${param.txtCitizenIdetification}"  class="input" id="inputPhone" placeholder="(e.g. 10 chars)">
                                                                    <c:if test="${not empty errors.citizenIdentificationLengthError}">
                                                                        <font color="red">
                                                                        ${errors.citizenIdentificationLengthError}
                                                                        </font>
                                                                    </c:if>
                                                                </div>
                                                                <div class="group">
                                                                    <input type="submit" class="button" name="btn" value="Sign Up">

                                                                    <div class="hr"></div>
                                                                    <div class="foot">
                                                                        <label for="tab-1">Already Member?</label>
                                                                    </div>
                                                                </div>
                                                        </form>
                                                    </div>
                                                </div>
                                            </form>
                                        </div>
                                    </div>
                                </div>
                            </div>

                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</section>
<!-- END HOME -->


<!-- bootstrap -->
<script src="js/bootstrap.bundle.min.js"></script>
<!-- JAVASCRIPTS -->
<script src="js/smooth-scroll.polyfills.min.js"></script>
<script src="js/gumshoe.polyfills.min.js"></script>
<!--Partical js-->
<script src="js/particles.js"></script>
<script src="js/particles.app.js"></script>
<!-- CUSTOM JS -->
<script src="js/app.js"></script>
</body>

</html>