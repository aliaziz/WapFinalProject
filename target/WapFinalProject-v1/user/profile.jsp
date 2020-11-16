<!--
=========================================================
Material Kit - v2.0.7
=========================================================

Product Page: https://www.creative-tim.com/product/material-kit
Copyright 2020 Creative Tim (https://www.creative-tim.com/)

Coded by Creative Tim

=========================================================

The above copyright notice and this permission notice shall be included in all copies or substantial portions of the Software. -->

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="utf-8"/>
    <link rel="apple-touch-icon" sizes="76x76" href="../assets/img/apple-icon.png">
    <link rel="icon" type="image/png" href="../assets/img/favicon.png">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1"/>
    <title>
        iTravel Home
    </title>
    <meta content='width=device-width, initial-scale=1.0, shrink-to-fit=no' name='viewport'/>
    <!--     Fonts and icons     -->
    <link rel="stylesheet" type="text/css"
          href="https://fonts.googleapis.com/css?family=Roboto:300,400,500,700|Roboto+Slab:400,700|Material+Icons"/>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/latest/css/font-awesome.min.css">
    <!-- CSS Files -->
    <link href="../assets/css/material-kit.css?v=2.0.7" rel="stylesheet"/>
    <script src="../assets/js/core/jquery.min.js"></script>
    <script src="../assets/js/profile.js"></script>
</head>

<body class="profile-page sidebar-collapse">
<nav class="navbar navbar-transparent navbar-color-on-scroll fixed-top navbar-expand-lg" color-on-scroll="100"
     id="sectionsNav">
    <div class="container">
        <div class="navbar-translate">
            <a class="navbar-brand" href="#">
                <b>iTravel</b>
            </a>
            <button class="navbar-toggler" type="button" data-toggle="collapse" aria-expanded="false"
                    aria-label="Toggle navigation">
                <span class="sr-only">Toggle navigation</span>
                <span class="navbar-toggler-icon"></span>
                <span class="navbar-toggler-icon"></span>
                <span class="navbar-toggler-icon"></span>
            </button>
        </div>
        <div class="collapse navbar-collapse justify-content-end ">
            <form class="navbar-form ml-auto">
                <div class="input-group no-border">
                    <input type="text" value="" class="form-control" placeholder="Search...">
                    <button type="submit" class="btn btn-primary btn-round btn-just-icon">
                        <i class="material-icons">search</i>
                        <div class="ripple-container"></div>
                    </button>
                </div>
            </form>
            <ul class="navbar-nav ">
                <li class="nav-item">
                    <a class="nav-link" href="#">
                        <i class="material-icons">dashboard</i>
                        <p class="d-lg-none d-md-block">
                            Stats
                        </p>
                    </a>
                </li>
                <li class="dropdown nav-item">
                    <a href="#" class="dropdown-toggle nav-link " data-toggle="dropdown">
                        <i class="material-icons ">notifications</i>
                        <span class="notification ">5</span>

                    </a>
                    <div class="dropdown-menu dropdown-with-icons">
                        <a class="dropdown-item" href="#">Mike John responded to your email</a>
                        <a class="dropdown-item" href="#">You have 5 new tasks</a>
                        <a class="dropdown-item" href="#">You're now friend with Andrew</a>
                        <a class="dropdown-item" href="#">Another Notification</a>
                        <a class="dropdown-item" href="#">Another One</a>
                    </div>
                </li>
                <li class="dropdown nav-item">
                    <a href="#" class="dropdown-toggle nav-link" data-toggle="dropdown">
                        <i class="material-icons">person</i>
                    </a>
                    <div class="dropdown-menu dropdown-with-icons">
                        <a class="dropdown-item" href="#">Profile</a>
                        <a class="dropdown-item" href="#">Settings</a>
                        <div class="dropdown-divider"></div>
                        <a class="dropdown-item" href="../logoutServlet">Log out</a>
                    </div>
                </li>
            </ul>
        </div>

    </div>
</nav>
<div class="page-header header-filter" data-parallax="true"
     style="background-image: url('../assets/img/city-profile.jpg'); height:200px; "></div>

<div class="main main-raised">
    <div class="profile-content">
        <div class="container-fluid">
            <br><br>
            <div class="row">
                <div class="col-lg-3 col-md-3 ">
                    <div class="card">
                        <div class="card-body">
                            <!-- Sidebar -->
                            <div class="sidebar" data-color="purple" data-background-color="white" data-image="../assets/img/sidebar-1.jpg">
                                <div class="logo"><a href="#" class="simple-text logo-normal">
                                    iTravel
                                </a></div>
                                <div class="sidebar-wrapper">
                                    <ul class="nav">
                                        <li class="nav-item">
                                            <a class="nav-link" href="home.html">
                                                <i class="material-icons">dashboard</i>
                                                <p>Home</p>
                                            </a>
                                        </li>
                                        <li class="nav-item active">
                                            <a class="nav-link" href="profile.jsp">
                                                <i class="material-icons">face</i>
                                                <p>Profile</p>
                                            </a>
                                        </li>
                                        <li class="nav-item ">
                                            <a class="nav-link" href="suggestions.html">
                                                <i class="material-icons">people</i>
                                                <p>Find Friends</p>
                                            </a>
                                        </li>
                                        <li class="nav-item">
                                            <a class="nav-link" href="places.html">
                                                <i class="material-icons">flight</i>
                                                <p>Find Places</p>
                                            </a>
                                        </li>
                                    </ul>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
                <div class="col-lg-9 col-md-9">
                    <div class="row">
                        <div class="col-md-8">
                            <div class="card">
                                <div class="card-header card-header-primary">
                                    <h4 class="card-title">Edit Profile</h4>
                                    <p class="card-category">Complete your profile</p>
                                </div>
                                <div class="card-body">
                                    <form method="post" id="profileForm">
                                        <div class="row">
                                            <div class="col-md-6">
                                                <div class="form-group">
                                                    <label for="username" class="bmd-label-floating">Username</label>
                                                    <input id="username" name="userName" disabled type="text" class="form-control" value="${sessionScope.profile.userName}">
                                                </div>
                                            </div>
                                            <div class="col-md-6">
                                                <div class="form-group">
                                                    <label for="email" class="bmd-label-floating">Email address</label>
                                                    <input id="email" name="email" disabled type="email" class="form-control" value="${sessionScope.profile.email}">
                                                </div>
                                            </div>
                                        </div>
                                        <div class="row">
                                            <div class="col-md-6">
                                                <div class="form-group">
                                                    <label for="fullname" class="bmd-label-floating">Full Name</label>
                                                    <input id="fullname" name="fullname" type="text" class="form-control" value="${sessionScope.profile.fullName}">
                                                </div>
                                            </div>
                                            <div class="col-md-6">
                                                <div class="form-group">
                                                    <label class="bmd-label-floating">State</label>
                                                    <input type="text" name="state" class="form-control" id="state" value="${sessionScope.profile.state}">
                                                </div>
                                            </div>
                                        </div>
                                        <div class="row">
                                            <div class="col-md-12">
                                                <div class="form-group">
                                                    <label class="bmd-label-floating">Street</label>
                                                    <input type="text" id="street" name="street" class="form-control" value="${sessionScope.profile.street}">
                                                </div>
                                            </div>
                                        </div>
                                        <div class="row">
                                            <div class="col-md-4">
                                                <div class="form-group">
                                                    <label class="bmd-label-floating">City</label>
                                                    <input type="text" name="city" id="city" class="form-control" value="${sessionScope.profile.city}">
                                                </div>
                                            </div>
                                            <div class="col-md-4">
                                                <div class="form-group">
                                                    <label class="bmd-label-floating">Gender</label>
                                                    <input type="text" name="gender" id="gender" class="form-control" value="${sessionScope.profile.gender}">
                                                </div>
                                            </div>
                                            <div class="col-md-4">
                                                <div class="form-group">
                                                    <label class="bmd-label-floating">Zip Code</label>
                                                    <input type="text" name="zipcode" id="zipcode" class="form-control" value="${sessionScope.profile.zipCode}">
                                                </div>
                                            </div>
                                        </div>
                                        <br>
                                        <div class="row">
                                            <div class="togglebutton">
                                                <label>
                                                    <input type="checkbox" checked="">
                                                    Send out notification alert on post :
                                                    <span class="toggle"></span>
                                                </label>
                                            </div>
                                        </div>
                                        <div class="row">
                                            <div class="col-md-12" hidden>
                                                <div class="form-group">
                                                    <label>About Me</label>
                                                    <div class="form-group">
                                                        <label class="bmd-label-floating"> Tell us about Yourself.</label>
                                                        <textarea class="form-control" rows="5"></textarea>
                                                    </div>
                                                </div>
                                            </div>
                                        </div>
                                        <input type="submit" id="updateProfileBtn" class="btn btn-primary pull-right" value="Update Profile"/>
                                        <div class="clearfix"></div>
                                    </form>
                                </div>
                            </div>
                        </div>
                        <div class="col-md-4">
                            <div class="card card-profile">
                                <div class="card-avatar">
                                    <a href="javascript:;">
                                        <img class="img" src="../assets/img/profile.jpg" />
                                    </a>
                                </div>
                                <div class="card-body">
                                    <h6 class="card-category text-gray">${sessionScope.profile.email}</h6>
                                    <h4 class="card-title">${sessionScope.profile.fullName}</h4>
                                    <p class="card-description">
                                       Coming soon.
                                    </p>
                                    <button class="btn btn-round btn-primary" onclick="deactivateUser()">
                                        Deactivate Account
                                    </button>
                                </div>
                            </div>
                        </div>
                    </div>
                    <!-- Classic Modal -->
                    <div class="modal fade" id="myModal" tabindex="-1" role="dialog">
                        <div class="modal-dialog modal-dialog-centered" role="document">
                            <div class="modal-content">
                                <div class="modal-header">
                                    <h5 class="modal-title"><b>PERMANENT DEACTIVATION</b></h5>
                                    <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                                        <i class="material-icons">clear</i>
                                    </button>
                                </div>
                                <div class="modal-body">
                                    <p>Are you sure you want to deactivate your account. Once deactivated, only admin can reactivate it.</p>
                                    <p>Click deactivate button below to deactivate.</p>
                                </div>
                                <div class="modal-footer">
                                    <button type="button" onclick="deactivateUser()" class="btn btn-round btn-lg btn-danger">DEACTIVATE ACCOUNT</button>
                                </div>
                            </div>
                        </div>
                    </div>
                    <!--  End Modal -->

                </div>
            </div>
        </div>
    </div>
</div>
<footer class="footer footer-default">
    <div class="container">
        <nav class="float-left">
            <ul>
                <li>
                    <a href="#">
                        Kampalans
                    </a>
                </li>
                <li>
                    <a href="#">
                        About Us
                    </a>
                </li>
            </ul>
        </nav>
        <div class="copyright float-right">
            &copy;
            <script>
                document.write(new Date().getFullYear())
            </script>
            , made with <i class="material-icons">favorite</i> by
            <a href="#" target="_blank">Kampalans</a> for a better web.
        </div>
    </div>
</footer>
<!--   Core JS Files   -->
<script src="../assets/js/core/jquery.min.js" type="text/javascript"></script>
<script src="../assets/js/core/popper.min.js" type="text/javascript"></script>
<script src="../assets/js/core/bootstrap-material-design.min.js" type="text/javascript"></script>
<script src="../assets/js/plugins/moment.min.js"></script>
<!--	Plugin for the Datepicker, full documentation here: https://github.com/Eonasdan/bootstrap-datetimepicker -->
<script src="../assets/js/plugins/bootstrap-datetimepicker.js" type="text/javascript"></script>
<!--  Plugin for the Sliders, full documentation here: http://refreshless.com/nouislider/ -->
<script src="../assets/js/plugins/nouislider.min.js" type="text/javascript"></script>
<!--  Google Maps Plugin    -->
<!-- Control Center for Material Kit: parallax effects, scripts for the example pages etc -->
<script src="../assets/js/material-kit.js" type="text/javascript"></script>
</body>

</html>