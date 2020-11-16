<%--
  Created by IntelliJ IDEA.
  User: aliziwa
  Date: 13/11/2020
  Time: 18:39
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Posts</title>
    <script src="assets/js/core/jquery.min.js"></script>
    <script src="assets/js/userjs/post.js"></script>
</head>
<body>
<ul>
    <c:forEach var="post" items="${sessionScope.posts}">
        <li>${post.description} has likes ${post.likes}</li>

        <textarea name="comment" id="comment">Comment</textarea>
        <button name="postComment" onclick="saveComment(${post.postId})">Make Comment</button>
        <br>


    </c:forEach>
</ul>
</body>
</html>
