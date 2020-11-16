<%--
  Created by IntelliJ IDEA.
  User: aliziwa
  Date: 15/11/2020
  Time: 18:28
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Header</title>
</head>
<body>
<div class="sidebar" data-color="purple" data-background-color="white" data-image="../assets/img/sidebar-1.jpg">
    <div class="logo"><a href="" class="simple-text logo-normal">
        iTravel
    </a></div>
    <div class="sidebar-wrapper">
        <ul class="nav">
            <li class="nav-item  ">
                <a class="nav-link" href="admin_dashboard.jsp">
                    <i class="material-icons">dashboard</i>
                    <p>Dashboard</p>
                </a>
            </li>
            <li class="nav-item ">
                <a class="nav-link" href="adminProf.jsp">
                    <i class="material-icons">person</i>
                    <p>Admin Profile</p>
                </a>
            </li>
            <li class="nav-item ">
                <a class="nav-link" href="deactivatedUsers.jsp">
                    <i class="material-icons">face</i>
                    <p>Deactivated User</p>
                </a>
            </li>
            <li class="nav-item ">
                <a class="nav-link" href="censoredWords.jsp">
                    <i class="material-icons">content_paste</i>
                    <p>Censored Words</p>
                </a>
            </li>
            <li class="nav-item ">
                <a class="nav-link" href="censoredPosts.jsp">
                    <i class="material-icons">library_books</i>
                    <p>Censored Posts</p>
                </a>
            </li>
        </ul>
    </div>
</div>
</body>
</html>
