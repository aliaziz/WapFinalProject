<%--
  Created by IntelliJ IDEA.
  User: aliziwa
  Date: 13/11/2020
  Time: 15:40
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

<span>
    <c:out value="${sessionScope.profile.city}"/>
</span>
</body>
</html>
