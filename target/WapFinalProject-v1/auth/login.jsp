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
        iTravel
    </title>
    <meta content='width=device-width, initial-scale=1.0, shrink-to-fit=no' name='viewport'/>
    <!--     Fonts and icons     -->
    <link rel="stylesheet" type="text/css"
          href="https://fonts.googleapis.com/css?family=Roboto:300,400,500,700|Roboto+Slab:400,700|Material+Icons"/>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/latest/css/font-awesome.min.css">
    <!-- CSS Files -->
    <link href="../assets/css/material-kit.css" rel="stylesheet"/>
</head>

<body class="login-page sidebar-collapse">
<nav class="navbar navbar-transparent navbar-color-on-scroll fixed-top navbar-expand-lg" color-on-scroll="100"
     id="sectionsNav">
    <div class="container">
        <div class="navbar-translate">
            <a class="navbar-brand" href="#">
                <b>iTravel</b> </a>
            <button class="navbar-toggler" type="button" data-toggle="collapse" aria-expanded="false"
                    aria-label="Toggle navigation">
                <span class="sr-only">Toggle navigation</span>
                <span class="navbar-toggler-icon"></span>
                <span class="navbar-toggler-icon"></span>
                <span class="navbar-toggler-icon"></span>
            </button>
        </div>
        <div class="collapse navbar-collapse">
            <ul class="navbar-nav ml-auto">
                <li class="nav-item">
                    <a class="nav-link" href="register.jsp">
                        Register
                    </a>
                </li>
            </ul>
        </div>
    </div>
</nav>
<div class="page-header header-filter"
     style="background-image: url('../assets/img/bg7.jpg'); background-size: cover; background-position: top center;">
    <div class="container">
        <div class="row">
            <div class="col-lg-4 col-md-6 ml-auto mr-auto">
                <div class="card card-login">
                    <form class="form" method="POST" action="loginServlet">
                        <div class="card-header card-header-primary text-center">
                            <h4 class="card-title">Login</h4>
                            <div class="social-line">
                                <a href="#pablo" class="btn btn-just-icon btn-link">
                                    <i class="fa fa-facebook-square"></i>
                                </a>
                                <a href="#pablo" class="btn btn-just-icon btn-link">
                                    <i class="fa fa-twitter"></i>
                                </a>
                                <a href="#pablo" class="btn btn-just-icon btn-link">
                                    <i class="fa fa-google-plus"></i>
                                </a>
                            </div>
                        </div>
                        <p class="description text-center">Or Be Classical</p>
                        <div class="card-body">
                            <div class="input-group">
                                <div class="input-group-prepend">
                    <span class="input-group-text">
                      <i class="material-icons">face</i>
                    </span>
                                </div>
                                <input type="text" name="email" required class="form-control"
                                       placeholder="Email...">
                            </div>
                            <div class="input-group">
                                <div class="input-group-prepend">
                    <span class="input-group-text">
                      <i class="material-icons">lock_outline</i>
                    </span>
                                </div>
                                <input type="password" required name="password" class="form-control"
                                       placeholder="Password...">
                            </div>
                            <div class="input-group">
                                <div class="input-group-prepend">
                    <span class="input-group-text">
                      <i class="material-icons"></i>
                    </span>
                                </div>
                                <c:if test="${param.error}">
                                    <div class="alert alert-danger">
                                        <div class="alert-icon">
                                            <i class="material-icons">error_outline</i>
                                        </div>
                                        <button type="button" class="close" data-dismiss="alert" aria-label="Close">
                                            <span aria-hidden="true"><i class="material-icons">clear</i></span>
                                        </button>
                                        <b>Error Alert:</b> ${param.errorMessage}
                                    </div>
                                </c:if>

                                <a href="recoverAcc.jsp">Re-activate Account</a>
                            </div>

                        </div>
                        <div class="footer text-center">
                            <input type="submit" class="btn btn-primary btn-round btn-md" value="Login"/>
                        </div>
                    </form>
                </div>
            </div>
        </div>
    </div>
    <footer class="footer">
        <div class="container">
            <div class="copyright float-right">
                &copy;
                <script>
                    document.write(new Date().getFullYear())
                </script>
                , made with <i class="material-icons">favorite</i> by
                <a href="" target="_blank">Kampalans</a> for a better web.
            </div>
        </div>
    </footer>
</div>
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
<script src="../assets/js/material-kit.js?v=2.0.7" type="text/javascript"></script>
</body>

</html>

