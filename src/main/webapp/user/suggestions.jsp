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
                <div class="col-lg-9 col-md-9">
                    <div class="card">
                        <div class="card-body ">
                            <div class="row">  <h5>People you may know</h5></div>
                            <div class="row" id="suggested-users-list"></div>
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
    $('ul.nav>li.nav-item:eq(2)').addClass("active");
</script>
</body>

</html>