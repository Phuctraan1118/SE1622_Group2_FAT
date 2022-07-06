<%-- 
    Document   : Staff
    Created on : May 30, 2022, 10:32:42 PM
    Author     : buikh
--%>

<%@page import="form.UserError"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page import="java.util.List"%>
<%@page import="form.UserDisplayForm"%>
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
        <link href="assets/plugins/simplebar/css/simplebar.css" rel="stylesheet" />
        <link href="assets/plugins/perfect-scrollbar/css/perfect-scrollbar.css" rel="stylesheet" />
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

        <link rel="stylesheet" href="//code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
        <script src="https://code.jquery.com/jquery-1.12.4.js"></script>
        <script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>

        <title>Room Management</title>
        <style>
            .error{
                color: red;
            }
            .success{
                color: green;
            }
        </style>
    </head>

    <body>
        <!--start wrapper-->
        <div class="wrapper">
            <c:set var="User" value="${sessionScope.USER}"/>
            <!--start sidebar -->
            <aside class="sidebar-wrapper" data-simplebar="true">
                <div class="sidebar-header">
                    <div>
                        <img src="assets/images/good1.png" class="logo-icon" alt="logo icon">
                    </div>
                    <div>
                        <h4 class="logo-text">Staff</h4>
                    </div>
                    <div class="toggle-icon ms-auto">
                        <ion-icon name="menu-sharp"></ion-icon>
                    </div>
                </div>
                <!--navigation-->
                <ul class="metismenu" id="menu">
                    <li class="mm-active">
                        <a href="javascript:;" class="has-arrow">
                            <div class="parent-icon">
                                <ion-icon name="home-sharp"></ion-icon>
                            </div>
                            <div class="menu-title">Room Management</div>
                        </a>
                        <ul>
                            <li> <a href="staff.jsp">
                                    <ion-icon name="ellipse-outline"></ion-icon>Staff Management
                                </a>
                            </li>
                            <li>
                                <a href="customer.jsp">
                                    <ion-icon name="ellipse-outline"></ion-icon>Customer Management
                                </a>
                            </li>
                            <li>
                                <a href="managementRoom.jsp">
                                    <ion-icon name="ellipse-outline"></ion-icon>Room Management
                                </a>
                            </li>
                            <li>
                                <a href="bookingManagement.jsp">
                                    <ion-icon name="ellipse-outline"></ion-icon>Booking Management
                                </a>
                            </li>
                        </ul>
                    </li>
                    <li>
                        <a href="pages-staff-profile.jsp">
                            <div class="parent-icon">
                                <ion-icon name="person-circle-sharp"></ion-icon>
                            </div>
                            <div class="menu-title">Staff Profile</div>
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
                    <!--                    <li class="menu-label">STAFF</li>-->
                    <!--                    <li>
                                            <a class="has-arrow" href="javascript:;">
                                                <div class="parent-icon">
                                                    <ion-icon name="lock-closed-sharp"></ion-icon>
                                                <div class="menu-title">Au                                                </div>
