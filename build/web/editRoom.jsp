<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
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
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">

        <!--Theme Styles-->
        <link href="assets/css/dark-theme.css" rel="stylesheet" />
        <link href="assets/css/semi-dark.css" rel="stylesheet" />
        <link href="assets/css/header-colors.css" rel="stylesheet" />

        <title>Edit Room</title>
    </head>
    <body>


        <!--start wrapper-->
        <div class="wrapper">
            <c:set var="User" value="${sessionScope.USER}"/>
            <!--start sidebar -->
            <aside class="sidebar-wrapper" data-simplebar="true">
                <div class="sidebar-header">
                    <font color="yellow">
                    <div>
                        <h6>Welcome ${USER.name} (STAFF)</h6>
                    </div></font>
                    <div class="toggle-icon ms-auto"><ion-icon name="menu-sharp"></ion-icon>
                    </div>
                </div>
                <!--navigation-->
                <ul class="metismenu" id="menu">
                    <li>
                        <a href="javascript:;" class="has-arrow">
                            <div class="parent-icon">
                                <ion-icon name="home-sharp"></ion-icon>
                            </div>
                            <div class="menu-title">Management</div>
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
                            <li>
                                <a href="regulationManagement.jsp">
                                    <ion-icon name="ellipse-outline"></ion-icon>Regulation Management
                                </a>
                            </li>
                            <li>
                                <a href="feedback.jsp">
                                    <ion-icon name="ellipse-outline"></ion-icon>Feedback Management
                                </a>
                            </li>
                        </ul>
                    </li>
                    <li>
                        <a href="pages-staff-profile.jsp">
                            <div class="parent-icon"><ion-icon name="person-circle-sharp"></ion-icon>
                            </div>
                            <div class="menu-title">Staff Profile</div>
                        </a>
                    </li>
                    <li>
                        <a href="pages-edit-staff-profile.jsp">
                            <div class="parent-icon"><ion-icon name="create-sharp"></ion-icon>
                            </div>
                            <div class="menu-title">Edit Profile</div>
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
                            <c:if test="${not empty User}">
                                <li class="nav-item dropdown dropdown-user-setting">
                                    <a class="nav-link dropdown-toggle dropdown-toggle-nocaret" href="javascript:;" data-bs-toggle="dropdown">
                                        <div class="user-setting">
                                            <img src="${User.img}" class="user-img" alt="">
                                        </div>
                                    </a>
                                    <ul class="dropdown-menu dropdown-menu-end">

                                        <li>
                                            <a class="dropdown-item" href="#">
                                                <div class="d-flex flex-row align-items-center gap-2">
                                                    <img src="${User.img}" alt="" class="rounded-circle" width="54" height="54">
                                                    <div class="">
                                                        <h6 class="mb-0 dropdown-user-name">${User.name}</h6>
                                                        <small class="mb-0 dropdown-user-designation text-secondary">${User.address}</small>
                                                    </div>
                                                </div>
                                            </a>
                                        </li>
                                    </c:if>
                                    <li><hr class="dropdown-divider"></li>
                                    <li>
                                        <a class="dropdown-item" href="pages-user-profile.html">
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
                        <div class="breadcrumb-title pe-3">Room</div>
                        <div class="ps-3">
                            <nav aria-label="breadcrumb">
                                <ol class="breadcrumb mb-0 p-0 align-items-center">
                                    <li class="breadcrumb-item"><a href="javascript:;"><ion-icon name="home-outline"></ion-icon></a>
                                    </li>
                                    <li class="breadcrumb-item active" aria-current="page">Edit Room</li>
                                </ol>
                            </nav>
                        </div>
                    </div>
                    <!--end breadcrumb-->

                    <form action="MainController">
                        <input type="hidden" name="txtRoomId" value="${param.txtRoomId}" />
                        <input type="hidden" name="btn" value="Edit Room Detail" />

                    </form>
                    <form action="MainController"> 
                        <div class="row">
                            <div class="col-xl-12 mx-auto">
                                <h6 class="mb-0 text-uppercase">Tooltips</h6>
                                <hr/>
                                <div class="card">
                                    <div class="card-body">
                                        <div class="p-4 border rounded">

                                            <form class="row g-3 needs-validation" novalidate>
                                                <c:forEach var="dto" items="${requestScope.EDIT_ROOM_DETAIL}" >
                                                    <div class="col-md-4 position-relative">
                                                        <label for="validationTooltip01" class="form-label">Category Name</label>
                                                        <input type="text" class="form-control" id="validationTooltip01" value="${dto.categoryName}" required>
                                                    </div>
                                                    <div class="col-md-4 position-relative">
                                                        <label for="validationTooltip02" class="form-label">Room Id</label>
                                                        <input type="hidden" name="txtRoomId" value="${dto.roomId}" />
                                                        <input type="text" class="form-control" id="validationTooltip02" value="${dto.roomId}" disabled>
                                                    </div>
                                                    <div class="col-md-6 position-relative">
                                                        <label for="validationTooltip03" class="form-label">Room Name</label>
                                                        <input type="text" name="txtRoomName" value="${dto.roomName}" class="form-control" id="validationTooltip03" required>
                                                        <div class="invalid-tooltip">
                                                            Please provide a valid city.
                                                        </div>
                                                    </div>
                                                    <div class="col-md-6 position-relative">
                                                        <label for="validationTooltip04" class="form-label">Room Description</label>
                                                        <textarea type="text" name="txtRoomDescription" class="form-control" id="validationTooltip04" required>${dto.roomDescription}</textarea>
                                                        <div class="invalid-tooltip">
                                                            Please select a valid state.
                                                        </div>
                                                    </div>
                                                    <div class="col-md-3 position-relative">
                                                        <label for="validationTooltip05" class="form-label">Room Price</label>
                                                        <input type="text" name="txtRoomPrice" value="${dto.roomPrice}" class="form-control" id="validationTooltip05" required>
                                                        <div class="invalid-tooltip">
                                                            Please provide a valid zip.
                                                        </div>
                                                    </div>
                                                    <div class="mb-3">
                                                        <label for="validationTooltip06" class="form-label">Image</label>
                                                        <input type="file" name="txtImage" value="${dto.image}" class="form-control" aria-label="file example">
                                                    </div>
                                                </c:forEach> 
                                                <c:forEach var="dto1" items="${requestScope.EDIT_IMAGE_DETAIL}" > 
                                                            <img style="width: 370.75px; height: 247.36px;" src="images/${dto1.imageTmp}" class="card-img-top" alt="...">
                                                </c:forEach>
                                                <div class="col-12">
                                                    <button class="btn btn-primary" type="submit" name="btn" value="Update Room">Update Room</button>
                                                </div>
                                                <a href="MainController?txtSearchValue=&btn=SEARCH+ROOM" data-bs-toggle="tooltip" data-bs-placement="bottom" title="" data-bs-original-title="Return"  class="btn btn-primary"><i class="fa fa-arrow-circle-left" style="font-size:36px"></i></a>

                                            </form>

                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </form>
                    <!--end row-->


                </div>
                <!-- end page content-->
            </div>



            <!--Start Back To Top Button-->
            <a href="javaScript:;" class="back-to-top"><ion-icon name="arrow-up-outline"></ion-icon></a>
            <!--End Back To Top Button-->

            <!--start switcher-->
            <div class="switcher-body">
                <button class="btn btn-primary btn-switcher shadow-sm" type="button" data-bs-toggle="offcanvas" data-bs-target="#offcanvasScrolling" aria-controls="offcanvasScrolling"><ion-icon name="color-palette-sharp" class="me-0"></ion-icon></button>
                <div class="offcanvas offcanvas-end shadow border-start-0 p-2" data-bs-scroll="true" data-bs-backdrop="false" tabindex="-1" id="offcanvasScrolling">
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
                            <input class="form-check-input" type="radio" name="inlineRadioOptions" id="SemiDark" value="option3" checked>
                            <label class="form-check-label" for="SemiDark">Semi Dark</label>
                        </div>
                        <hr/>
                        <h6 class="mb-0">Header Colors</h6>
                        <hr/>
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
        <script>
            // Example starter JavaScript for disabling form submissions if there are invalid fields
            (function () {
                'use strict'

                // Fetch all the forms we want to apply custom Bootstrap validation styles to
                var forms = document.querySelectorAll('.needs-validation')

                // Loop over them and prevent submission
                Array.prototype.slice.call(forms)
                        .forEach(function (form) {
                            form.addEventListener('submit', function (event) {
                                if (!form.checkValidity()) {
                                    event.preventDefault()
                                    event.stopPropagation()
                                }

                                form.classList.add('was-validated')
                            }, false)
                        })
            })()
        </script>

        <!-- Main JS-->
        <script src="assets/js/main.js"></script>


    </body>
</html>