<%-- 
    Document   : index
    Created on : Jun 1, 2022, 11:40:52 PM
    Author     : buikh
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="UTF-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>Complete Responsive Construction Website Design Tutorial</title>

        <!-- font awesome cdn link  -->
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.4/css/all.min.css">

        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/lightgallery-js/1.4.0/css/lightgallery.min.css">

        <link rel="stylesheet" href="https://unpkg.com/swiper@7/swiper-bundle.min.css" />

        <!-- custom css file link  -->
        <link rel="stylesheet" href="css/style.css">
        <link rel="stylesheet" href="css/style.scss">

    </head>
    <body>

        <!-- header section starts  -->

        <header class="header">

            <a href="#" class="logo"><img src="images/good1.png" alt=""></a>

            <nav class="navbar">
                <a href="#home">home</a>
                <a href="#about">about</a>
                <a href="#services">services</a>
                <a href="#projects">projects</a>
                <a href="#pricing">pricing</a>
                <a href="#contact">contact</a>
                <a href="#blogs">blogs</a>
            </nav>

            <div class="icons">
                <div id="menu-btn" class="fas fa-bars"></div>
                <div id="info-btn" class="fas fa-info-circle"></div>
                <div id="search-btn" class="fas fa-search"></div>
                <div id="login-btn" class="fas fa-user"></div>
            </div>

            <form action="MainController" class="search-form">
                <input type="search" name="txtSearch" placeholder="search here..." id="search-box">
                <label for="search-box" class="fas fa-search"></label>
            </form>
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

            <form action="MainController" class="login-form" method="POST">
                <h3>login form</h3>
                <input type="text" name="txtUsername" value="<%=username%>" placeholder="enter your email" class="box">
                <input type="password" name="txtPassword" value="<%=password%>" placeholder="enter your password" class="box">
                <div class="flex">
                    <input type="checkbox" name="txtRemember" id="remember-me" value="1" 
                           <% if ("1".equals(remember)) {
                                %>
                                    checked="checked"
                                <%
                            }%>
                           />

                    <label for="remember-me">remember me</label>
                    <a href="authentication-reset-password-simple.jsp">Forgot Password?</a>
                </div>
                <input type="submit" name="btn" value="login now" class="btn">
                <a href="https://accounts.google.com/o/oauth2/auth?scope=profile&redirect_uri=http://localhost:8080/HostelManagementSystem/LoginGoogleController&response_type=code&client_id=439305708712-m7f3ru5gmloasv1n079kjgh83run99mi.apps.googleusercontent.com&approval_prompt=force" style="background: red; color: white" class="btn">Login With Google</a>
                <p>don't have an account <a href="authentication-sign-up-simple.html">create one!</a></p>
            </form>

        </header>

        <div class="contact-info">

            <div id="close-contact-info" class="fas fa-times"></div>

            <div class="info">
                <i class="fas fa-phone"></i>
                <h3>phone number</h3>
                <p>+123-456-7890</p>
                <p>+111-222-3333</p>
            </div>

            <div class="info">
                <i class="fas fa-envelope"></i>
                <h3>email address</h3>
                <p>shaikhanas@gmail.com</p>
                <p>anasbhai@gmail.com</p>
            </div>

            <div class="info">
                <i class="fas fa-map-marker-alt"></i>
                <h3>office address</h3>
                <p>mumbai, india - 400104</p>
            </div>

            <div class="share">
                <a href="#" class="fab fa-facebook-f"></a>
                <a href="#" class="fab fa-twitter"></a>
                <a href="#" class="fab fa-instagram"></a>
                <a href="#" class="fab fa-linkedin"></a>
            </div>

        </div>

        <!-- header section ends -->

        <!-- home section starts  -->

        <section class="home" id="home">

            <div class="swiper home-slider">

                <div class="swiper-wrapper">

                    <section class="swiper-slide slide" style="background: url(images/top2.jpg) no-repeat;">
                        <div class="content">
                            <h3>we provide best service</h3>
                            <p>Lorem ipsum dolor, sit amet consectetur adipisicing elit. Aspernatur beatae iusto pariatur laborum magnam eos!</p>
                            <a href="#about" class="btn">get started</a>
                        </div>
                    </section>

                    <section class="swiper-slide slide" style="background: url(images/home-slide-2.jpg) no-repeat;">
                        <div class="content">
                            <h3>making dream come to life</h3>
                            <p>Lorem ipsum dolor, sit amet consectetur adipisicing elit. Aspernatur beatae iusto pariatur laborum magnam eos!</p>
                            <a href="#about" class="btn">get started</a>
                        </div>
                    </section>

                    <section class="swiper-slide slide" style="background: url(images/home-slide-3.jpg) no-repeat;">
                        <div class="content">
                            <h3>from concept to creation</h3>
                            <p>Lorem ipsum dolor, sit amet consectetur adipisicing elit. Aspernatur beatae iusto pariatur laborum magnam eos!</p>
                            <a href="#about" class="btn">get started</a>
                        </div>
                    </section>

                </div>

                <div class="swiper-button-next"></div>
                <div class="swiper-button-prev"></div>

            </div>

        </section>

        <!-- home section ends -->

        <!-- about section starts  -->

        <section class="about" id="about" style="background: url(images/top2.jpg) no-repeat;">

            <h1 class="heading"> about us </h1>

            <div class="row">

                <div class="video">
                    <video src="images/about-vid.mp4" loop muted autoplay></video>
                </div>

                <div class="content">
                    <h3>We will provide you the best work which you dreamt for!</h3>
                    <p>Lorem ipsum dolor sit amet consectetur adipisicing elit. Quas et vero mollitia nemo corporis consequatur aspernatur distinctio dignissimos velit nam.</p>
                    <a href="#services" class="btn">read more</a>
                </div>

            </div>

            <div class="box-container">

                <div class="box">
                    <h3>10+</h3>
                    <p>years of experience</p>
                </div>

                <div class="box">
                    <h3>1500+</h3>
                    <p>project completed</p>
                </div>

                <div class="box">
                    <h3>790+</h3>
                    <p>satiesfied clients</p>
                </div>

                <div class="box">
                    <h3>450+</h3>
                    <p>active workers</p>
                </div>

            </div>

        </section>

        <!-- about section ends -->

        <!-- services section starts  -->

        <section class="services" id="services">

            <h1 class="heading"> our services </h1>

            <div class="box-container">

                <div class="box">
                    <img src="images/service-1.png" alt="">
                    <h3>building construction</h3>
                    <p>Lorem ipsum dolor sit amet consectetur adipisicing elit. Fugit, necessitatibus.</p>
                </div>

                <div class="box">
                    <img src="images/service-2.png" alt="">
                    <h3>house renovation</h3>
                    <p>Lorem ipsum dolor sit amet consectetur adipisicing elit. Fugit, necessitatibus.</p>
                </div>

                <div class="box">
                    <img src="images/service-3.png" alt="">
                    <h3>architechture design</h3>
                    <p>Lorem ipsum dolor sit amet consectetur adipisicing elit. Fugit, necessitatibus.</p>
                </div>

                <div class="box">
                    <img src="images/service-4.png" alt="">
                    <h3>material supply</h3>
                    <p>Lorem ipsum dolor sit amet consectetur adipisicing elit. Fugit, necessitatibus.</p>
                </div>

                <div class="box">
                    <img src="images/service-5.png" alt="">
                    <h3>construction consultant</h3>
                    <p>Lorem ipsum dolor sit amet consectetur adipisicing elit. Fugit, necessitatibus.</p>
                </div>

                <div class="box">
                    <img src="images/service-6.png" alt="">
                    <h3>interior design</h3>
                    <p>Lorem ipsum dolor sit amet consectetur adipisicing elit. Fugit, necessitatibus.</p>
                </div>

                <div class="box">
                    <img src="images/service-7.png" alt="">
                    <h3>building maintenance</h3>
                    <p>Lorem ipsum dolor sit amet consectetur adipisicing elit. Fugit, necessitatibus.</p>
                </div>

                <div class="box">
                    <img src="images/service-8.png" alt="">
                    <h3>building renovation</h3>
                    <p>Lorem ipsum dolor sit amet consectetur adipisicing elit. Fugit, necessitatibus.</p>
                </div>

            </div>

        </section>

        <!-- services section ends -->

        <!-- projects section starts  -->

        <section class="projects" id="projects">

            <h1 class="heading"> our projects </h1>

            <div class="box-container">

                <a href="images/project-1.jpg" class="box">
                    <div class="image">
                        <img src="images/project-1.jpg" alt="">
                    </div>
                    <div class="content">
                        <div class="info">
                            <h3>dream home</h3>
                            <p>construction, design</p>
                        </div>
                        <i class="fas fa-plus"></i>
                    </div>
                </a>

                <a href="images/project-2.jpg" class="box">
                    <div class="image">
                        <img src="images/project-2.jpg" alt="">
                    </div>
                    <div class="content">
                        <div class="info">
                            <h3>dream home</h3>
                            <p>construction, design</p>
                        </div>
                        <i class="fas fa-plus"></i>
                    </div>
                </a>

                <a href="images/project-3.jpg" class="box">
                    <div class="image">
                        <img src="images/project-3.jpg" alt="">
                    </div>
                    <div class="content">
                        <div class="info">
                            <h3>dream home</h3>
                            <p>construction, design</p>
                        </div>
                        <i class="fas fa-plus"></i>
                    </div>
                </a>

                <a href="images/project-4.jpg" class="box">
                    <div class="image">
                        <img src="images/project-4.jpg" alt="">
                    </div>
                    <div class="content">
                        <div class="info">
                            <h3>dream home</h3>
                            <p>construction, design</p>
                        </div>
                        <i class="fas fa-plus"></i>
                    </div>
                </a>

                <a href="images/project-5.jpg" class="box">
                    <div class="image">
                        <img src="images/project-5.jpg" alt="">
                    </div>
                    <div class="content">
                        <div class="info">
                            <h3>dream home</h3>
                            <p>construction, design</p>
                        </div>
                        <i class="fas fa-plus"></i>
                    </div>
                </a>

                <a href="images/project-6.jpg" class="box">
                    <div class="image">
                        <img src="images/project-6.jpg" alt="">
                    </div>
                    <div class="content">
                        <div class="info">
                            <h3>dream home</h3>
                            <p>construction, design</p>
                        </div>
                        <i class="fas fa-plus"></i>
                    </div>
                </a>

            </div>

        </section>

        <!-- projects section ends -->

        <!-- reviews section starts  -->

        <section class="reviews">

            <h1 class="heading"> clients reviews </h1>

            <div class="swiper reviews-slider">

                <div class="swiper-wrapper">

                    <div class="swiper-slide slide">
                        <p>Lorem, ipsum dolor sit amet consectetur adipisicing elit. Nobis unde suscipit quis consequuntur, tempora corporis ex molestias dignissimos in cumque sunt ducimus voluptate inventore harum earum rem aperiam vel modi?</p>
                        <div class="user">
                            <img src="images/pic-1.png" alt="">
                            <div class="info">
                                <h3>john deo</h3>
                                <div class="stars">
                                    <i class="fas fa-star"></i>
                                    <i class="fas fa-star"></i>
                                    <i class="fas fa-star"></i>
                                    <i class="fas fa-star"></i>
                                    <i class="fas fa-star"></i>
                                </div>
                            </div>
                        </div>
                    </div>

                    <div class="swiper-slide slide">
                        <p>Lorem, ipsum dolor sit amet consectetur adipisicing elit. Nobis unde suscipit quis consequuntur, tempora corporis ex molestias dignissimos in cumque sunt ducimus voluptate inventore harum earum rem aperiam vel modi?</p>
                        <div class="user">
                            <img src="images/pic-2.png" alt="">
                            <div class="info">
                                <h3>john deo</h3>
                                <div class="stars">
                                    <i class="fas fa-star"></i>
                                    <i class="fas fa-star"></i>
                                    <i class="fas fa-star"></i>
                                    <i class="fas fa-star"></i>
                                    <i class="fas fa-star"></i>
                                </div>
                            </div>
                        </div>
                    </div>

                    <div class="swiper-slide slide">
                        <p>Lorem, ipsum dolor sit amet consectetur adipisicing elit. Nobis unde suscipit quis consequuntur, tempora corporis ex molestias dignissimos in cumque sunt ducimus voluptate inventore harum earum rem aperiam vel modi?</p>
                        <div class="user">
                            <img src="images/pic-3.png" alt="">
                            <div class="info">
                                <h3>john deo</h3>
                                <div class="stars">
                                    <i class="fas fa-star"></i>
                                    <i class="fas fa-star"></i>
                                    <i class="fas fa-star"></i>
                                    <i class="fas fa-star"></i>
                                    <i class="fas fa-star"></i>
                                </div>
                            </div>
                        </div>
                    </div>

                    <div class="swiper-slide slide">
                        <p>Lorem, ipsum dolor sit amet consectetur adipisicing elit. Nobis unde suscipit quis consequuntur, tempora corporis ex molestias dignissimos in cumque sunt ducimus voluptate inventore harum earum rem aperiam vel modi?</p>
                        <div class="user">
                            <img src="images/pic-4.png" alt="">
                            <div class="info">
                                <h3>john deo</h3>
                                <div class="stars">
                                    <i class="fas fa-star"></i>
                                    <i class="fas fa-star"></i>
                                    <i class="fas fa-star"></i>
                                    <i class="fas fa-star"></i>
                                    <i class="fas fa-star"></i>
                                </div>
                            </div>
                        </div>
                    </div>

                    <div class="swiper-slide slide">
                        <p>Lorem, ipsum dolor sit amet consectetur adipisicing elit. Nobis unde suscipit quis consequuntur, tempora corporis ex molestias dignissimos in cumque sunt ducimus voluptate inventore harum earum rem aperiam vel modi?</p>
                        <div class="user">
                            <img src="images/pic-5.png" alt="">
                            <div class="info">
                                <h3>john deo</h3>
                                <div class="stars">
                                    <i class="fas fa-star"></i>
                                    <i class="fas fa-star"></i>
                                    <i class="fas fa-star"></i>
                                    <i class="fas fa-star"></i>
                                    <i class="fas fa-star"></i>
                                </div>
                            </div>
                        </div>
                    </div>

                    <div class="swiper-slide slide">
                        <p>Lorem, ipsum dolor sit amet consectetur adipisicing elit. Nobis unde suscipit quis consequuntur, tempora corporis ex molestias dignissimos in cumque sunt ducimus voluptate inventore harum earum rem aperiam vel modi?</p>
                        <div class="user">
                            <img src="images/pic-6.png" alt="">
                            <div class="info">
                                <h3>john deo</h3>
                                <div class="stars">
                                    <i class="fas fa-star"></i>
                                    <i class="fas fa-star"></i>
                                    <i class="fas fa-star"></i>
                                    <i class="fas fa-star"></i>
                                    <i class="fas fa-star"></i>
                                </div>
                            </div>
                        </div>
                    </div>

                </div>

            </div>

        </section>

        <!-- reviews section ends -->

        <!-- pricing section starts  -->

        <section class="pricing" id="pricing">

            <h1 class="heading"> our pricing </h1>

            <div class="box-container">

                <div class="box">
                    <i class="fas fa-home"></i>
                    <h3>basic plan</h3>
                    <div class="price"><span>$</span>250<span>/mo</span></div>
                    <div class="list">
                        <p>interior design</p>
                        <p>refurbishment</p>
                        <p>material supply</p>
                        <p>maintenance</p>
                        <p>24/7 support</p>
                    </div>
                    <a href="#" class="btn">choose plan</a>
                </div>

                <div class="box">
                    <i class="fas fa-building"></i>
                    <h3>premium plan</h3>
                    <div class="price"><span>$</span>650<span>/mo</span></div>
                    <div class="list">
                        <p>interior design</p>
                        <p>refurbishment</p>
                        <p>material supply</p>
                        <p>maintenance</p>
                        <p>24/7 support</p>
                    </div>
                    <a href="#" class="btn">choose plan</a>
                </div>

                <div class="box">
                    <i class="fas fa-city"></i>
                    <h3>ultimate plan</h3>
                    <div class="price"><span>$</span>1250<span>/mo</span></div>
                    <div class="list">
                        <p>interior design</p>
                        <p>refurbishment</p>
                        <p>material supply</p>
                        <p>maintenance</p>
                        <p>24/7 support</p>
                    </div>
                    <a href="#" class="btn">choose plan</a>
                </div>

            </div>

        </section>

        <!-- pricing section ends -->

        <!-- contact section starts  -->

        <section class="contact" id="contact">

            <h1 class="heading"> contact us </h1>

            <div class="row">

                <iframe class="map" src="https://www.google.com/maps/embed?pb=!1m18!1m12!1m3!1d15076.89592087332!2d72.8319697277345!3d19.14167056419224!2m3!1f0!2f0!3f0!3m2!1i1024!2i768!4f13.1!3m3!1m2!1s0x3be7b63aceef0c69%3A0x2aa80cf2287dfa3b!2sJogeshwari%20West%2C%20Mumbai%2C%20Maharashtra%20400047!5e0!3m2!1sen!2sin!4v1641716772852!5m2!1sen!2sin" allowfullscreen="" loading="lazy"></iframe>

                <form action="">
                    <h3>get in touch</h3>
                    <input type="text" placeholder="name" class="box">
                    <input type="email" placeholder="email" class="box">
                    <input type="number" placeholder="phone" class="box">
                    <textarea name="" placeholder="message" class="box" id="" cols="30" rows="10"></textarea>
                    <input type="submit" value="send message" class="btn">
                </form>

            </div>

        </section>

        <!-- contact section ends -->

        <!-- blogs section starts  -->

        <section class="blogs" id="blogs">

            <h1 class="heading"> our blogs </h1>

            <div class="swiper blogs-slider">

                <div class="swiper-wrapper">

                    <div class="swiper-slide slide">
                        <div class="image">
                            <img src="images/blog-1.jpg" alt="">
                        </div>
                        <div class="content">
                            <h3>blog title goes here</h3>
                            <p>Lorem ipsum, dolor sit amet consectetur adipisicing elit. Assumenda, nobis!</p>
                            <a href="#" class="btn">read more</a>
                        </div>
                    </div>

                    <div class="swiper-slide slide">
                        <div class="image">
                            <img src="images/blog-2.jpg" alt="">
                        </div>
                        <div class="content">
                            <h3>blog title goes here</h3>
                            <p>Lorem ipsum, dolor sit amet consectetur adipisicing elit. Assumenda, nobis!</p>
                            <a href="#" class="btn">read more</a>
                        </div>
                    </div>

                    <div class="swiper-slide slide">
                        <div class="image">
                            <img src="images/blog-3.jpg" alt="">
                        </div>
                        <div class="content">
                            <h3>blog title goes here</h3>
                            <p>Lorem ipsum, dolor sit amet consectetur adipisicing elit. Assumenda, nobis!</p>
                            <a href="#" class="btn">read more</a>
                        </div>
                    </div>

                    <div class="swiper-slide slide">
                        <div class="image">
                            <img src="images/blog-4.jpg" alt="">
                        </div>
                        <div class="content">
                            <h3>blog title goes here</h3>
                            <p>Lorem ipsum, dolor sit amet consectetur adipisicing elit. Assumenda, nobis!</p>
                            <a href="#" class="btn">read more</a>
                        </div>
                    </div>

                    <div class="swiper-slide slide">
                        <div class="image">
                            <img src="images/blog-5.jpg" alt="">
                        </div>
                        <div class="content">
                            <h3>blog title goes here</h3>
                            <p>Lorem ipsum, dolor sit amet consectetur adipisicing elit. Assumenda, nobis!</p>
                            <a href="#" class="btn">read more</a>
                        </div>
                    </div>

                    <div class="swiper-slide slide">
                        <div class="image">
                            <img src="images/blog-6.jpg" alt="">
                        </div>
                        <div class="content">
                            <h3>blog title goes here</h3>
                            <p>Lorem ipsum, dolor sit amet consectetur adipisicing elit. Assumenda, nobis!</p>
                            <a href="#" class="btn">read more</a>
                        </div>
                    </div>

                </div>

            </div>

        </section>

        <!-- blogs section ends -->

        <!-- client logo section starts -->

        <section class="logo-container">
            <div class="swiper logo-slider">
                <div class="swiper-wrapper">
                    <div class="swiper-slide slide"><img src="images/client-logo-1.png" alt=""></div>
                    <div class="swiper-slide slide"><img src="images/client-logo-2.png" alt=""></div>
                    <div class="swiper-slide slide"><img src="images/client-logo-3.png" alt=""></div>
                    <div class="swiper-slide slide"><img src="images/client-logo-4.png" alt=""></div>
                    <div class="swiper-slide slide"><img src="images/client-logo-5.png" alt=""></div>
                    <div class="swiper-slide slide"><img src="images/client-logo-6.png" alt=""></div>
                </div>
            </div>
        </section>

        <!-- client logo section ends -->

        <!-- footer section starts  -->

        <section class="footer">

            <div class="links">
                <a class="btn" href="#home">home</a>
                <a class="btn" href="#about">about</a>
                <a class="btn" href="#services">services</a>
                <a class="btn" href="#projects">projects</a>
                <a class="btn" href="#pricing">pricing</a>
                <a class="btn" href="#contact">contact</a>
                <a class="btn" href="#blogs">blogs</a>
            </div>

            <div class="credit"> created by <span>mr. web designer</span> | all rights reserved! </div>

        </section>

        <!-- footer section ends -->









        <script src="https://cdnjs.cloudflare.com/ajax/libs/lightgallery-js/1.4.0/js/lightgallery.min.js"></script>

        <script src="https://unpkg.com/swiper@7/swiper-bundle.min.js"></script>

        <!-- custom js file link  -->
        <script src="js/script.js"></script>

        <script>

            lightGallery(document.querySelector('.projects .box-container'));

        </script>

    </body>
</html>