thentication</div>
                                            </a>
                                            <ul>
                                                <li> <a href="authentication-sign-in-simple.html" target="_blank">
                                                        <ion-icon name="ellipse-outline"></ion-icon>Sign In Simple
                                                    </a>
                                                </li>
                                                <li> <a href="authentication-sign-up-simple.html" target="_blank">
                                                        <ion-icon name="ellipse-outline"></ion-icon>Sign Up Simple
                                                    </a>
                                                </li>
                                                <li> <a href="authentication-reset-password-simple.html" target="_blank">
                                                        <ion-icon name="ellipse-outline"></ion-icon>Reset Password Simple
                                                    </a>
                                                </li>
                                            </ul>
                                        </li>-->
                </ul>
                <!--end navigation-->
            </aside>
            <!--end sidebar -->

            <!--start top header-->
            <header class="top-header">
                <nav class="navbar navbar-expand gap-3">
                    <div class="mobile-menu-button">
                        <ion-icon name="menu-sharp"></ion-icon>
                    </div>
                    <form action="MainController" class="searchbar">
                        <div class="position-absolute top-50 translate-middle-y search-icon ms-3">
                            <ion-icon name="search-sharp"></ion-icon>
                        </div>
                        <input class="form-control" type="text" name="txtSearchValue" value="${param.txtSearchValue}" placeholder="Search description">
                        <input type="hidden" value="SEARCH ROOM" name="btn" />
                        <div class="position-absolute top-50 translate-middle-y search-close-icon">
                            <ion-icon name="close-sharp"></ion-icon>
                        </div>
                    </form>

                    <div class="top-navbar-right ms-auto">

                        <ul class="navbar-nav align-items-center">
                            <li class="nav-item mobile-search-button">
                                <a class="nav-link" href="javascript:;">
                                    <div class="">
                                        <ion-icon name="search-sharp"></ion-icon>
                                    </div>
                                </a>
                            </li>
                            <li class="nav-item">
                                <a class="nav-link dark-mode-icon" href="javascript:;">
                                    <div class="mode-icon">
                                        <ion-icon name="moon-sharp"></ion-icon>
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
                                                <div class="notify text-primary">
                                                    <ion-icon name="cart-outline"></ion-icon>
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
                                                <div class="notify text-danger">
                                                    <ion-icon name="person-outline"></ion-icon>
                                                </div>
                                                <div class="flex-grow-1">
                                                    <h6 class="msg-name">New Staffs<span class="msg-time float-end">14 Sec
                                                            ago</span></h6>
                                                    <p class="msg-info">5 new user registered</p>
                                                </div>
                                            </div>
                                        </a>
                                        <a class="dropdown-item" href="javascript:;">
                                            <div class="d-flex align-items-center">
                                                <div class="notify text-success">
                                                    <ion-icon name="document-outline"></ion-icon>
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
                                                <div class="notify text-info">
                                                    <ion-icon name="checkmark-done-outline"></ion-icon>
                                                </div>
                                                <div class="flex-grow-1">
                                                    <h6 class="msg-name">New Product Approved <span class="msg-time float-end">2 hrs ago</span></h6>
                                                    <p class="msg-info">Your new product has approved</p>
                                                </div>
                                            </div>
                                        </a>
                                        <a class="dropdown-item" href="javascript:;">
                                            <div class="d-flex align-items-center">
                                                <div class="notify text-warning">
                                                    <ion-icon name="send-outline"></ion-icon>
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
                                                <div class="notify text-danger">
                                                    <ion-icon name="chatbox-ellipses-outline"></ion-icon>
                                                </div>
                                                <div class="flex-grow-1">
                                                    <h6 class="msg-name">New Comments <span class="msg-time float-end">4 hrs
                                                            ago</span></h6>
                                                    <p class="msg-info">New Staff comments recived</p>
                                                </div>
                                            </div>
                                        </a>
                                        <a class="dropdown-item" href="javascript:;">
                                            <div class="d-flex align-items-center">
                                                <div class="notify text-primary">
                                                    <ion-icon name="albums-outline"></ion-icon>
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
                                                <div class="notify text-success">
                                                    <ion-icon name="shield-outline"></ion-icon>
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
                                                <div class="notify text-warning">
                                                    <ion-icon name="cafe-outline"></ion-icon>
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
                                        <img src="${User.img}" class="user-img" alt="">
                                    </div>
                                </a>
                                <ul class="dropdown-menu dropdown-menu-end">
                                    <li>
                                        <a class="dropdown-item" href="javascript:;">
                                            <div class="d-flex flex-row align-items-center gap-2">
                                                <img src="${User.img}" alt="" class="rounded-circle" width="54" height="54">
                                                <div class="">
                                                    <h6 class="mb-0 dropdown-user-name">${User.name}</h6>
                                                    <small class="mb-0 dropdown-user-designation text-secondary">${User.address}</small>
                                                </div>
                                            </div>
                                        </a>
                                    </li>
                                    <li>
                                        <hr class="dropdown-divider">
                                    </li>
                                    <li>
                                        <a class="dropdown-item" href="pages-user1-profile.jsp">
                                            <div class="d-flex align-items-center">
                                                <div class="">
                                                    <ion-icon name="person-outline"></ion-icon>
                                                </div>
                                                <div class="ms-3"><span>Profile</span></div>
                                            </div>
                                        </a>
                                    </li>
                                    <li>
                                        <a class="dropdown-item" href="javascript:;">
                                            <div class="d-flex align-items-center">
                                                <div class="">
                                                    <ion-icon name="settings-outline"></ion-icon>
                                                </div>
                                                <div class="ms-3"><span>Setting</span></div>
                                            </div>
                                        </a>
                                    </li>
                                    <li>
                                        <a class="dropdown-item" href="javascript:;">
                                            <div class="d-flex align-items-center">
                                                <div class="">
                                                    <ion-icon name="speedometer-outline"></ion-icon>
                                                </div>
                                                <div class="ms-3"><span>Room Management</span></div>
                                            </div>
                                        </a>
                                    </li>
                                    <li>
                                        <a class="dropdown-item" href="javascript:;">
                                            <div class="d-flex align-items-center">
                                                <div class="">
                                                    <ion-icon name="wallet-outline"></ion-icon>
                                                </div>
                                                <div class="ms-3"><span>Earnings</span></div>
                                            </div>
                                        </a>
                                    </li>
                                    <li>
                                        <a class="dropdown-item" href="javascript:;">
                                            <div class="d-flex align-items-center">
                                                <div class="">
                                                    <ion-icon name="cloud-download-outline"></ion-icon>
                                                </div>
                                                <div class="ms-3"><span>Downloads</span></div>
                                            </div>
                                        </a>
                                    </li>
                                    <li>
                                        <hr class="dropdown-divider">
                                    </li>
                                    <li>
                                        <a class="dropdown-item" href="MainController?btn=Logout">
                                            <div class="d-flex align-items-center">
                                                <div class="">
                                                    <ion-icon name="log-out-outline"></ion-icon>
                                                </div>
                                                <div class="ms-3"><span name="btn">Logout</span></div>
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
                        <div class="breadcrumb-title pe-3">Management</div>
                        <div class="ps-3">
                            <nav aria-label="breadcrumb">
                                <ol class="breadcrumb mb-0 p-0 align-items-center">
                                    <li class="breadcrumb-item"><a href="javascript:;">
                                            <ion-icon name="home-outline"></ion-icon>
                                        </a>
                                    </li>
                                    <li class="breadcrumb-item active" aria-current="page">Room Management</li>
                                </ol>
                            </nav>
                        </div>
                        <div class="ms-auto">
                            <div class="btn-group">
                                <button type="button" class="btn btn-outline-primary">Settings</button>
                                <button type="button"
                                        class="btn btn-outline-primary split-bg-primary dropdown-toggle dropdown-toggle-split"
                                        data-bs-toggle="dropdown"> <span class="visually-hidden">Toggle Dropdown</span>
                                </button>
                                <div class="dropdown-menu dropdown-menu-right dropdown-menu-lg-end"> <a class="dropdown-item"
                                                                                                        href="javascript:;">Action</a>
                                    <a class="dropdown-item" href="javascript:;">Another action</a>
                                    <a class="dropdown-item" href="javascript:;">Something else here</a>
                                    <div class="dropdown-divider"></div> <a class="dropdown-item" href="javascript:;">Separated link</a>
                                </div>
                            </div>
                        </div>
                    </div>
                    <!--end breadcrumb-->
                    <div class="card radius-10 w-100">
                        <div class="card-body">
                            <div class="d-flex align-items-center">
                                <h6 class="mb-0">List Of Staff</h6>
                            </div>
                            <div class="table-responsive mt-2">
                                <table class="table align-middle mb-0">
                                    <thead class="table-light">
                                        <tr>
                                            <th>No</th>
                                            <th>ID ROOM</th>
                                            <th>DESCRIPTION</th>
                                            <th>PRICE</th>
                                            <th>IMAGE</th>
                                            <th>EDIT</th>
                                            <th>DELETE</th>
                                        </tr>
                                    </thead>
                                    <tbody>
                                        <c:forEach var="dto" items="${requestScope.SEARCHRESULT}" varStatus="counter">
                                        <form action="MainController" method="POST">
                                            <c:set var="errors1" value="${requestScope.CREATEERRORS1}"/>
                                            <tr>
                                                <td>${counter.count}</td>
                                                <td>
                                                    <div class="d-flex align-items-center gap-3">
                                                        <div class="product-info">
                                                            <h6 class="product-name mb-1"><input type="text" name="txtUsername" class="form-control" id="validationDefault02" required="" value="${dto.roomId}"></h6>
                                                        </div>
                                                    </div>
                                                </td>
                                                <td>
                                                    <div class="box-input">
                                                        <input type="text" name="txtFullName" class="form-control" id="validationDefault02" required="" value="${dto.roomDescription}">
                                                    </div>
                                                </td>
                                                <td>
                                                    <div class="box-input">
                                                        <input type="text" name="txtAddress" class="form-control" id="validationDefault02" required="" value="${dto.roomPrice}">
                                                    </div>
                                                </td>
                                                <td><img src=images/${dto.image} style="width: 100px; height: 100px;"></td>
                                                <td>
                                                    <div class="d-flex align-items-center gap-3 fs-6">
                                                        <!--                                                        <button type="submit" name="btn" value="Update Staff" class="text-warning" data-bs-toggle="tooltip" data-bs-placement="bottom"
                                                                                                                        title="" data-bs-original-title="Update info" aria-label="Update">
                                                                                                                    <ion-icon name="pencil-sharp"></ion-icon>
                                                                                                                </button> -->
                                                        <a href="editRoom.jsp?txtRoomId=${dto.roomId}&txtRoomDescription=${dto.roomDescription}
                                                           &txtRoomPrice=${dto.roomPrice}&txtImage=${dto.image}">Edit</a>
                                                        <input type="hidden" name="txtSearchValue" value="${param.txtSearchValue}"/>
                                                    </div>
                                                </td>
                                                <td>
                                                    <div class="d-flex align-items-center gap-3 fs-6">
                                                        <button type="submit" name="btn" value="Delete Room" class="text-warning" data-bs-toggle="tooltip" data-bs-placement="bottom"
                                                                title="" data-bs-original-title="Delete info" onclick="return ConfirmDelete();" " aria-label="Delete">
                                                            <ion-icon name="trash-sharp"></ion-icon>
                                                        </button>
                                                        <input type="hidden" name="txtSearchValue" value="${param.txtSearchValue}"/>
                                                        <input type="hidden" name="txtRoomId" value="${dto.roomId}"/>
                                                    </div>
                                                </td>
                                            </tr>
                                        </form>
                                    </c:forEach>
                                    </tbody>
                                </table>
                            </div>
                            <div class="card-body">
                                <div class="card-title">
                                    <hr>
                                    <nav aria-label="Page navigation example">
                                        <ul class="pagination">
                                            <li class="page-item"><a class="page-link" href="javascript:;">Previous</a>
                                            </li>
                                            <li class="page-item"><a class="page-link" href="javascript:;javascript:;">1</a>
                                            </li>
                                            <li class="page-item"><a class="page-link" href="javascript:;">2</a>
                                            </li>
                                            <li class="page-item"><a class="page-link" href="javascript:;">3</a>
                                            </li>
                                            <li class="page-item"><a class="page-link" href="javascript:;">Next</a>
                                            </li>
                                        </ul>
                                    </nav>
                                </div>
                            </div>
                        </div>

                    </div>
                    <br/>
                    <button onclick="showOrHideDiv()" class="row col-md-3 btn btn-primary" name="btn">ADD NEW ROOM</button>
                    <!-- end page content-->
                    <div id="showOrHide">
                        <div class="card-body">

                            <div class="table-responsive mt-2">
                                <table class="table align-middle mb-0">
                                    <div class="row">
                                        <div class="col-xl-12 mx-auto">
                                            <div class="card">
                                                <div class="card-body">
                                                    <div class="p-4 border rounded">
                                                        <form class="row g-3" action="MainController" method="POST">
                                                            <c:set var="errors" value="${requestScope.CREATEERRORS}"/>
                                                            <div class="row align-content-center">
                                                                <div class="col-md-3">
                                                                    <label for="validationDefault01" class="form-label">Room Description</label>
                                                                    <input type="text" class="form-control" id="validationDefault01" name="txtCreateRoomDescription" value="${param.txtCreateRoomDescription}" required="">
                                                                    <p class="error">${errors.roomDescriptionLengthError}</p>
                                                                </div>
                                                                <div class="col-md-3">
                                                                    <label for="validationDefault02" class="form-label">Price</label>
                                                                    <input type="text" class="form-control" name="txtCreateRoomPrice" value="${param.txtCreateRoomPrice}" required="">
                                                                    <p class="error">${errors.priceStringError}</p>
                                                                </div>
                                                                <div class="col-md-3">
                                                                    <label for="validationDefault03" class="form-label">Image</label>
                                                                    <input type="file"  name="txtCreateImage" value="${param.txtCreateImage}" class="form-control" aria-label="file example" required>
                                                                </div>
                                                                <div class="col-12">
                                                                    <button type="submit" class="btn btn-primary" name="btn" value="ADD ROOM">ADD ROOM</button>
                                                                </div>
                                                            </div>
                                                        </form>
                                                    </div>
                                                </div>
                                            </div>
                                        </div>
                                    </div>
                                    </tbody>
                                </table>
                            </div>
                        </div>
                    </div>

                    <!--                    <div class="card-body">
                                            <form action="MainController" class="searchbar">
                                                <div class="position-absolute top-50 translate-middle-y search-icon ms-3">
                                                    <ion-icon name="search-sharp"></ion-icon>
                                                </div>
                                                <input class="form-control" type="text" type="text" name="txtSearchValueBooked" value="${param.txtSearchValueBooked}" placeholder="search username">
                                                <input type="hidden" value="SEARCH OWNED ROOM" name="btn" />
                                                                        <div class="position-absolute top-50 translate-middle-y search-close-icon">
                                                                            <ion-icon name="close-sharp"></ion-icon>
                                                                        </div>
                                            </form>
                                            <div class="d-flex align-items-center">
                                                <h6 class="mb-0">View Booked Room</h6>
                                                <div class="fs-5 ms-auto dropdown">
                                                    <div class="dropdown-toggle dropdown-toggle-nocaret cursor-pointer" data-bs-toggle="dropdown"><i
                                                            class="bi bi-three-dots"></i></div>
                                                    <ul class="dropdown-menu">
                                                        <li><a class="dropdown-item" href="#">Action</a></li>
                                                        <li><a class="dropdown-item" href="#">Another action</a></li>
                                                        <li>
                                                            <hr class="dropdown-divider">
                                                        </li>
                                                        <li><a class="dropdown-item" href="#">Something else here</a></li>
                                                    </ul>
                                                </div>
                                            </div>-->
                    <!--                        <div class="table-responsive mt-2">
                                                <div class="card">
                                                    <div class="card-body">
                                                        <div class="p-4 border rounded">
                                                            <table class="table align-middle mb-0">
                                                                <thead class="table-light">
                                                                    <tr>
                                                                        <th>No</th>
                                                                        <th>ID ROOM</th>
                                                                        <th>DESCRIPTION</th>
                                                                        <th>PRICE</th>
                                                                        <th>BOOKING DATE</th>
                                                                        <th>CHECK IN DATE</th>
                                                                        <th>CHECK OUT DATE</th>
                                                                        <th>USERNAME</th>
                                                                        <th>STATUS</th>
                                                                        <th>IMAGE</th>
                                                                        <th>EDIT</th>
                                                                        <th>DELETE</th>
                                                                    </tr>
                                                                </thead>
                                                                <tbody>
                    <c:forEach var="dtoBooked" items="${requestScope.SEARCH_BOOKED}" varStatus="counter">
                    <form action="MainController" method="POST">
                        <c:set var="errors1" value="${requestScope.CREATEERRORS1}"/>
                        <tr>
                            <td>${counter.count}</td>
                            <td>
                                <div class="d-flex align-items-center gap-3">
                                    <div class="product-info">
                                        <h6 class="product-name mb-1"><input type="text" name="txtUsername" class="form-control" id="validationDefault02" required="" value="${dtoBooked.roomId}"></h6>
                                        <input type="hidden" name="txtRoomId1" required="" value="${dtoBooked.roomId}"/>
                                        <input type="hidden" name="txtBookingId" value="${dtoBooked.bookingId}" />
                                    </div>
                                </div>


                            </td>
                            <td>
                                <div class="box-input">
                                    <input type="text" class="form-control" id="validationDefault02" required="" value="${dtoBooked.roomDescription}">
                                </div>
                            </td>
                            <td>
                                <div class="box-input">
                                    <input type="text" class="form-control" id="validationDefault02" required="" value="${dtoBooked.roomPrice}">
                                </div>
                            </td>
                            <td>
                                <div class="box-input">
                                    <input type="text"  class="form-control" id="validationDefault02" required="" value="${dtoBooked.bookingDate}">
                                </div>
                            </td>
                            <td>
                                <div class="box-input">
                                    <input type="text" class="form-control" id="validationDefault02" required="" value="${dtoBooked.checkinDate}">
                                </div>
                            </td>
                            <td>
                                <div class="box-input">
                                    <input type="text" class="form-control" id="validationDefault02" required="" value="${dtoBooked.checkoutDate}">
                                </div>
                            </td>
                            <td>
                                <div class="box-input">
                                    <input type="text" class="form-control" id="validationDefault02" required="" value=" ${dtoBooked.username}">
                                </div>
                            </td>
                            <td>
                        <c:if test="${dtoBooked.status == 'B'}">Booked</c:if>
                        <input type="hidden" name="txtStatus1" value="${dtoBooked.status}" />

                    </td>
                    <td><img src=images/${dtoBooked.image} style="width: 100px; height: 100px;"></td>
                    <td>

                        <a  href="editOwnedRoom.jsp?txtRoomId1=${dtoBooked.roomId}&txtRoomDescription1=${dtoBooked.roomDescription}
                            &txtRoomPrice1=${dtoBooked.roomPrice}&txtBookingDate=${dtoBooked.bookingDate}
                            &txtCheckInDate=${dtoBooked.checkinDate}
                            &txtCheckOutDate=${dtoBooked.checkoutDate}
                            &txtUsername=${dtoBooked.username}&txtStatus1=${dtoBooked.status}
                            &txtImage1=${dtoBooked.image}&txtBookingId=${dtoBooked.bookingId}"
                            >Edit</a>

                    </td> 
                    <td>
                        <input type="submit" name="btn" value="Delete Booked Room" />
                        <input type="hidden" name="txtSearchValueBooked" value="${param.txtSearchValueBooked}"/>
                        <input type="hidden" name="txtBookingId" value="${dtoBooked.bookingId}"/>
                    </td>
                </tr>
            </form>
                    </c:forEach>
                    </tbody>
                </table>
            </div>
        </div>
    </div>
