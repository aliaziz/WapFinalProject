<!--
=========================================================
Material Kit - v2.0.7
=========================================================

Product Page: https://www.creative-tim.com/product/material-kit
Copyright 2020 Creative Tim (https://www.creative-tim.com/)

Coded by Creative Tim

=========================================================

The above copyright notice and this permission notice shall be included in all copies or substantial portions of the Software. -->
<%@include file="header.jsp"%>

<div class="main main-raised">
  <div class="profile-content">
    <div class="container-fluid">
      <br><br>
      <div class="row">
        <div class="col-lg-3 col-md-3 ">
          <div class="card">
            <%@include file="menu.jsp"%>
          </div>
        </div>
        <div class="col-lg-6 col-md-6">
          <div class="card">
            <div class="card-body ">
              <div class="row">  <h5>People you may know</h5></div>
              <div class="row">

                <div class="col-lg-4 col-md-4 ">
                  <div class="card">
                    <div class="card-img-top">
                      <a href="#">
                        <img src="../assets/img/city-profile.jpg" alt="Image" style="max-width:100%;">
                      </a>
                      <p>
                        <b>will Smith</b><br>
                        <a class="btn btn-sm btn-round btn btn-primary" href="#">Follow</a>
                      </p>
                    </div>
                  </div>
                </div>
                <div class="col-lg-4 col-md-4 ">
                  <div class="card">
                    <div class="card-img-top">
                      <a href="#">
                        <img src="../assets/img/city-profile.jpg" alt="Image" style="max-width:100%;">
                      </a>
                      <p>
                        <b>will Smith</b><br>
                        <a class="btn btn-sm btn-round btn btn-primary" href="#">Follow</a>
                      </p>
                    </div>
                  </div>
                </div>
                <div class="col-lg-4 col-md-4 ">
                  <div class="card">
                    <div class="card-img-top">
                      <a href="#">
                        <img src="../assets/img/city-profile.jpg" alt="Image" style="max-width:100%;">
                      </a>
                      <p>
                        <b>will Smith</b><br>
                        <a class="btn btn-sm btn-round btn btn-primary" href="#">Follow</a>
                      </p>
                    </div>
                  </div>
                </div>
              </div>

            </div>
          </div>
          <div class="card">
            <div class="card-body">
              <form id="postUploadForm" enctype="multipart/form-data">
                <textarea class="form-control" id="postDescription" name="postDescription" rows="3" placeholder="What are you thinking?"></textarea>
                <div class="mar-top clearfix">
                  <button id="postForm" class="btn btn-round btn-primary pull-right" type="submit"><i
                          class="material-icons">create</i> Share
                  </button>
                  <input type="file" name="postImage" class="btn btn-default add-tooltip"/>
                  <div id="alert-section" style="display: none" class="alert" role="alert"></div>
              </div>
              </form>
            </div>
          </div>
          <div class="card">
            <div id="post-section" class="card-body">
            </div>
          </div>

        </div>
        <div class="col-lg-3 col-md-3 frame">
          <div class="card">
            <div class="card-body ">
              <a class="weatherwidget-io" href="https://forecast7.com/en/41d01n91d96/fairfield/" data-label_1="FAIRFIELD" data-label_2="WEATHER" data-icons="Climacons Animated" data-theme="candy" >FAIRFIELD WEATHER</a>
              <script>
                !function(d,s,id){var js,fjs=d.getElementsByTagName(s)[0];if(!d.getElementById(id)){js=d.createElement(s);js.id=id;js.src='https://weatherwidget.io/js/widget.min.js';fjs.parentNode.insertBefore(js,fjs);}}(document,'script','weatherwidget-io-js');
              </script>
            </div>
          </div>
        </div>
      </div>
    </div>
  </div>
</div>
<%@include file="footer.jsp"%>
<%@include file="core-files.jsp"%>
<script>
  $('ul.nav>li.nav-item:eq(0)').addClass(" active");
</script>
</body>

</html>