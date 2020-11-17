<%--
  Created by IntelliJ IDEA.
  User: aliziwa
  Date: 16/11/2020
  Time: 15:09
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<body>
<div class="card-body">
    <!-- Sidebar -->
    <div class="sidebar" data-color="purple" data-background-color="white" data-image="../assets/img/sidebar-1.jpg">
        <div class="logo"><a href="#" class="simple-text logo-normal">
            iTravel
        </a></div>
        <div class="sidebar-wrapper">
            <ul class="nav">
                <li class="nav-item">
                    <a class="nav-link" href="homeServlet">
                        <i class="material-icons">dashboard</i>
                        <p>Home</p>
                    </a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="profileServlet">
                        <i class="material-icons">face</i>
                        <p>Profile</p>
                    </a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="suggestions.jsp">
                        <i class="material-icons">people</i>
                        <p>Find Friends</p>
                    </a>
                </li>
                <li hidden class="nav-item">
                    <a class="nav-link" href="places.jsp">
                        <i class="material-icons">flight</i>
                        <p>Find Places</p>
                    </a>
                </li>
            </ul>
        </div>
    </div>
</div>
</body>
</html>
