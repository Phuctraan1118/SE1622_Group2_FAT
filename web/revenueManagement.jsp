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

        <!--Theme Styles-->
        <link href="assets/css/dark-theme.css" rel="stylesheet" />
        <link href="assets/css/semi-dark.css" rel="stylesheet" />
        <link href="assets/css/header-colors.css" rel="stylesheet" />

        <title>Revenue Management</title>
    </head>
    <body>


        <!--start wrapper-->
        <div class="wrapper">
            <c:set var="User" value="${sessionScope.USER}"/>
            <!--start sidebar -->
            <aside class="sidebar-wrapper" data-simplebar="true">
                <div class="sidebar-header">
                    <font color="red">
                    <div>
                        <h6>Welcome ${USER.name} (ADMIN)</h6>
                    </div></font>
                    <div class="toggle-icon ms-auto">
                        <ion-icon name="menu-sharp"></ion-icon>
                    </div>
                </div>
                <!--navigation-->

                <ul class="metismenu" id="menu">
                    <li class="menu-label">Pages</li>
                    <li>
                        <a href="admin.jsp">
                            <div class="parent-icon">
                                <ion-icon name="person-circle-sharp"></ion-icon>
                            </div>
                            <div class="menu-title">User Profile</div>
                        </a>
                    </li>
                    <li>
                        <a href="admin.jsp">
                            <div class="parent-icon">
                                <ion-icon name="create-sharp"></ion-icon>
                            </div>
                            <div class="menu-title">Edit Profile</div>
                        </a>
                    </li>
                    <li>
                        <a href="revenueManagement.jsp">
                            <div class="parent-icon">
                                <ion-icon name="wallet-sharp"></ion-icon>
                            </div>
                            <div class="menu-title">View Revenue</div>
                        </a>
                    </li>
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

                    <div class="top-navbar-right ms-auto">

                        <ul class="navbar-nav align-items-center">
                            <li class="nav-item">
                                <a class="nav-link dark-mode-icon" href="javascript:;">
                                    <div class="mode-icon">
                                        <ion-icon name="moon-sharp"></ion-icon>
                                    </div>
                                </a>
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
                        <div class="breadcrumb-title pe-3">Pages</div>
                        <div class="ps-3">
                            <nav aria-label="breadcrumb">
                                <ol class="breadcrumb mb-0 p-0 align-items-center">
                                    <li class="breadcrumb-item"><a href="javascript:;"><ion-icon name="home-outline"></ion-icon></a>
                                    </li>
                                    <li class="breadcrumb-item active" aria-current="page">Revenue Management</li>
                                </ol>
                            </nav>
                        </div>
                        <form action="MainController" class="searchbar">
                            <input type="submit" value="View Revenue" name="btn" />
                        </form>
                    </div>
                    <!--end breadcrumb-->

                    <div class="card radius-10">
                        <div class="card-header py-3">
                            <div class="row align-items-center g-3">
                                <div class="col-12 col-lg-6">
                                    <h5 class="mb-0">Management Revenue</h5>
                                </div>
                                <div class="col-12 col-lg-6 text-md-end">
                                    <a href="javascript:;" onclick="window.print()" class="btn btn-secondary"><ion-icon name="print-sharp"></ion-icon>Print</a>
                                </div>
                            </div>
                        </div>
                        <div class="card-body">
                            <div class="table-responsive">
                                <table class="table table-invoice">
                                    <thead>
                                        <tr>
                                            <th class="text-center">NO</th>
                                            <th class="text-center">BILL ID</th>
                                            <th class="text-center">ROOM ID</th>
                                            <th class="text-center">BILL NAME</th>
                                            <th class="text-center">DATE</th>
                                            <th class="text-center">ROOM PRICE</th>
                                            <th class="text-center">WATER PRICE</th>
                                            <th class="text-center">ELECTRONIC PRICE</th>
                                            <th class="text-center">TOTAL</th>
                                        </tr>
                                    </thead>
                                    <tbody>
                                        <c:forEach var="dto" items="${requestScope.SHOW_REVENUE}" varStatus="counter">
                                        <form action="MainController" method="POST">
                                            <tr>
                                                <td>
                                                    <span class="text-inverse">${counter.count}</span><br>
                                                </td>
                                                <td class="text-center">${dto.billId}</td>
                                                <td class="text-center">${dto.roomId}</td>
                                                <td class="text-center">${dto.billName}</td>
                                                <td class="text-center">${dto.date}</td>
                                                <td class="text-center">${dto.roomPrice}</td>
                                                <td class="text-center">${dto.waterPrice}</td>
                                                <td class="text-center">${dto.electronicPrice}</td>
                                                <td class="text-center">${dto.total}</td>
                                                <c:set var="result" value="${result + dto.total}" />
                                            </tr>
                                        </form>
                                    </c:forEach>
                                    </tbody>
                                </table>
                            </div>

                            <div class="row bg-light align-items-center m-0">
                                <div class="col col-7 p-8">
                                    <p class="mb-0">SUBTOTAL</p>
                                    <h4 id="subtotal"class="mb-0"></h4>
                                </div>
                                <div class="col text-center btn-dark col-5 p-4">
                                    <p class="mb-0 text-white">TOTAL$</p>
                                    <h4 id="result" class="mb-0 text-white"></h4>
                                </div>
                            </div><!--end row-->

                            <hr>
                            <!-- begin invoice-note -->
                            <!--                            <div class="my-3">
                                                            * Make all cheques payable to [Your Company Name]<br>
                                                            * Payment is due within 30 days<br>
                                                            * If you have any questions concerning this invoice, contact  [Name, Phone Number, Email]
                                                        </div>-->
                            <!-- end invoice-note -->
                        </div>

                        <div class="card-footer py-3 bg-transparent">
                            <p class="text-center mb-2">
                                THANK YOU
                            </p>
                            <p class="text-center d-flex align-items-center gap-3 justify-content-center mb-0">
                                <span class=""><i class="bi bi-globe"></i> www.domain.com</span>
                                <span class=""><i class="bi bi-telephone-fill"></i> T:+(84)845-646-648</span>
                                <span class=""><i class="bi bi-envelope-fill"></i> info@example.com</span>
                            </p>
                        </div>
                    </div>


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
                                        let num = ${result};
                                        let n = num.toFixed(2);

                                        document.getElementById("result").innerHTML = n;
        </script>
        <script>
                                        let numb = ${result};
                                        let subtotal = numb.toFixed(6);

                                        document.getElementById("subtotal").innerHTML = subtotal;
        </script>
        <!-- Main JS-->
        <script src="assets/js/main.js"></script>


    </body>
</html>