</div>
<div class="card-body">
    <div class="card-title">
        <hr>
        <nav aria-label="Page navigation example">
            <ul class="pagination">
                <li class="page-item"><a class="page-link" href="javascript:;">Previous</a>
                </li>
                <li class="page-item"><a class="page-link" href="javascript:;javascript:;">1</a>
                </li>
                <li class="page-item"><a class="page-link" href="javascript:;">2</a>
                </li>
                <li class="page-item"><a class="page-link" href="javascript:;">3</a>
                </li>
                <li class="page-item"><a class="page-link" href="javascript:;">Next</a>
                </li>
            </ul>
        </nav>
    </div>
</div>-->
                </div>
            </div>


            <!--end page content wrapper-->
            <!--start footer-->
            <footer class="footer">
                <div class="footer-text">
                    Copyright © 2021. All right reserved.
                </div>
            </footer>
            <!--end footer-->


            <!--Start Back To Top Button-->
            <a href="javaScript:;" class="back-to-top">
                <ion-icon name="arrow-up-outline"></ion-icon>
            </a>
            <!--End Back To Top Button-->

            <!--start switcher-->
            <div class="switcher-body">
                <button class="btn btn-primary btn-switcher shadow-sm" type="button" data-bs-toggle="offcanvas"
                        data-bs-target="#offcanvasScrolling" aria-controls="offcanvasScrolling">
                    <ion-icon name="color-palette-sharp" class="me-0"></ion-icon>
                </button>
                <div class="offcanvas offcanvas-end shadow border-start-0 p-2" data-bs-scroll="true" data-bs-backdrop="false"
                     tabindex="-1" id="offcanvasScrolling">
                    <div class="offcanvas-header border-bottom">
                        <h5 class="offcanvas-title" id="offcanvasScrollingLabel">Theme Customizer</h5>
                        <button type="button" class="btn-close text-reset" data-bs-dismiss="offcanvas"></button>
                    </div>
                    <div class="offcanvas-body">
                        <h6 class="mb-0">Theme Variation</h6>
                        <hr>
                        <div class="form-check form-check-inline">
                            <input class="form-check-input" type="radio" name="inlineRadioOptions" id="LightTheme" value="option1">
                            <label class="form-check-label" for="LightTheme">Light</label>
                        </div>
                        <div class="form-check form-check-inline">
                            <input class="form-check-input" type="radio" name="inlineRadioOptions" id="DarkTheme" value="option2">
                            <label class="form-check-label" for="DarkTheme">Dark</label>
                        </div>
                        <div class="form-check form-check-inline">
                            <input class="form-check-input" type="radio" name="inlineRadioOptions" id="SemiDark" value="option3"
                                   checked>
                            <label class="form-check-label" for="SemiDark">Semi Dark</label>
                        </div>
                        <hr />
                        <h6 class="mb-0">Header Colors</h6>
                        <hr />
                        <div class="header-colors-indigators">
                            <div class="row row-cols-auto g-3">
                                <div class="col">
                                    <div class="indigator headercolor1" id="headercolor1"></div>
                                </div>
                                <div class="col">
                                    <div class="indigator headercolor2" id="headercolor2"></div>
                                </div>
                                <div class="col">
                                    <div class="indigator headercolor3" id="headercolor3"></div>
                                </div>
                                <div class="col">
                                    <div class="indigator headercolor4" id="headercolor4"></div>
                                </div>
                                <div class="col">
                                    <div class="indigator headercolor5" id="headercolor5"></div>
                                </div>
                                <div class="col">
                                    <div class="indigator headercolor6" id="headercolor6"></div>
                                </div>
                                <div class="col">
                                    <div class="indigator headercolor7" id="headercolor7"></div>
                                </div>
                                <div class="col">
                                    <div class="indigator headercolor8" id="headercolor8"></div>
                                </div>
                            </div>
                        </div>

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
        <script src="assets/plugins/apexcharts-bundle/js/apexcharts.min.js"></script>
        <script src="assets/plugins/chartjs/chart.min.js"></script>
        <script src="assets/js/index.js"></script>
        <!-- Main JS-->
        <script src="assets/js/main.js"></script>

        <!--        <script>
                    function ConfirmDelete(){
                        return confirm("Are you sure you want to delete?");
                    }
                </script>-->

        <script>
                    function showOrHideDiv() {
                        var show = document.getElementById("showOrHide");
                        if (show.style.display === "none") {
                            show.style.display = "block";
                        } else {
                            show.style.display = "none";
                        }
                    }
                    function ConfirmDelete() {
                        return confirm("Are you sure you want to delete?");
                    }
        </script>
    </body>

</html>
