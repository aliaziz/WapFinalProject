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
              <textarea class="form-control" rows="3" placeholder="What are you thinking?">

              </textarea>
              <div class="mar-top clearfix">
                <button class="btn btn-round btn-primary pull-right" type="submit"><i
                        class="material-icons">create</i> Share
                </button>
                <a class="btn btn-round btn-just-icon  add-tooltip" href="#">
                  <i class="material-icons">videocam</i>
                </a>
                <a class="btn btn-round btn-just-icon  add-tooltip" href="#">
                  <i class="material-icons">camera_enhance</i>
                </a>
                <a class="btn btn-round btn-just-icon  add-tooltip" href="#">
                  <i class="material-icons">file_copy</i>
                </a>
              </div>
            </div>
          </div>
          <div class="card">
            <div class="card-body">
              <!-- Newsfeed Content -->
              <!--===================================================-->
              <div class="media-block">
                <a class="media-left" href="#"><img class="img-circle img-sm" alt="Profile Picture"
                                                    src="https://bootdey.com/img/Content/avatar/avatar1.png"></a>
                <div class="media-body">
                  <div class="mar-btm">
                    <a href="#" class="btn-link media-heading box-inline"><b>Lisa D.</b></a>
                    <p class="text-muted text-sm-left"><i class="material-icons">stay_current_portrait</i> - From Mobile - 11 min ago
                    </p>
                  </div>
                  <p>consectetuer adipiscing elit, sed diam nonummy nibh euismod tincidunt ut laoreet dolore magna
                    aliquam erat volutpat. Ut wisi enim ad minim veniam, quis nostrud exerci tation ullamcorper
                    suscipit lobortis nisl ut aliquip ex ea commodo consequat.</p>
                  <div class="pad-ver">
                    <span class="tag tag-sm"><i class="fa fa-heart text-danger"></i> 250 Likes</span>
                    <a class="btn btn-sm btn-round btn-default" href="#"><i
                            class="material-icons">thumb_up</i></a>
                    <a class="btn btn-sm btn-round btn-default" href="#"><i
                            class="material-icons">thumb_down</i></a>
                    <a class="btn btn-sm btn-round btn-primary" href="#">Comment</a>
                  </div>
                  <hr>

                  <!-- Comments -->
                  <div>
                    <div class="media-block">
                      <a class="media-left" href="#"><img class="img-circle img-sm" alt="Profile Picture"
                                                          src="https://bootdey.com/img/Content/avatar/avatar2.png"></a>
                      <div class="media-body">
                        <div class="mar-btm">
                          <a href="#" class="btn-link text-semibold media-heading box-inline">Bobby
                            Marz</a>
                          <p class="text-muted text-sm"><i class="fa fa-mobile fa-lg"></i> - From Mobile -
                            7 min ago</p>
                        </div>
                        <p>Sed diam nonummy nibh euismod tincidunt ut laoreet dolore magna aliquam erat
                          volutpat. Ut wisi enim ad minim veniam, quis nostrud exerci tation ullamcorper
                          suscipit lobortis nisl ut aliquip ex ea commodo consequat.</p>
                        <div class="pad-ver">
                          <a class="btn btn-sm btn-round btn-default" href="#"><i
                                  class="material-icons">thumb_up</i></a>
                          <a class="btn btn-sm btn-round btn-default" href="#"><i
                                  class="material-icons">thumb_down</i></a>
                          <a class="btn btn-sm btn-round btn-primary" href="#">Comment</a>
                        </div>
                        <hr>
                      </div>
                    </div>

                    <div class="media-block">
                      <a class="media-left" href="#"><img class="img-circle img-sm" alt="Profile Picture"
                                                          src="https://bootdey.com/img/Content/avatar/avatar3.png">
                      </a>
                      <div class="media-body">
                        <div class="mar-btm">
                          <a href="#" class="btn-link text-semibold media-heading box-inline">Lucy
                            Moon</a>
                          <p class="text-muted text-sm"><i class="fa fa-globe fa-lg"></i> - From Web - 2
                            min ago</p>
                        </div>
                        <p>Duis autem vel eum iriure dolor in hendrerit in vulputate ?</p>
                        <div class="pad-ver">
                          <a class="btn btn-sm btn-round btn-success" href="#"><i
                                  class="material-icons">thumb_up</i><b> you liked</b></a>
                          <a class="btn btn-sm btn-round btn-default" href="#"><i
                                  class="material-icons">thumb_down</i></a>
                          <a class="btn btn-sm btn-round btn-primary" href="#">Comment</a>
                        </div>
                        <hr>
                      </div>
                    </div>
                  </div>
                </div>
              </div>
              <!--===================================================-->
              <!-- End Newsfeed Content -->

              <!-- Newsfeed Content -->
              <!--===================================================-->
              <div class="media-block pad-all">
                <a class="media-left" href="#"><img class="img-circle img-sm" alt="Profile Picture"
                                                    src="https://bootdey.com/img/Content/avatar/avatar1.png"></a>
                <div class="media-body">
                  <div class="mar-btm">
                    <a href="#" class="btn-link text-semibold media-heading box-inline">John Doe</a>
                    <p class="text-muted text-sm"><i class="fa fa-mobile fa-lg"></i> - From Mobile - 11 min ago
                    </p>
                  </div>
                  <p>Lorem ipsum dolor sit amet.</p>
                  <img class="img-responsive thumbnail" src="https://via.placeholder.com/400x300" alt="Image">
                  <div class="pad-ver">
                    <span class="tag tag-sm"><i class="fa fa-heart text-danger"></i> 250 Likes</span>
                    <a class="btn btn-sm btn-round btn-default" href="#"><i
                            class="material-icons">thumb_up</i></a>
                    <a class="btn btn-sm btn-round btn-default" href="#"><i
                            class="material-icons">thumb_down</i></a>
                    <a class="btn btn-sm btn-round btn-primary" href="#">Comment</a>
                  </div>
                  <hr>

                  <!-- Comments -->
                  <div>
                    <div class="media-block pad-all">
                      <a class="media-left" href="#"><img class="img-circle img-sm" alt="Profile Picture"
                                                          src="https://bootdey.com/img/Content/avatar/avatar2.png"></a>
                      <div class="media-body">
                        <div class="mar-btm">
                          <a href="#" class="btn-link text-semibold media-heading box-inline">Maria
                            Leanz</a>
                          <p class="text-muted text-sm"><i class="fa fa-globe fa-lg"></i> - From Web - 2
                            min ago</p>
                        </div>
                        <p>Duis autem vel eum iriure dolor in hendrerit in vulputate ?</p>
                        <div class="pad-ver">
                          <span class="tag tag-sm"><i class="fa fa-heart text-danger"></i> 250 Likes</span>
                          <a class="btn btn-sm btn-round btn-default" href="#"><i
                                  class="material-icons">thumb_up</i></a>
                          <a class="btn btn-sm btn-round btn-default" href="#"><i
                                  class="material-icons">thumb_down</i></a>
                          <a class="btn btn-sm btn-round btn-primary" href="#">Comment</a>
                        </div>
                      </div>
                    </div>
                  </div>
                </div>
              </div>
              <!--===================================================-->
              <!-- End Newsfeed Content -->
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
  console.log("Checking..");
</script>
</body>

</html>