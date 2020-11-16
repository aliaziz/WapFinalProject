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
    <script src="../assets/js/censored.js"></script>
</head>

<body class="">
<div class="wrapper ">
    <%@include file="header.jsp"%>
    <div class="main-panel">
        <!-- Navbar -->
        <%@include file="menu.jsp"%>
        <!-- End Navbar -->
        <!-- content -->
        <div class="content">
            <div class="container-fluid">
                <div class="row">
                    <div class="col-lg-12 col-md-12">
                        <div class="card">
                            <div class="card-header card-header-primary">
                                <h4 class="card-title">Censored Words</h4>
                                <button class="btn btn-light" style="float: right" onclick="add()">Add new word</button>
                                <p class="card-category"></p>
                            </div>
                            <div class="card-body table-responsive">
                                <table class="table table-hover">
                                    <thead class="text-warning">
                                    <th>Word</th>
                                    <th>Edit</th>
                                    <th>Remove</th>
                                    </thead>
                                    <tbody>

                                    <c:forEach var="word" items="${sessionScope.censoredWords}">
                                        <tr>
                                            <td>
                                                <b>${word}</b>
                                            </td>
                                            <td>
                                                <button type="button" onclick="edit('${word}')" rel="tooltip" title="Edit"
                                                        class="btn btn-warning btn-link btn-sm">
                                                    <i class="material-icons">Edit</i>
                                                </button>
                                            </td>
                                            <td>
                                                <button type="button" onclick="remove('${word}')" rel="tooltip" title="Remove"
                                                        class="btn btn-danger btn-link btn-sm">
                                                    <i class="material-icons">close</i>
                                                </button>
                                            </td>
                                        </tr>
                                    </c:forEach>
                                    </tbody>
                                </table>
                            </div>
                        </div>
                    </div>
                </div>
                <div class="row">
                    <ul class="pagination pagination-info ">
                        <li class="page-item"><a href="javascript:void(0);" class="page-link"> prev</a></li>
                        <li class="page-item"><a href="javascript:void(0);" class="page-link">1</a></li>
                        <li class="page-item"><a href="javascript:void(0);" class="page-link">2</a></li>
                        <li class="active page-item"><a href="javascript:void(0);" class="page-link">3</a></li>
                        <li class="page-item"><a href="javascript:void(0);" class="page-link">4</a></li>
                        <li class="page-item"><a href="javascript:void(0);" class="page-link">5</a></li>
                        <li class="page-item"><a href="javascript:void(0);" class="page-link">next </a></li>
                    </ul>
                </div>
            </div>
        </div>
        <!-- End content -->
        <%@include file="footer.jsp"%>
    </div>
</div>
<!--   Core JS Files   -->
<%@include file="core-files.jsp"%>
<script>
    $('li.nav-item:eq(3)').addClass("active");
</script>
</body>

</html>