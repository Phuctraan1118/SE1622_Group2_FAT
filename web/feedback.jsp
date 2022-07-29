<%-- 
    Document   : feedback
    Created on : Jul 14, 2022, 3:21:11 PM
    Author     : hungp
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!doctype html>
<html lang="en" class="semi-dark">
    <head>
        <!-- Required meta tags -->
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">

        <!-- loader-->
        <link href="assets/css/pace.min.css" rel="stylesheet" />
        <script src="assets/js/pace.min.js"></script>

        <!--plugins-->
        <link href="assets/plugins/perfect-scrollbar/css/perfect-scrollbar.css" rel="stylesheet" />
        <link href="assets/plugins/simplebar/css/simplebar.css" rel="stylesheet" />
        <link href="assets/plugins/metismenu/css/metisMenu.min.css" rel="stylesheet" />

        <!-- CSS Files -->
        <link href="assets/css/bootstrap.min.css" rel="stylesheet">
        <link href="assets/css/bootstrap-extended.css" rel="stylesheet">
        <link href="assets/css/style.css" rel="stylesheet">
        <link href="assets/css/icons.css" rel="stylesheet">
        <link href="https://fonts.googleapis.com/css2?family=Roboto:wght@400;500&display=swap" rel="stylesheet">

        <!--Theme Styles-->
        <link href="assets/css/dark-theme.css" rel="stylesheet" />
        <link href="assets/css/semi-dark.css" rel="stylesheet" />
        <link href="assets/css/header-colors.css" rel="stylesheet" />

        <title>Send Feedback</title>
    </head>
    <body>


        <!--start wrapper-->
        <div class="wrapper">
            <!--start sidebar -->
            <aside class="sidebar-wrapper" data-simplebar="true">
                <div class="sidebar-header">
                    <font color="yellow">
                    <div>
                        <h6>Welcome ${USER.name} (USER)</h6>
                    </div></font>
                    <div class="toggle-icon ms-auto"><ion-icon name="menu-sharp"></ion-icon>
                    </div>
                </div>
                <!--navigation-->
                <ul class="metismenu" id="menu">
                    <li class="menu-label">Pages</li>
                    <li>
                        <a href="pages-user1-profile.jsp">
                            <div class="parent-icon">
                                <ion-icon name="person-circle-sharp"></ion-icon>
                            </div>
                            <div class="menu-title">User Profile</div>
                        </a>
                    </li>
                    <c:if test="${not empty User}">
                        <li>
                            <a href="pages-edit-profile.jsp">
                                <div class="parent-icon">
                                    <ion-icon name="create-sharp"></ion-icon>
                                </div>
                                <div class="menu-title">Edit Profile</div>
                            </a>
                        </li>
                    </c:if>
                    <li>

                        <a href="MainController?txtSearchValue=&btn=Search+room+for+customer">
                            <div class="parent-icon">
                                <ion-icon name="home-outline"></ion-icon>
                            </div>
                            <div class="menu-title">View Room</div>
                        </a>

                    </li>

                    <li>

                        <a href="RoomOwnedViewController">
                            <div class="parent-icon">
                                <ion-icon name="planet-outline"></ion-icon>
                            </div>
                            <div class="menu-title">Owned Room</div>
                        </a>

                    </li>
                    <li>

                        <a href="RegulationDisplayController">
                            <div class="parent-icon">
                                <ion-icon name="shield-outline"></ion-icon>
                            </div>
                            <div class="menu-title">View Regulation</div>
                        </a>

                    </li>
                    <li>

                        <a href="viewBillOfUser.jsp">
                            <div class="parent-icon">
                                <ion-icon name="shield-outline"></ion-icon>
                            </div>
                            <div class="menu-title">View History Bill</div>
                        </a>

                    </li> 
                    <li>
                        <a href="feedback.jsp">
                            <i class="fadeIn animated bx bx-comment-detail" style="font-size: 22px"></i>Feedback Management
                        </a>
                    </li>

                </ul>
                <!--end navigation-->
            </aside>
            <!--end sidebar -->

            <!--start top header-->
            <header class="top-header">
                <nav class="navbar navbar-expand gap-3">
                    <div class="top-navbar-right ms-auto">
                        <ul class="navbar-nav align-items-center">
                            <li class="nav-item">
                                <a class="nav-link dark-mode-icon" href="javascript:;">
                                    <div class="mode-icon">
                                        <ion-icon name="moon-sharp"></ion-icon> 
                                    </div>
                                </a>
                            </li>
                            <li class="nav-item dropdown dropdown-large dropdown-apps">
                                <a class="nav-link dropdown-toggle dropdown-toggle-nocaret" href="javascript:;" data-bs-toggle="dropdown">
                                    <div class="">
                                        <ion-icon name="apps-sharp"></ion-icon>
                                    </div>
                                </a>
                            </li>
                            <li class="nav-item dropdown dropdown-large">
                                <a class="nav-link dropdown-toggle dropdown-toggle-nocaret" href="javascript:;" data-bs-toggle="dropdown">
                                    <div class="position-relative">
                                        <span class="notify-badge">8</span>
                                        <ion-icon name="notifications-sharp"></ion-icon>
                                    </div>
                                </a>
                                <div class="dropdown-menu dropdown-menu-end">
                                    <a href="javascript:;">
                                        <div class="msg-header">
                                            <p class="msg-header-title">Notifications</p>
                                            <p class="msg-header-clear ms-auto">Marks all as read</p>
                                        </div>
                                    </a>
                                    <div class="header-notifications-list">
                                        <a class="dropdown-item" href="javascript:;">
                                            <div class="d-flex align-items-center">
                                                <div class="notify text-primary"><ion-icon name="cart-outline"></ion-icon>
                                                </div>
                                                <div class="flex-grow-1">
                                                    <h6 class="msg-name">New Orders <span class="msg-time float-end">2 min
                                                            ago</span></h6>
                                                    <p class="msg-info">You have recived new orders</p>
                                                </div>
                                            </div>
                                        </a>
                                        <a class="dropdown-item" href="javascript:;">
                                            <div class="d-flex align-items-center">
                                                <div class="notify text-danger"><ion-icon name="person-outline"></ion-icon>
                                                </div>
                                                <div class="flex-grow-1">
                                                    <h6 class="msg-name">New Customers<span class="msg-time float-end">14 Sec
                                                            ago</span></h6>
                                                    <p class="msg-info">5 new user registered</p>
                                                </div>
                                            </div>
                                        </a>
                                        <a class="dropdown-item" href="javascript:;">
                                            <div class="d-flex align-items-center">
                                                <div class="notify text-success"><ion-icon name="document-outline"></ion-icon>
                                                </div>
                                                <div class="flex-grow-1">
                                                    <h6 class="msg-name">24 PDF File<span class="msg-time float-end">19 min
                                                            ago</span></h6>
                                                    <p class="msg-info">The pdf files generated</p>
                                                </div>
                                            </div>
                                        </a>

                                        <a class="dropdown-item" href="javascript:;">
                                            <div class="d-flex align-items-center">
                                                <div class="notify text-info"><ion-icon name="checkmark-done-outline"></ion-icon>
                                                </div>
                                                <div class="flex-grow-1">
                                                    <h6 class="msg-name">New Product Approved <span
                                                            class="msg-time float-end">2 hrs ago</span></h6>
                                                    <p class="msg-info">Your new product has approved</p>
                                                </div>
                                            </div>
                                        </a>
                                        <a class="dropdown-item" href="javascript:;">
                                            <div class="d-flex align-items-center">
                                                <div class="notify text-warning"><ion-icon name="send-outline"></ion-icon>
                                                </div>
                                                <div class="flex-grow-1">
                                                    <h6 class="msg-name">Time Response <span class="msg-time float-end">28 min
                                                            ago</span></h6>
                                                    <p class="msg-info">5.1 min avarage time response</p>
                                                </div>
                                            </div>
                                        </a>
                                        <a class="dropdown-item" href="javascript:;">
                                            <div class="d-flex align-items-center">
                                                <div class="notify text-danger"><ion-icon name="chatbox-ellipses-outline"></ion-icon>
                                                </div>
                                                <div class="flex-grow-1">
                                                    <h6 class="msg-name">New Comments <span class="msg-time float-end">4 hrs
                                                            ago</span></h6>
                                                    <p class="msg-info">New customer comments recived</p>
                                                </div>
                                            </div>
                                        </a>
                                        <a class="dropdown-item" href="javascript:;">
                                            <div class="d-flex align-items-center">
                                                <div class="notify text-primary"><ion-icon name="albums-outline"></ion-icon>
                                                </div>
                                                <div class="flex-grow-1">
                                                    <h6 class="msg-name">New 24 authors<span class="msg-time float-end">1 day
                                                            ago</span></h6>
                                                    <p class="msg-info">24 new authors joined last week</p>
                                                </div>
                                            </div>
                                        </a>
                                        <a class="dropdown-item" href="javascript:;">
                                            <div class="d-flex align-items-center">
                                                <div class="notify text-success"><ion-icon name="shield-outline"></ion-icon>
                                                </div>
                                                <div class="flex-grow-1">
                                                    <h6 class="msg-name">Your item is shipped <span class="msg-time float-end">5 hrs
                                                            ago</span></h6>
                                                    <p class="msg-info">Successfully shipped your item</p>
                                                </div>
                                            </div>
                                        </a>
                                        <a class="dropdown-item" href="javascript:;">
                                            <div class="d-flex align-items-center">
                                                <div class="notify text-warning"><ion-icon name="cafe-outline"></ion-icon>
                                                </div>
                                                <div class="flex-grow-1">
                                                    <h6 class="msg-name">Defense Alerts <span class="msg-time float-end">2 weeks
                                                            ago</span></h6>
                                                    <p class="msg-info">45% less alerts last 4 weeks</p>
                                                </div>
                                            </div>
                                        </a>
                                    </div>
                                    <a href="javascript:;">
                                        <div class="text-center msg-footer">View All Notifications</div>
                                    </a>
                                </div>
                            </li>
                            <li class="nav-item dropdown dropdown-user-setting">
                                <a class="nav-link dropdown-toggle dropdown-toggle-nocaret" href="javascript:;" data-bs-toggle="dropdown">
                                    <div class="user-setting">
                                        <img src="${USER.img}" class="user-img" alt="">
                                    </div>
                                </a>
                                <ul class="dropdown-menu dropdown-menu-end">
                                    <li>
                                        <a class="dropdown-item" href="#">
                                            <div class="d-flex flex-row align-items-center gap-2">
                                                <img src="${USER.img}" alt="" class="rounded-circle" width="54" height="54">
                                                <div class="">
                                                    <h6 class="mb-0 dropdown-user-name">${USER.name}</h6>
                                                </div>
                                            </div>
                                        </a>
                                    </li>
                                    <li><hr class="dropdown-divider"></li>
                                    <li>
                                        <a class="dropdown-item" href="pages-user1-profile.jsp">
                                            <div class="d-flex align-items-center">
                                                <div class=""><ion-icon name="person-outline"></ion-icon></div>
                                                <div class="ms-3"><span>Profile</span></div>
                                            </div>
                                        </a>
                                    </li>
                                    <li>
                                        <a class="dropdown-item" href="#">
                                            <div class="d-flex align-items-center">
                                                <div class=""><ion-icon name="settings-outline"></ion-icon></div>
                                                <div class="ms-3"><span>Setting</span></div>
                                            </div>
                                        </a>
                                    </li>
                                    <li>
                                        <a class="dropdown-item" href="index2.html">
                                            <div class="d-flex align-items-center">
                                                <div class=""><ion-icon name="speedometer-outline"></ion-icon></div>
                                                <div class="ms-3"><span>Dashboard</span></div>
                                            </div>
                                        </a>
                                    </li>
                                    <li>
                                        <a class="dropdown-item" href="#">
                                            <div class="d-flex align-items-center">
                                                <div class=""><ion-icon name="wallet-outline"></ion-icon></div>
                                                <div class="ms-3"><span>Earnings</span></div>
                                            </div>
                                        </a>
                                    </li>
                                    <li>
                                        <a class="dropdown-item" href="#">
                                            <div class="d-flex align-items-center">
                                                <div class=""><ion-icon name="cloud-download-outline"></ion-icon></div>
                                                <div class="ms-3"><span>Downloads</span></div>
                                            </div>
                                        </a>
                                    </li>
                                    <li><hr class="dropdown-divider"></li>
                                    <li>
                                        <a class="dropdown-item" href="MainController?btn=Logout">
                                            <div class="d-flex align-items-center">
                                                <div class=""><ion-icon name="log-out-outline"></ion-icon></div>
                                                <div class="ms-3"><span>Logout</span></div>
                                            </div>
                                        </a>
                                    </li>
                                </ul>
                            </li>

                        </ul>

                    </div>
                </nav>
            </header>
            <!--end top header-->


            <!-- start page content wrapper-->
            <div class="page-content-wrapper">
                <!-- start page content-->
                <div class="page-content">

                    <!--start breadcrumb-->
                    <div class="page-breadcrumb d-none d-sm-flex align-items-center mb-3">
                        <div class="breadcrumb-title pe-3">Feedback</div>
                        <div class="ps-3">
                            <nav aria-label="breadcrumb">
                                <ol class="breadcrumb mb-0 p-0 align-items-center">
                                    <li class="breadcrumb-item"><a href="javascript:;"><ion-icon name="home-outline"></ion-icon></a>
                                    </li>
                                    <li class="breadcrumb-item active" aria-current="page">Send Feedback</li>
                                </ol>
                            </nav>
                        </div>
                    </div>
                    <!--end breadcrumb-->



                    <div class="card">
                        <div class="card-body">
                            <div class="border p-3 rounded">
                                <h6 class="mb-0 text-uppercase">Contact Form</h6>
                                <hr>
                                <form class="row g-3">
                                    <div class="col-12">
                                        <label class="form-label">Content Feedback</label>
                                        <input class="form-control" type="text" placeholder="Enter content" name="txtContentFeedback" value="" required="">
                                    </div>
                                    <div class="col-12">
                                        <label class="form-label">User Name</label>
                                        <input class="form-control" type="text" placeholder="Enter your username" name="txtUsername" value="" required="">
                                    </div>
                                    <!--                                    <div class="col-12">
                                                                            <label class="form-label">Message</label>
                                                                            <textarea class="form-control" rows="4" cols="4"></textarea>
                                                                        </div>-->
                                    <div class="col-12">
                                        <div class="d-grid">
                                            <button type="submit" name="btn" value="Send Feedback" class="btn btn-primary">Send</button>
                                        </div>
                                    </div>
                                </form>
                            </div>
                        </div>
                    </div>


                    <!--end switcher-->


                    <!--start overlay-->
                    <div class="overlay nav-toggle-icon"></div>
                    <!--end overlay-->

                </div>
                <!--end wrapper-->





                <!-- JS Files-->
                <script src="assets/js/jquery.min.js"></script>
                <script src="assets/plugins/simplebar/js/simplebar.min.js"></script>
                <script src="assets/plugins/metismenu/js/metisMenu.min.js"></script>
                <script src="assets/js/bootstrap.bundle.min.js"></script>
                <script type="module" src="https://unpkg.com/ionicons@5.5.2/dist/ionicons/ionicons.esm.js"></script>
                <!--plugins-->
                <script src="assets/plugins/perfect-scrollbar/js/perfect-scrollbar.js"></script>

                <!-- Main JS-->
                <script src="assets/js/main.js"></script>


                </body>
                </html>
