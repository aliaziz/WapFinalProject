<%--
  Created by IntelliJ IDEA.
  User: aliziwa
  Date: 13/11/2020
  Time: 18:39
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@include file="assets/js/post.js"%>
<html>
<head>
    <title>Posts</title>
</head>
<body>
<ul>
    <c:forEach var="post" items="${sessionScope.posts}">
        <li>${post.description} has likes ${post.likes}</li>

        <textarea name="comment" id="comment">Comment</textarea>
        <textarea id="post_id" hidden>${post.postId}</textarea>
        <button name="postComment" onclick="makeComment()">Make Comment</button>
        <br>
        <a href="commentServlet?postId=${post.postId}">Comment</a>
    </c:forEach>
</ul>
</body>
</html>
