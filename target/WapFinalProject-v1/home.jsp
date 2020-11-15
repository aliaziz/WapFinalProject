<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Home</title>
    <script src="assets/js/core/jquery.min.js"></script>
    <script src="assets/js/weather.js"></script>
    <script src="assets/js/post.js"></script>
</head>
<body>
    Welcome home.

    <a href="logoutServlet">Logout</a>
    <a href="profileServlet">Profile</a>
    <a href="postServlet">Post</a>
    <textarea name="post" id="post">Post</textarea>
    <button name="postPost" onclick="makePost()">Make Post</button><br>
    <button onclick="getPost()">Get post</button><br>
    <button onclick="getComments(6)">Get comment</button><br>
    <br>
    <textarea id="userSearch"></textarea>
    <button onclick="searchUser()">Search user</button>
    <br>
    <textarea id="postSearch"></textarea>
    <button onclick="searchPost()">Search Post</button>


    <br>
    <div>
        <ul class="post"></ul>
    </div>
    <div>
        <ul class="comments"></ul>
    </div>
    <script>

    </script>
</body>
</html>
