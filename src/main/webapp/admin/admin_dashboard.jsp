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
            <div class="col-lg-4 col-md-6 col-sm-6">
              <div class="card card-stats">
                <div class="card-header card-header-warning card-header-icon">
                  <div class="card-icon">
                    <i class="material-icons">voice_over_off</i>
                  </div>
                  <p class="card-category">Deactivated Users </p>
                  <h3 class="card-title">${sessionScope.disabledUserCount}</h3>
                </div>
                <div class="card-footer">
                  <div class="stats">
                    <i class="material-icons text-danger">warning</i>
                    <a href="disabledUserServlet">Goto page</a>
                  </div>
                </div>
              </div>
            </div>
            <div class="col-lg-4 col-md-6 col-sm-6">
              <div class="card card-stats">
                <div class="card-header card-header-danger card-header-icon">
                  <div class="card-icon">
                    <i class="material-icons">info_outline</i>
                  </div>
                  <p class="card-category">Censored Posts</p>
                  <h3 class="card-title">${sessionScope.censoredPostsCount}</h3>
                </div>
                <div class="card-footer">
                  <div class="stats">
                    <i class="material-icons">local_offer</i> Tracked from filters
                  </div>
                </div>
              </div>
            </div>
            <div class="col-lg-4 col-md-6 col-sm-6">
              <div class="card card-stats">
                <div class="card-header card-header-info card-header-icon">
                  <div class="card-icon">
                    <i class="fa fa-twitter"></i>
                  </div>
                  <p class="card-category">Number of Posts</p>
                  <h3 class="card-title">+${sessionScope.allPostsCount}</h3>
                </div>
                <div class="card-footer">
                  <div class="stats">
                    <i class="material-icons">update</i> Just Updated
                  </div>
                </div>
              </div>
            </div>
          </div>
          <div hidden class="row">
            <div class="col-lg-12 col-md-12">
              <div class="card">
                <div class="card-header card-header-primary">
                  <h4 class="card-title">User Stats</h4>
                  <p class="card-category">User activity as of 15th November, 2020</p>
                </div>
                <div class="card-body table-responsive">
                  <table class="table table-hover">
                    <thead class="text-warning">
                    <th>ID</th>
                    <th>Name</th>
                    <th>Posts</th>
                    <th>Comments</th>
                    </thead>
                    <tbody>
                    <tr>
                      <td>1</td>
                      <td>Mary Talemwa</td>
                      <td>367</td>
                      <td>131</td>
                    </tr>
                    <tr>
                      <td>2</td>
                      <td>Ali Zziwa</td>
                      <td>367</td>
                      <td>131</td>
                    </tr>
                    <tr>
                      <td>3</td>
                      <td>Charlei Kiwabs</td>
                      <td>367</td>
                      <td>131</td>
                    </tr>
                    <tr>
                      <td>4</td>
                      <td>Thor Odinson</td>
                      <td>367</td>
                      <td>131</td>
                    </tr>
                    </tbody>
                  </table>
                </div>
              </div>
            </div>
          </div>
        </div>
      </div>
      <%@include file="footer.jsp"%>
    </div>
  </div>
  <!--   Core JS Files   -->
  <%@include file="core-files.jsp"%>
  <script>
    $('li.nav-item:eq(0)').addClass("active");
  </script>
</body>

</html>