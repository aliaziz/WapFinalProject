<%--
  Created by IntelliJ IDEA.
  User: aliziwa
  Date: 13/11/2020
  Time: 19:30
  To change this template use File | Settings | File Templates.
--%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Comments</title>
</head>
<body>

<ul>
<c:forEach var="comment" items="${requestScope.comments}">
    <li>${comment.comment}</li>
</c:forEach>
</ul>
</body>
</html>
