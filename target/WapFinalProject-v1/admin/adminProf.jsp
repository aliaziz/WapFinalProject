<!--
=========================================================
Material Dashboard - v2.1.2
=========================================================

Product Page: https://www.creative-tim.com/product/material-dashboard
Copyright 2020 Creative Tim (https://www.creative-tim.com)
Coded by Creative Tim

=========================================================
The above copyright notice and this permission notice shall be included in all copies or substantial portions of the Software. -->
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="utf-8" />
    <link rel="apple-touch-icon" sizes="76x76" href="../assets/img/apple-icon.png">
    <link rel="icon" type="image/png" href="../assets/img/favicon.png">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1" />
    <title>
        User Profile
    </title>
    <meta content='width=device-width, initial-scale=1.0, shrink-to-fit=no' name='viewport' />
    <!--     Fonts and icons     -->
    <link rel="stylesheet" type="text/css" href="https://fonts.googleapis.com/css?family=Roboto:300,400,500,700|Roboto+Slab:400,700|Material+Icons" />
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/latest/css/font-awesome.min.css">
    <!-- CSS Files -->
    <link href="../assets/css/material-dashboard.css" rel="stylesheet" />
</head>

<body class="">
<div class="wrapper ">
    <%@include file="header.jsp"%>
    <div class="main-panel">
        <!-- Navbar -->
        <%@include file="menu.jsp"%>
        <!-- End Navbar -->
        <div class="content">
            <div class="container-fluid">
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
                        <button type="button" class="btn btn-round btn-lg btn-danger">DEACTIVATE ACCOUNT</button>

                    </div>
                </div>
            </div>
        </div>
        <!--  End Modal -->
        <%@include file="footer.jsp"%>
    </div>
</div>
</body>
    <%@include file="core-files.jsp"%>
<script>
    $('li.nav-item:eq(1)').addClass("active");
</script>
</html>